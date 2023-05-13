package simpleManager2;

import java.awt.Component;

import javax.swing.JFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleManager2.api.controller.ViewControllerDispatcher;
import simpleManager2.api.view.perspective.PerspectiveConstraint;
import simpleManager2.core.controller.CertificationView;
import simpleManager2.core.controller.DefaultViewControllerDispatcher;
import simpleManager2.core.controller.SwingBuilderView;
import simpleManager2.core.view.DefaultViewManager;
import simpleManager2.core.view.perspective.DefaultPerspective;

//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/core/AbstractApplication.java
public class MainFrame  extends JFrame{
	private static final Logger logger = LoggerFactory.getLogger(MainFrame.class);
	private ViewControllerDispatcher 	dispatcher;
	public ViewControllerDispatcher getControllerDispatcher() {
		return this.dispatcher;
	}

	public void setControllerDispatcher(ViewControllerDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
	public MainFrame() {
		this.dispatcher 			= new DefaultViewControllerDispatcher();
		initComponents();
	}
	
	public void initComponents() {

		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		ViewContainer def = new SwingBuilderView();
		ViewContainer def2 = new CertificationView();
		
		logger.info("containers_initialized");
		
		ViewManager vm = new DefaultViewManager(this,new DefaultPerspective());
		
		vm.setControllerDispatcher(dispatcher);		
		vm.addView(def,PerspectiveConstraint.LEFT);
		vm.addView(def2,PerspectiveConstraint.RIGHT);
	
		Component 	view 		= vm.arrangeViews();
		
		
		logger.info("view:"+view);
	}
}
