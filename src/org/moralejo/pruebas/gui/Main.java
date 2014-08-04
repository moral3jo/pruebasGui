package org.moralejo.pruebas.gui;

import org.appwork.controlling.SingleReachableState;
import org.appwork.utils.logging2.LogSource;
import org.appwork.utils.swing.EDTHelper;
import org.appwork.utils.swing.dialog.Dialog;
import org.moralejo.pruebas.gui.log.LogController;

public class Main {
	
	private static LogSource LOG;
	public final static long startup = System.currentTimeMillis();
	public static final SingleReachableState GUI_COMPLETE = new SingleReachableState("GUI_COMPLETE");

	public static void main(String[] args) {
		LOG = LogController.GL;
		LOG.info("Log funcionando.");
		start();
	}

	private static void start() {
		new EDTHelper<Void>() { //lanzo en edt
			@Override
			public Void edtRun() {
				try {
					Main.LOG.info("InitGUI time:" + (System.currentTimeMillis() - Main.startup));
					JDGui.init();
				} catch (Throwable e) {
					Main.LOG.log(e);
					Dialog.getInstance().showExceptionDialog("Exception occured", "An unexpected error occured.\r\nJDownloader will try to fix this. If this happens again, please contact our support.", e);
				}
				return null;
			}
		}.waitForEDT();
	}

}
