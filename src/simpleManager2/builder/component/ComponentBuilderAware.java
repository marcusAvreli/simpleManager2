package simpleManager2.builder.component;

import javax.swing.JComponent;

/**
 * @author mgg
 *
 */
public interface ComponentBuilderAware {


	/**
	 * @param <T>
	 * @param component
	 * @param clazz
	 * @param constraints
	 * @return
	 */
	public <T extends JComponent> JComponentBuilder<T> component(T component,Class<T> clazz,Object constraints);
	/**
	 * @return
	 */
	
	public LabelBuilder label();
	/**
	 * @param constraints
	 * @return
	 */
	public LabelBuilder label(Object constraints);
	/**
	 * @return
	 */
	
}
