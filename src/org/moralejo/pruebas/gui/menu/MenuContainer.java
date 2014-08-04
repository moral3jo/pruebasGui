package org.moralejo.pruebas.gui.menu;

import java.util.ArrayList;

import org.appwork.swing.action.BasicAction;

public class MenuContainer extends MenuItemData {
	
	private ArrayList<MenuItemData> items;
	
	public MenuContainer() {
		super();
		setType(null);

	}

	public ArrayList<MenuItemData> getItems() {
		return items;
	}
	
	public void add(Class<? extends BasicAction> class1) {
//		add(new ActionData(class1));
	}
	

}
