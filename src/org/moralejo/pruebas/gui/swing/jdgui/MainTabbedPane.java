package org.moralejo.pruebas.gui.swing.jdgui;

import java.awt.Dimension;

import javax.swing.JTabbedPane;

import org.moralejo.pruebas.gui.swing.jdgui.interfaces.View;

public class MainTabbedPane extends JTabbedPane {
	private static final long serialVersionUID = 1L;
	private static MainTabbedPane INSTANCE;

	public synchronized static MainTabbedPane getInstance() {
		if(INSTANCE==null){
			INSTANCE = new MainTabbedPane();
		}
		return INSTANCE;
	}
	
	public MainTabbedPane() {
		//this.setMinimumSize(new Dimension(600,100));
		this.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
//		this.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		this.setMinimumSize(new Dimension(640, 480));
		this.setPreferredSize(new Dimension(866, 480));
		//this.setOpaque(false);
	}
	
	public void addTab(View view) {
		super.addTab(view.getTitle(), view.getIcon(), view, view.getTooltip());
		//view.getBroadcaster().fireEvent(new ....);
		this.setFocusable(false);
	}
	
	
	
}
