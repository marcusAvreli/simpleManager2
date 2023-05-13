package simpleManager2;

import java.awt.Container;
import java.util.Map;

import javax.swing.JFrame;

import simpleManager2.api.controller.ViewControllerDispatcher;
import simpleManager2.api.view.perspective.Perspective;
import simpleManager2.api.view.perspective.PerspectiveConstraint;


/**
 * This interface should be implemented by classes used for managing
 * several views.<br/><br/>
 * Views can be added to the manager and then re-arranged before it can
 * be shown.
 * 
 * @author Mario Garcia
 * @since 1.0
 *
 */

//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/api/src/main/java/org/viewaframework/view/ViewManager.java
public interface ViewManager 
{
	public static final String ROOT_VIEW_ID = "rootViewId";

	/**
	 * Adds a view to the manager
	 * 
	 * @param view
	 * @throws
	 */
	public void addView(ViewContainer view) ;
	public void addView(ViewContainer view, PerspectiveConstraint constraint) ;
	
	
	public void setFrame(JFrame view);
	public JFrame getFrame();
	public void setControllerDispatcher(ViewControllerDispatcher dispatcher);
	
	/**
	 * @return
	 */
	public Perspective getPerspective();
	/**
	 * @param viewLayout
	 */
	public void setPerspective(Perspective perspective);
	
	/**
	 * @return
	 */
	public Map<Object,ViewContainer> getViews();
	
	public Container arrangeViews();
	public void removeView(ViewContainer view);
	
	
}