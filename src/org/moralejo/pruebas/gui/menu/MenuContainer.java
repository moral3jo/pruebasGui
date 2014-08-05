package org.moralejo.pruebas.gui.menu;

import java.util.ArrayList;

import org.appwork.swing.action.BasicAction;
import org.moralejo.pruebas.controlling.contextmenu.ActionData;

public class MenuContainer extends MenuItemData {
	
	public MenuContainer() {
		super();
		setType(null);

	}

	public void add(Class<? extends BasicAction> class1) {
		add(new ActionData(class1));
	}
	
	public void add(ActionData actionData) {
        add(new MenuItemData(actionData));
    }
	
	public Type getType(){
		return Type.CONTAINER;
	}
	

}
