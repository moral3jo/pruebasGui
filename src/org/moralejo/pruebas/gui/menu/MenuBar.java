package org.moralejo.pruebas.gui.menu;

import java.lang.reflect.InvocationTargetException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;

import org.appwork.utils.logging2.LogSource;
import org.moralejo.pruebas.gui.log.LogController;

public class MenuBar extends JMenuBar {

	private static final MenuBar INSTANCE = new MenuBar();
	
	private LogSource logger;

	private MenuBar() {
		super();
		logger = LogController.getInstance().getLogger(JMenuBar.class.getName());
		updateLayout();
		//addMouseListener
		//add(new JMenu("prueba1"));
		//add(new JMenu("prueba2"));
	}
	
	private void updateLayout() {
		removeAll();
		
		new MenuBuilder(
				MenuManagerMainmenu.getInstance(), 
				this, 
				MenuManagerMainmenu.getInstance().createDefaultStructure()) {

            @Override
            protected void addContainer(JComponent root, MenuItemData inst) throws InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
//				final JMenu submenu = (JMenu) inst.addTo(root);
////				if (root == MenuBar.this) submenu.setIcon(null);
//				if(submenu != null){
//					//applyMnemonic()
//					if(root == MenuBar.this){
//						submenu.setIcon(null);
//					}
//					createLayer(submenu, (MenuContainer) inst);
//				}
            	//pruebas mias
            	JMenu submenu = new JMenu(inst.getName());
            	add(submenu);
            	//submenu.add(new JMenuItem("lala"));
            	//createLayer(inst.addTo(root), (MenuContainer) inst);
            //	createLayer(new JMenuItem(inst.addTo(root)), (MenuContainer) inst);
//            	submenu.setAction(null);
//            	add(new JMenu("menu1"));
            }

			@Override
			protected void addAction(JComponent root, MenuItemData inst) throws InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
				//AbstractButton ret = new JToggleButton();
				AbstractButton ret = new JMenuItem();
				ret.setText("pru");
				root.add(ret);
			}
            
        }.run();
		
		repaint();
	}

	public static MenuBar getInsatance() {
		return MenuBar.INSTANCE;
	}
	
}
