package org.moralejo.pruebas.gui.swing.jdgui.interfaces;

import javax.swing.Icon;

public abstract class View extends SwitchPanel {

	private static final long serialVersionUID = 1L;

	abstract public String getTitle();

	abstract public Icon getIcon();

	abstract public String getTooltip();


}
