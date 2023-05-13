package simpleManager2.core.view;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleManager2.api.controller.ViewController;
import simpleManager2.core.controller.TestController;
import simpleManager2.api.controller.ViewControllerDispatcher;
import simpleManager2.ViewContainer;
import simpleManager2.ViewManager;
import simpleManager2.api.view.perspective.PerspectiveConstraint;


//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/view/AbstractViewManager.java
public abstract class AbstractViewManager implements ViewManager
{
	private static final Logger logger = LoggerFactory.getLogger(AbstractViewManager.class);
	private JFrame frame;
	private ViewControllerDispatcher 	dispatcher;
	private Map<Object,ViewContainer> 	views;

	public JFrame getFrame() {
		return frame;
	}
	public AbstractViewManager(){
		this.views = new HashMap<Object,ViewContainer>();
	}
	public void addView	(ViewContainer view,PerspectiveConstraint constraint)  
	{	
		logger.info("add_view_called");
		Map<Object,ViewContainer> 				viewContainerCollection = this.getViews();		
		ViewContainer 							viewContainer 			= viewContainerCollection.get(view.getId());	
		ViewControllerDispatcher				controllerDispatcher	= this.getControllerDispatcher();
		Map<String,List<ViewController<? extends EventListener, ? extends EventObject>>>	controllers 			= null;
		String									viewId					= view.getId();
	
		
		
		if (viewId!=null && viewContainer == null)
		{
			logger.info("adding_view_id:"+viewId);
			//model 		= modelManager.getViewModelMap(viewId);
			//viewModel	= view.getViewModelMap();
			
			
			controllers = controllerDispatcher.getViewControllers(view);
			
			this.getViews().put(viewId,view);
			List<ViewController<? extends EventListener, ? extends EventObject>> viewControllers = new ArrayList<ViewController<? extends EventListener, ? extends EventObject>>();
			viewControllers.add(new TestController());
			
			
			
			view.getViewControllerMap().put("SwingBuilderViewId.searchButton",viewControllers);
			view.getViewControllerMap().put("SwingBuilderViewId.assignmentsButton",viewControllers);
			view.viewInit();
			Component component = view.getRootPane();
			if(null !=component) {
				System.out.println("component_is_not_null");
			}else {
				System.out.println("component_is_null");
			}
		//	JFrame frame = this.getFrame();
			//frame.add(component);
			this.getPerspective().addView(view,constraint);
		//	JFrame frame = this.getFrame();
			//frame.add(this.getPerspective().getComponent());
		}
		
	}
	public void addView(ViewContainer view)  {
		this.addView(view,null);
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public ViewControllerDispatcher getControllerDispatcher() {
		return this.dispatcher;
	}

	public void setControllerDispatcher(ViewControllerDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
	/* (non-Javadoc)
	 * @see org.viewa.view.ViewManager#getViews()
	 */
	public Map<Object, ViewContainer> getViews() {
		return this.views;
	}
	
	public Container arrangeViews() 
	{
		Map<Object,ViewContainer> cviews 					= new HashMap<Object, ViewContainer>();
		Collection<ViewContainer> viewContainerCollection 	= this.getViews().values();
		logger.info("abstract_vm: "+viewContainerCollection);
	 /* ViewManager and Perspectives can make different decisions about its views so
	  * it is mandatory to create different view collections. */
		for (ViewContainer view : viewContainerCollection){
			cviews.put(view.getId(), view);
		}
		logger.info("abstract_vm_cviews: "+cviews);
		this.getPerspective().setViews(cviews);
		return this.getPerspective().arrange();
	}
	public void removeView(ViewContainer view){
		logger.info("remove_view_is_called");
		if (view.getId()!=null){
			logger.info("checkPost_1");
		/* First the view is removed from the application holder */
			ViewContainer view2Close = this.getViews().remove(view.getId());
			logger.info("checkPost_2");
		/* If the view still exists is removed from the current perspective */
			if (view2Close!=null){
				logger.info("checkPost_3");
				view2Close.viewClose();			
			 /* Floatable views like dialogs and frames are not added to any perspective so theys couldnt be removed from any perspective */
				
			}
		}
		logger.info("remove_view_is_finished");
	}

}
