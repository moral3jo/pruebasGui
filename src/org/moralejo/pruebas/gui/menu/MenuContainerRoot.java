package org.moralejo.pruebas.gui.menu;

import java.util.List;

import org.appwork.storage.Storable;

public class MenuContainerRoot extends MenuContainer implements Storable {

	public void add(List<MenuItemData> path) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("Add de MenuContainerRoot pdte..***********");
	}
}
