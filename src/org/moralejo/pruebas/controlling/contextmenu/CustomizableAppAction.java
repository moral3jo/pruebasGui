package org.moralejo.pruebas.controlling.contextmenu;

import org.moralejo.pruebas.actions.AppAction;
import org.moralejo.pruebas.gui.menu.MenuItemData;

public abstract class CustomizableAppAction extends AppAction {
	private MenuItemData menuItemData;

	public MenuItemData getMenuItemData() {
		return menuItemData;
	}

	public void setMenuItemData(MenuItemData data) {
		this.menuItemData = data;
//		fill(setupObjects);
	}
	
	
}
