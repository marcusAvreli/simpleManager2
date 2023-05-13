package simpleManager2.core.controller;

import java.lang.reflect.Method;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleManager2.Application;
import simpleManager2.ViewContainer;
import simpleManager2.ViewManager;
import simpleManager2.api.controller.ViewController;

//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/controller/AbstractViewController.java
public abstract class AbstractViewController <EL extends EventListener,EO extends EventObject> 
implements ViewController<EL,EO>{
	private ViewContainer currentView;
	private ViewManager viewManager;
	private static final Logger logger = LoggerFactory.getLogger(AbstractViewController.class);
	/* (non-Javadoc)
	 * @see org.viewaframework.controller.ViewController#executeHandler(org.viewaframework.view.ViewContainer, java.util.EventObject)
	 */
	public void executeHandler(final ViewContainer view, final EO eventObject) {
		this.currentView = view;
		logger.info("execute_handler_called");
	 /* Creating a new "Background" Thread */
		Runnable runnable = new Runnable(){
			public void run(){
				SwingUtilities.invokeLater(new Runnable(){
					public void run(){
					
						 /* Before executing the background logic the pre-view-logic is
						  * executed within the EDT scope */
							preHandlingView(view,eventObject);		
					
					}
				});
			 /* Executing the background logic */
				afterPreHandlingView(view,eventObject);
			}
		};
	 /* Launching the thread */
		new Thread(runnable).start();
	}
	
	/**
	 * This method is called to ensure that the method postHandlingView is always called
	 * when the background logic within the handleView method is done.
	 * 
	 * TODO When something goes wrong there should be two possible postXXX methods
	 * a postHandlingView and a postHandlingViewOnError in case the handleView has
	 * thrown an error.
	 * 
	 * @param view
	 * @param eventObject
	 */
	private void afterPreHandlingView(final ViewContainer view, final EO eventObject) {
	 /* Executing some background logic */
		
			this.handleView(view, eventObject);		
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
				
						postHandlingView(view, eventObject);
				
				}
			});
		
		
	}
	
	/* (non-Javadoc)
	 * @see org.viewaframework.controller.ViewController#getViewManager()
	 */
	public ViewManager getViewManager(){
		return this.viewManager;
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.controller.ViewController#handleView(org.viewaframework.view.ViewContainer, java.util.EventObject)
	 */
	public void handleView(final ViewContainer view, final EO eventObject){ 
		logger.info("handle view");
		
		
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.controller.ViewController#postHandlingView(org.viewaframework.view.ViewContainer, java.util.EventObject)
	 */
	public void postHandlingView(ViewContainer view, EO eventObject){ }
	
	/* (non-Javadoc)
	 * @see org.viewaframework.controller.ViewController#postHandlingViewOnError(org.viewaframework.view.ViewContainer, java.util.EventObject, org.viewaframework.controller.BackgroundException)
	 */
///	public void postHandlingViewOnError(ViewContainer view, EO eventObject,BackgroundException th) throws ViewException{ }

	/* (non-Javadoc)
	 * @see org.viewaframework.controller.ViewController#preHandlingView(org.viewaframework.view.ViewContainer, java.util.EventObject)
	 */
	public void preHandlingView(ViewContainer view, EO eventObject)  { }

	/* (non-Javadoc)
	 * @see org.viewaframework.controller.ListenerProxy#getTargetController()
	 */
	public ViewController<EL, EO> getTargetController() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args){
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.viewaframework.view.ViewContainerLocatorAware#locate(java.lang.Class)
	 */
	
}
