package org.moralejo.pruebas.gui.views;

import javax.swing.Icon;

import org.moralejo.pruebas.gui.swing.jdgui.interfaces.View;

public class DownloadsView extends View {

	@Override
	public String getTitle() {
		return "Titulo de Vista1";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getTooltip() {
		return "tooltipo de pestaña";
	}

}
