package org.moralejo.pruebas.gui.menu;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import org.appwork.swing.ExtJFrame;
import org.appwork.utils.logging2.LogSource;

public class MainFrame extends ExtJFrame {

	private LogSource logger;
	
	public MainFrame(String string, LogSource logger) {
		super(string);
		this.logger = logger;
		
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
			}
		});
		
		
		addWindowStateListener(new WindowStateListener() {
			
			@Override
			public void windowStateChanged(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.out.print("windowStateChanged:");
				System.out.println(arg0);
			}
		});
	}

}
