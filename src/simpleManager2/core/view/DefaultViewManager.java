package simpleManager2.core.view;

import java.awt.Container;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleManager2.api.view.perspective.Perspective;

///https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/view/DefaultViewManager.java
public class DefaultViewManager extends AbstractViewManager
{private static final Logger logger = LoggerFactory.getLogger(DefaultViewManager.class);
	private Perspective perspective;
	/**
	 * Default Constructor
	 */
	public DefaultViewManager(){
		super();
	}
	public DefaultViewManager(JFrame frame,Perspective perspective){
		//this();
		this.setFrame(frame);
		
			this.setPerspective(perspective);
		
	}
	public void setPerspective(Perspective viewLayout) {
		if (this.getPerspective() == null){
			this.perspective = viewLayout;
		} else {
			this.getPerspective().clear();
			this.perspective = viewLayout;
		}
	}
	/* (non-Javadoc)
	 * @see org.viewa.view.ViewManager#getPerspective()
	 */
	public Perspective getPerspective() {
		return this.perspective;
	}
	public Container arrangeViews() 
	{
		JFrame 				rootContainer 	= getFrame();
		if(null != rootContainer) {
			logger.info("root_container_is_not_null");
		}else {
			logger.info("root_container_is_null");
		}
		logger.info("Default_View_Manager_arrange_view");
		Container 	container 		= super.arrangeViews();
		if(null != container) {
			logger.info("container_is_not_null");
		}else {
			logger.info("container_is_null");
		}
		rootContainer.add(container);
		return rootContainer;
	}

}