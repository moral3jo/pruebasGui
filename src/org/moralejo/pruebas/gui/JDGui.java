package org.moralejo.pruebas.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.appwork.swing.ExtJFrame;
import org.appwork.utils.logging2.LogSource;
import org.appwork.utils.swing.EDTHelper;
import org.moralejo.pruebas.gui.log.LogController;
import org.moralejo.pruebas.gui.menu.MenuBar;
import org.moralejo.pruebas.gui.menu.MainFrame;
import org.moralejo.pruebas.gui.swing.jdgui.MainTabbedPane;
import org.moralejo.pruebas.gui.views.DownloadsView;
import org.moralejo.pruebas.gui.views.LinkGrabberView;

public class JDGui {

	private static JDGui INSTANCE;
	private LogSource logger;
	protected ExtJFrame mainFrame;
	private MenuBar menuBar;
	private MainTabbedPane mainTabbedPane;
	private DownloadsView downloadView;
	private LinkGrabberView linkgrabberView;
	
	private JDGui() {
		logger = LogController.getInstance().getLogger("Gui");
		initFrame("Moralejo");
//		AbstractDialog.setDefaultRoot(getMainFrame());
		this.mainFrame.setVisible(true);
		this.mainFrame.setTitle("Titulo ventana");
		this.mainFrame.setName("MAINFRAME");
		
		this.initDefaults(); //bloquea cierre normal
        this.initComponents();
//        this.setWindowIcon();
        this.layoutComponents();
        this.mainFrame.setSize(640, 480);
        this.mainFrame.pack();
        
//      tray
        
//        initLocationAndDimension();
//        initToolTipSettings();
//        initUpdateFrameListener();
//        initCaptchaToFrontListener();
//        initShiftControlSWindowResetKeyListener();
        
//        Main.GUI_COMPLETE.executeWhenReached(new Runnable() {
//			@Override
//			public void run() {
//				onGuiInitComplete();
//			}
//		});
        
	}
	
	private void initFrame(final String string) {
		mainFrame = new MainFrame(string, logger);
	}
	
	private void initComponents() {
		//this.menuBar = MenuBar.getInsatance();
		this.mainTabbedPane = MainTabbedPane.getInstance();
		
		this.downloadView= new DownloadsView();
		this.linkgrabberView = new LinkGrabberView();
		this.mainTabbedPane.addTab(downloadView);
		this.mainTabbedPane.addTab(linkgrabberView);
	}
	
	private void layoutComponents() {
		final JPanel contentPane = new JPanel();
		contentPane.add(this.mainTabbedPane);
//		contentPane.add(this.statusBar, "dock SOUTH");
		
		this.mainFrame.setContentPane(contentPane);
		this.mainFrame.setJMenuBar(this.menuBar);
//		this.mainFrame.add(this.toolBar, "dock NORTH, height 38!");		
	}


	private void initDefaults() {
		//this.mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		this.mainFrame.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				super.windowClosing(e);
//			}
//		});
	}





	public static void init() {
		if(JDGui.INSTANCE==null){
			JDGui.INSTANCE = new EDTHelper<JDGui>() {
				public JDGui edtRun() {
					return new JDGui();
				}
			}.getReturnValue();
		}
	}

}
