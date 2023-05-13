package simpleManager2.core.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import simpleManager2.ViewContainer;
import simpleManager2.ViewManager;

/**
 * @author Mario Garcia
 * @since 1.0.2
 * 
 */
public class TestController extends  AbstractViewController<ActionListener, ActionEvent> {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.viewaframework.controller.ViewController#getSupportedClass()
	 */
	
	public TestController() {
		super();
	}
	
	public Class<ActionListener> getSupportedClass() {
		return ActionListener.class;
	}
	/*
	@Override
	public ViewManager getViewManager() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
/*
	@Override
	public AbstractViewController getTargetController() {
		// TODO Auto-generated method stub
		return null;
	}*/
	/*@Override
	public void executeHandler(ViewContainer view, ActionEvent eventObject) {
		// TODO Auto-generated method stub
		logger.info("execute_Handler_called");
		logger.info("view_id:"+view.getId());
		logger.info("eventObject:"+eventObject.getID());
		logger.info("eventObject:"+eventObject.getSource());
		//button_text that fired the action : eventObject.getActionCommand());
		String buttonText = eventObject.getActionCommand();
		super.executeHandler(view, eventObject);
		
	}*/
	/*@Override
	public void handleView(ViewContainer view, ActionEvent eventObject) {
		// TODO Auto-generated method stub
		logger.info("handleView");
	}
	*/
	@Override
	public void postHandlingView(ViewContainer view, ActionEvent eventObject) {
		// TODO Auto-generated method stub
		logger.info("post_handle");
	}
	/*
	@Override
	public void preHandlingView(ViewContainer view, ActionEvent eventObject) {
		// TODO Auto-generated method stub
		logger.info("preHandlingView");
	}

*/
	@Override
	public void handleView(ViewContainer view, ActionEvent eventObject) {
		logger.info("handle_view_on_test_controller");
		logger.info("handle_view:"+view.getId());
	}

	
}