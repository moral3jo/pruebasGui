package org.moralejo.pruebas.gui.menu;

import org.appwork.swing.action.BasicAction;
import org.moralejo.pruebas.controlling.contextmenu.SeperatorData;
import org.moralejo.pruebas.gui.mainmenu.action.AddLinksMenuAction;
import org.moralejo.pruebas.gui.mainmenu.container.AboutMenuContainer;
import org.moralejo.pruebas.gui.mainmenu.container.FileMenuContainer;

public class MenuManagerMainmenu {
	private static final MenuManagerMainmenu INSTANCE = new MenuManagerMainmenu();

	public static MenuManagerMainmenu getInstance() {
		return MenuManagerMainmenu.INSTANCE;
	}

	public MenuContainerRoot createDefaultStructure() {
		MenuContainerRoot mr = new MenuContainerRoot();
		mr.add(createFileMenu());
//		mr.add(createAboutMenu());
		return mr;
	}
	
	private AboutMenuContainer createAboutMenu() {
		AboutMenuContainer ret = new AboutMenuContainer();
		ret.add(new SeperatorData());
		//ret.add(AboutAction.class);
		return null;
	}

	private FileMenuContainer createFileMenu() {
		FileMenuContainer ret = new FileMenuContainer();
		ret.add(AddLinksMenuAction.class);
		return ret;
	}

	public MenuManagerMainmenu() {
		//super();
	}

}
