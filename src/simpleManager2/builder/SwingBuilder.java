package simpleManager2.builder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import simpleManager2.builder.component.ButtonBuilder;
import simpleManager2.builder.component.ComponentBuilder;
import simpleManager2.builder.component.ComponentBuilderAware;
import simpleManager2.builder.component.JComponentBuilder;
import simpleManager2.builder.component.LabelBuilder;
import simpleManager2.builder.component.TextFieldBuilder;
import simpleManager2.builder.container.ContainerBuilder;


//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/swing/src/main/java/org/viewaframework/swing/builder/SwingBuilder.java
public class SwingBuilder implements ContainerBuilder<JPanel>,ComponentBuilderAware{

	private JPanel mainPanel;
	
	public SwingBuilder(){
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BorderLayout());
		this.mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
	public ButtonBuilder button(Object constraints) {
		ButtonBuilder builder = new ButtonBuilder(this);
		this.mainPanel.add(builder.getTarget(),constraints);
		return builder;
	}
	/* (non-Javadoc)
	 * @see org.examples.viewaframework.swing.component.ComponentBuilderAware#label(java.lang.Object)
	 */
	@Override
	public LabelBuilder label(Object constraints) {
		LabelBuilder labelBuilder = new LabelBuilder(this);
		this.mainPanel.add(labelBuilder.getTarget(),constraints);
		return labelBuilder;	
	}
	/* (non-Javadoc)
	 * @see org.viewaframework.widget.swing.builder.container.ContainerBuilder#layout(java.awt.LayoutManager)
	 */
	public SwingBuilder layout(LayoutManager layout) {
		this.mainPanel.setLayout(layout);
		return this;
	}
	public <T extends JComponent> JComponentBuilder<T> component(T component,Class<T> clazz,Object constraints) {
		JComponentBuilder<T> builder = 
			new JComponentBuilder<T>(this,component,clazz);
		this.mainPanel.add(builder.getTarget(),constraints);
		return builder;
	}

	
	public LabelBuilder label() {
		LabelBuilder labelBuilder = new LabelBuilder(this);
		this.mainPanel.add(labelBuilder.getTarget());
		return labelBuilder;
	}
	public JPanel getTarget() {		
		return this.mainPanel;
	}
	public SwingBuilder setPreferredSize(Dimension dimension) {
		this.mainPanel.setPreferredSize(dimension);
		return this;
	}

	public SwingBuilder setName(String name) {
		this.mainPanel.setName(name);
		return this;
	}

	@Override
	public ComponentBuilder<JPanel> setFont(Font font) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComponentBuilder<JPanel> setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.examples.viewaframework.swing.Builder#getType()
	 */
	public Class<JPanel> getType() {
		return JPanel.class;
	}
	@Override
	public void setTarget(JPanel target) {
		// TODO Auto-generated method stub
		this.mainPanel = target;
	}

	@Override
	public SwingBuilder swingBuilder() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see org.examples.viewaframework.swing.component.ComponentBuilderAware#textField()
	 */
	public TextFieldBuilder text() {
		TextFieldBuilder textBuilder = new TextFieldBuilder(this);
		this.mainPanel.add(textBuilder.getTarget());		
		return textBuilder;
	}

	/* (non-Javadoc)
	 * @see org.examples.viewaframework.swing.component.ComponentBuilderAware#textField()
	 */
	public TextFieldBuilder text(Object constraints) {
		TextFieldBuilder textBuilder = new TextFieldBuilder(this);
		this.mainPanel.add(textBuilder.getTarget(),constraints);		
		return textBuilder;
	}
}
