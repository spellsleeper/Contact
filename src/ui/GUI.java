package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import conf.ConfInterface;

import dbInterface.SqlCon;

public class GUI extends JFrame {

	private static ConfInterface confInterface = new ConfInterface();
	private GuiTool guiTool = new GuiTool();
	private SqlCon sc = new SqlCon();

	static GUI gui;
	static TabContainer tabContainer;

	public GUI() {
		super("Kontakte");
		gui = this;
		setIconImage(guiTool.getImage(0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		addMenuBar();
		add(tabContainer = new TabContainer());
		centre();
		getLook();
		pack();
		setVisible(true);
		
	}

	private void addMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Datei");
		menuBar.add(fileMenu);
		JMenu propertieMenu = new JMenu("Einstellungen");
		menuBar.add(propertieMenu);
		JMenu dataMenu = new JMenu("Datensatz");
		menuBar.add(dataMenu);
		JMenu infoMenu = new JMenu("Info");
		menuBar.add(infoMenu);

		JMenuItem closeItem = new JMenuItem("Beenden", new ImageIcon(
				guiTool.getImage(4)));
		closeItem.addActionListener(closeListener);
		fileMenu.add(closeItem);

		JMenuItem lookItem = new JMenuItem("LookAndFeel wählen", new ImageIcon(
				guiTool.getImage(5)));
		lookItem.addActionListener(lookListener);
		propertieMenu.add(lookItem);

		JMenuItem editItem = new JMenuItem("Bearbeiten", new ImageIcon(
				guiTool.getImage(15)));
		editItem.addActionListener(editListener);
		dataMenu.add(editItem);

		JMenuItem addItem = new JMenuItem("Einfügen", new ImageIcon(
				guiTool.getImage(2)));
		addItem.addActionListener(addListener);
		dataMenu.add(addItem);

		JMenuItem deleteItem = new JMenuItem("Löschen", new ImageIcon(
				guiTool.getImage(3)));
		deleteItem.addActionListener(deleteListener);
		dataMenu.add(deleteItem);

		JMenuItem overviewItem = new JMenuItem("Übersicht", new ImageIcon(
				guiTool.getImage(17)));
		overviewItem.addActionListener(overviewListener);
		overviewItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		dataMenu.add(overviewItem);

		JMenuItem infoItem = new JMenuItem("Info", new ImageIcon(
				guiTool.getImage(7)));
		infoItem.addActionListener(infoListener);
		infoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		infoMenu.add(infoItem);

		this.setJMenuBar(menuBar);
	}

	private void centre() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(d.width / 2 - this.getWidth() / 2,
				d.height / 2 - this.getHeight() / 2);
	}

	public static void setStyle(String style) {
		try {
			if (style.equalsIgnoreCase("System")) {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
				SqlCon.sqlCon.setLook("System");
			} else {
				UIManager.setLookAndFeel(style);
				SqlCon.sqlCon.setLook(style);
			}
			SwingUtilities.updateComponentTreeUI(gui);
			gui.pack();
		} catch (Exception ex) {
			System.err
					.println("Fehler beim setzen des ausgewählten LookAndFeels");
			ex.printStackTrace();
		}
	}

	private void getLook() {
		try {
			String temp = sc.getLook();
			if (temp.equals("System")) {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} else {
				UIManager.setLookAndFeel(temp);

			}
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception ex) {
			System.err.println("Fehler beim Setzen des LookAndFeels im Frame!");
			ex.printStackTrace();
		}
	}

	ActionListener closeListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				System.exit(0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	};

	ActionListener lookListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			LookOptionPane lop = new LookOptionPane();

		}
	};

	ActionListener infoListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					confInterface.getInfoAttribute(), "Info",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(guiTool.getImage(6)));

		}
	};

	ActionListener editListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			TabContainer.tabContainer.addEditPanelTab(sc.getDataRecordID(
					TabContainer.exchangingPanel.getTextFirstName(),
					TabContainer.exchangingPanel.getTextLastName()));

		}
	};

	ActionListener deleteListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int opt = JOptionPane.showConfirmDialog(null,
					"Wollen Sie den Datensatz wirklich löschen?",
					"Datensatz löschen?", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					new ImageIcon(guiTool.getImage(3)));
			if (opt == 0) {
				int id = sc.getDataRecordID(
						TabContainer.exchangingPanel.getTextFirstName(),
						TabContainer.exchangingPanel.getTextLastName());
				sc.deleteDataRecord(id);
				TabContainer.exchangingPanel.setDataRecord(1);
			}
		}
	};

	ActionListener addListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			TabContainer.tabContainer.addInsertPanelTab();

		}
	};

	ActionListener overviewListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			TabContainer.tabContainer.addOverviewPanel();

		}
	};

}
