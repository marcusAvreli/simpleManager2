package simpleManager2;

import simpleManager2.api.view.event.ViewContainerEventController;
import simpleManager2.api.view.event.ViewContainerEvent;
public class DefaultViewContainerEventController implements ViewContainerEventController{
	
	/* (non-Javadoc)
	 * @see org.viewaframework.view.event.ViewContainerEventController#onViewClose(org.viewaframework.view.event.ViewContainerEvent)
	 */
	@Override
	public void onViewClose(ViewContainerEvent event) {
		
		
	}

	/* (non-Javadoc)
	 * @see org.viewaframework.view.event.ViewContainerEventController#onViewInit(org.viewaframework.view.event.ViewContainerEvent)
	 */
	@Override
	public void onViewInit(ViewContainerEvent event) {
		
		System.out.println("on_view_init");
	}

	@Override
	public void onViewInitUIState(ViewContainerEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onViewInitBackActions(ViewContainerEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onViewFinalUIState(ViewContainerEvent event) {
		// TODO Auto-generated method stub
		
	}

	
}