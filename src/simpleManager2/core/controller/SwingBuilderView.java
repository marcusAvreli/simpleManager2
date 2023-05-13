package simpleManager2.core.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import simpleManager2.builder.SwingBuilder;
import simpleManager2.builder.layout.GridBagConstraintsBuilder;
import simpleManager2.core.view.DefaultViewContainer;

//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/widget/src/test/java/org/viewaframework/widget/swing/builder/util/SwingBuilderView.java
public class SwingBuilderView extends DefaultViewContainer{
	private static final Logger logger = LoggerFactory.getLogger(SwingBuilderView.class);
	public SwingBuilderView(){
		super("SwingBuilderViewId",
			new SwingBuilder().
			
			component(
					new SwingBuilder().
						layout(new GridBagLayout()).
						 /* (1) label-component */	
						button(new GridBagConstraintsBuilder().
								row(5).col(0).gridWidth(2).anchor(GridBagConstraints.EAST).fill(GridBagConstraints.NONE).insets(20,0,0,0).build()).
							setName("assignmentsButton").setText("Assignments").setPreferredSize(new Dimension(180,25))
						.swingBuilder().
								button(new GridBagConstraintsBuilder().
										row(6).col(0).gridWidth(3).anchor(GridBagConstraints.EAST).fill(GridBagConstraints.NONE).insets(20,0,0,0).build()).
									setName("searchButton").setText("Report").setPreferredSize(new Dimension(180,25))
								.swingBuilder()
								.getTarget()
							
							
									
									,JPanel.class,BorderLayout.NORTH).
					swingBuilder().setPreferredSize(new Dimension(400,0)).getTarget());
	}
									
}
