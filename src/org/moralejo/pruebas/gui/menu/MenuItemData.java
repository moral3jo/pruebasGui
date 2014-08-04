package org.moralejo.pruebas.gui.menu;

import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JMenuItem;

import org.appwork.swing.action.BasicAction;
import org.appwork.utils.StringUtils;
import org.moralejo.pruebas.controlling.contextmenu.ActionData;

public class MenuItemData {
	
	public static enum Type {
		ACTION, CONTAINER;
	}

	private Type type = Type.ACTION;
	private boolean visible = true;
	private String name = "menuItemDataDefault";
	private ArrayList<MenuItemData> items;
	private ActionData actionData;

	public MenuItemData(ActionData actionData) {
		this();
		setActionData(actionData);
	}
	
	private void setActionData(ActionData actionData) {
		this.actionData = actionData;
	}

	public MenuItemData() {
		items = new ArrayList<MenuItemData>();
	}

	public void setType(Type type) {
		this.type = type;
	}

	public JComponent addTo(JComponent root) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		if (!isVisible()) {
			return null;
		}
		JComponent it;

		it = createItem();
		if (it == null) {
			return null;
		}
		root.add(it);
		return it;
	}

	private BasicAction createAction() {
		BasicAction ret = new BasicAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		};
		return null;
	}

	public boolean isVisible() {
		return visible;
	}

	public Type getType() {
		return type;
	}
	
	public void setName(String name){
		this.name = name;
//		clearCachedAction();
	}
	
	public void add(MenuItemData child) {
		//TODO: SE ESTÁ LLAMANDO 2 VECES CON "menuItemDataDefault" con type y luego con otro que le falta el type y falla al añadir
		items.add(child);
	}
	
	public JComponent createItem() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException {
		final BasicAction action = createAction();
		JMenuItem ret = new JMenuItem(action);
		if(StringUtils.isNotEmpty(name)){
			ret.setText(name);
		}
		return null;
	}

	public ArrayList<MenuItemData> getItems() {
		return items;
	}
	
	

}
