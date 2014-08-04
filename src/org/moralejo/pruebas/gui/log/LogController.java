package org.moralejo.pruebas.gui.log;

import org.appwork.utils.logging2.LogSource;
import org.appwork.utils.logging2.LogSourceProvider;

public class LogController extends LogSourceProvider {
	private static final LogController INSTANCE = new LogController();
	public static LogSource GL = getInstance().getLogger("JDownloader");

	private LogController() {
        super(System.currentTimeMillis());
    }
	
	public static LogController getInstance() {
        return LogController.INSTANCE;
    }

}
