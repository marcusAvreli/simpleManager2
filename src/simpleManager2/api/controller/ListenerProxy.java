package simpleManager2.api.controller;

import java.lang.reflect.InvocationHandler;
import java.util.EventListener;
import java.util.EventObject;



public interface ListenerProxy <EL extends EventListener,EO extends EventObject> extends InvocationHandler{

//	public AbstractViewController getTargetController();
	public ViewController<EL, EO> getTargetController();
}
