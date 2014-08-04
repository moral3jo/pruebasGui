package org.moralejo.pruebas.controlling.contextmenu;

import org.appwork.swing.action.BasicAction;

public class ActionData {
	
	private String clazzName;
    private String data;
    private Class<?> clazz;

	public ActionData(Class<?> class1) {
		this(class1, null);
	}
	
	public ActionData(Class<?> class1, String data) {
        this.data = data;
        this.clazz = class1;
        this.clazzName = class1.getName();
    }

}
