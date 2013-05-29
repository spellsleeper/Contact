package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import conf.ConfInterface;
import dbInterface.SqlCon;

public class EditPanel extends DefaultCardPanel implements ActionListener{
	
	ConfInterface ci=new ConfInterface();
	GuiTool guiTool=new GuiTool();
	SqlCon sc=new SqlCon();
	private JButton updateButton,abortButton;
	private int drid;
	
	public EditPanel(int id) {
		drid=id;
		southernPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		southernPanel.add(updateButton=new JButton(new ImageIcon(guiTool.getImage(15))));
		southernPanel.add(abortButton=new JButton(new ImageIcon(guiTool.getImage(16))));
		updateButton.setToolTipText("Datensatz übernehmen");
		abortButton.setToolTipText("Abbrechen");
		updateButton.addActionListener(this);
		abortButton.addActionListener(this);
		cityTxt.setToolTipText("Die Eingabe muss den Aufbau PLZ->Leerzeichen->Ortsnamen haben!");
		setDataRecord(id);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==updateButton){
			sc.updateDataRecord(drid, this.getDataRecord());
			TabContainer.tabContainer.removeEditPanelTab();
			TabContainer.exchangingPanel.setDataRecord(drid);
		}else if(abortButton==e.getSource()){
			TabContainer.tabContainer.removeEditPanelTab();
		}
		
	}

}
