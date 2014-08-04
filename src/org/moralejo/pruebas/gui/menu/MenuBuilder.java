package org.moralejo.pruebas.gui.menu;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import org.appwork.utils.logging2.LogSource;
import org.appwork.utils.swing.EDTRunner;
import org.moralejo.pruebas.gui.log.LogController;

public class MenuBuilder {
	
	private LogSource logger;

	private JComponent root;
	private MenuContainer menuData;
	private MenuManagerMainmenu menuManager;

	public MenuBuilder(MenuManagerMainmenu menuManager, JComponent root, MenuContainerRoot md) {
		this.root = root;
		this.menuManager = menuManager;
		menuData = md;
		logger = LogController.getInstance().getLogger(JMenuBar.class.getName());
	}

	public void run() {
		new EDTRunner() {
			@Override
			protected void runInEDT() {
				createLayer(root, menuData);
			}
		};
	}

	protected void createLayer(final JComponent root, MenuContainer menuData) {
		logger.info("createLayer MenuBuilder");
		for (MenuItemData i: menuData.getItems()) {
			try{
				final MenuItemData inst = i;
				switch (inst.getType()) {
				case ACTION:
					addAction(root, inst);
					break;
				case CONTAINER:
//					addContainer(root, inst);
					logger.info("contendor de menu. Pdt prog.");
				}
				
			} catch (Throwable e) {
				logger.warning("Cargando menu ocurrió algo en elemento:"+ i+". ex:" + e);
			}
		}
		return;
//		for(MenuItemData i : menuData.get)
	}

	protected void addAction(final JComponent root, final MenuItemData inst) throws InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        inst.addTo(root);
    }

	protected void addContainer(final JComponent root, final MenuItemData inst)
			throws InstantiationException, IllegalAccessException,
			InvocationTargetException, ClassNotFoundException,
			NoSuchMethodException {
		 final JMenu submenu = (JMenu) inst.addTo(root);
	        if (submenu == null) return;
	        createLayer(submenu, (MenuContainer) inst);

	        if (submenu.getMenuComponentCount() == 0) {
	            root.remove(submenu);
	        }
	}
}
