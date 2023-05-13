package simpleManager2;

import java.awt.Component;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

import javax.swing.RootPaneContainer;

import simpleManager2.api.controller.ViewController;


////https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/api/src/main/java/org/viewaframework/view/ViewContainer.java
public interface ViewContainer extends RootPaneContainer{
	public abstract void viewInit();
	public Component getComponent();
	public void setComponent(Component component);
	public abstract String getId();
	public abstract void setId(String name);	
	public abstract void setTitle(String title);	
	public abstract String getTitle();
	/**
	 * Closes the view
	 */
	public abstract void viewClose();
public void setViewControllerMap(Map<String, List<ViewController<? extends EventListener, ? extends EventObject>>> viewControllerMap);
	
	/* (non-Javadoc)
	 * @see org.viewaframework.controller.ViewControllerAware#getViewControllerMap()
	 */
	public Map<String, List<ViewController<? extends EventListener, ? extends EventObject>>> getViewControllerMap();
	
	
	public void setNamedComponents(Map<String, List<Component>> namedComponents);
	public Map<String, List<Component>> getNamedComponents();
}
