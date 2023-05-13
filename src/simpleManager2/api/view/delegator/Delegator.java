package simpleManager2.api.view.delegator;

import simpleManager2.ViewContainer;

public interface Delegator {
	
	public void inject(ViewContainer viewContainer);
	public void clean(ViewContainer viewContainer);

}