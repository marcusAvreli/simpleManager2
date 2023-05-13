package simpleManager2.core.view.delegator;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import simpleManager2.ViewContainer;
import simpleManager2.api.view.delegator.Delegator;

public class NamedComponentsDelegator implements Delegator{

	/* (non-Javadoc)
	 * @see org.viewaframework.view.delegator.Delegator#clean(org.viewaframework.view.ViewContainer)
	 */
	public void clean(ViewContainer view)  {
		view.setNamedComponents(null);
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.view.delegator.Delegator#inject(org.viewaframework.view.ViewContainer)
	 */
	public void inject(ViewContainer view)  {
		view.setNamedComponents(extractComponents(view.getRootPane(),new HashMap<String,List<Component>>()));
	}
	
	/**
	 * @param con
	 * @param namedComponents
	 * @return
	 */
	private Map<String,List<Component>> extractComponents(Component con,Map<String,List<Component>> namedComponents){		
		String componentName = con.getName();
		
		if (componentName!=null && !componentName.equalsIgnoreCase("")){
			List<Component> components = namedComponents.get(componentName);
			if (components==null){
				namedComponents.put(componentName, new ArrayList<Component>());
			}
			namedComponents.get(componentName).add(con);
		}			
		if (con instanceof Container){
			
				for (Component c : ((Container)con).getComponents()){
					extractComponents(c,namedComponents);
				}
			
		}	
		
		
		return namedComponents;
	}
	
}