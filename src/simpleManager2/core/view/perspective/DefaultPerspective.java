package simpleManager2.core.view.perspective;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleManager2.ViewContainer;
import simpleManager2.api.view.perspective.Perspective;
import simpleManager2.api.view.perspective.PerspectiveConstraint;
///https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/main/java/org/viewaframework/view/perspective/DefaultPerspective.java
public class DefaultPerspective implements Perspective {
	private static final Logger logger = LoggerFactory.getLogger(DefaultPerspective.class);
	public static final String DEFAULT_PERSPECTIVE_ID = "DefaultPerspectiveID";
	private String id;
	private JTabbedPane auxiliaryPanel = new JTabbedPane();
	private JTabbedPane editionPanel = new JTabbedPane();
	private JTabbedPane navigationPanel = new JTabbedPane();
	private JSplitPane rightToLeft = new JSplitPane();
	private JSplitPane topBottom = new JSplitPane();
	private javax.swing.JPanel leftRootView;
    private javax.swing.JPanel rightRootView;
    private javax.swing.JSplitPane splitPane;
	private Component component;
	private Map<Object,ViewContainer> views;	
	
	public Component getComponent() {
		return splitPane;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	@Override
	public void addView(ViewContainer view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Container arrange() {
		// TODO Auto-generated method stub
		return this.splitPane;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addView(ViewContainer view, PerspectiveConstraint constraint) {
		this.getViews().put(view.getId(),view);
		// TODO Auto-generated method stub
		 	component 		= view.getRootPane();		
			
			

logger.info("default_perspective:" + constraint);

    splitPane.setDividerLocation(200);

  
   
    if(constraint.equals(PerspectiveConstraint.LEFT)) {
    	leftRootView.add(component);
    }
			
    if(constraint.equals(PerspectiveConstraint.RIGHT)) {
    	rightRootView.add(component);
    }
	}
	/* (non-Javadoc)
	 * @see org.viewa.view.Perspective#getViews()
	 */
	public Map<Object, ViewContainer> getViews() {
		if (this.views == null){
			this.views = new HashMap<Object, ViewContainer>();
		}
		return this.views;
	}
	/* (non-Javadoc)
	 * @see org.viewa.view.Perspective#setViews(java.util.Map)
	 */
	public void setViews(Map<Object, ViewContainer> views) {
		logger.info("set_views_called:"+views);
		this.views = views;
	}	
	public DefaultPerspective(){
		logger.info("perspective_constructor_called");
		  splitPane = new javax.swing.JSplitPane();
		  leftRootView = new javax.swing.JPanel();
		  rightRootView = new javax.swing.JPanel();
		  leftRootView.setLayout(new java.awt.BorderLayout());
		  rightRootView.setLayout(new java.awt.BorderLayout());
		  splitPane.setLeftComponent(leftRootView);

		  
		    splitPane.setRightComponent(rightRootView);
		this.navigationPanel.setName(PerspectiveConstraint.LEFT.name());
		this.auxiliaryPanel.setName(PerspectiveConstraint.BOTTOM.name());
		this.editionPanel.setName(PerspectiveConstraint.RIGHT.name());		
		this.auxiliaryPanel.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		this.navigationPanel.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		this.editionPanel.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);	
		
		this.editionPanel.setPreferredSize(new Dimension(0,400));
		this.auxiliaryPanel.setPreferredSize(new Dimension(0,200));
		this.navigationPanel.setPreferredSize(new Dimension(200,0));
		this.auxiliaryPanel.setVisible(false);
		this.topBottom.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.topBottom.setOneTouchExpandable(true);
		this.topBottom.setTopComponent(editionPanel);
		this.topBottom.setBottomComponent(auxiliaryPanel);
		this.rightToLeft.setLeftComponent(navigationPanel);
		this.rightToLeft.setRightComponent(topBottom);
		this.rightToLeft.setOneTouchExpandable(true);
	}

}
