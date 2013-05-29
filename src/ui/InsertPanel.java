package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dbInterface.SqlCon;

public class InsertPanel extends DefaultCardPanel implements ActionListener {
	
	private JButton addButton,abortButton;
	GuiTool guiTool=new GuiTool();
	SqlCon sc=new SqlCon();
	
	public InsertPanel(){
		southernPanel.add(addButton=new JButton(new ImageIcon(guiTool.getImage(2))));
		southernPanel.add(abortButton=new JButton(new ImageIcon(guiTool.getImage(16))));
		addButton.setToolTipText("Datensatz hinzufügen");
		abortButton.setToolTipText("Abbrechen");
		addButton.addActionListener(this);
		abortButton.addActionListener(this);
		cityTxt.setToolTipText("Die Eingabe muss den Aufbau PLZ->Leerzeichen->Ortsnamen haben!");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(abortButton==e.getSource()){
			TabContainer.tabContainer.removeInsertPanelTab();
		}else if(e.getSource()==addButton){
			sc.addDataRecord(this.getDataRecord());
			TabContainer.tabContainer.removeInsertPanelTab();
		}
		
	}

}
