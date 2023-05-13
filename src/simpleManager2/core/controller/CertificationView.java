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

public class CertificationView extends DefaultViewContainer{
	private static final Logger logger = LoggerFactory.getLogger(CertificationView.class);
	public CertificationView(){
		super("CertificationViewId",
			new SwingBuilder().
			
			component(
					new SwingBuilder().
						layout(new GridBagLayout()).
						 /* (1) label-component */						
								button(new GridBagConstraintsBuilder().
										row(6).col(0).gridWidth(3).anchor(GridBagConstraints.EAST).fill(GridBagConstraints.NONE).insets(20,0,0,0).build()).
									setName("searchButton").setText("Certification").setPreferredSize(new Dimension(180,25))
								.swingBuilder()
								.getTarget()
							
							
									
									,JPanel.class,BorderLayout.NORTH).
					swingBuilder().setPreferredSize(new Dimension(400,0)).getTarget());
	}
									
}
