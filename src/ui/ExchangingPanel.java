package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import conf.ConfInterface;

import dbInterface.SqlCon;

public class ExchangingPanel extends DefaultCardPanel implements ActionListener{
	
	ConfInterface ci=new ConfInterface();
	GuiTool guiTool=new GuiTool();
	SqlCon sc=new SqlCon();
	private JButton next,previous,edit,delete;
	public static ExchangingPanel exchangingPanel;
	public ExchangingPanel() {
		super();
		exchangingPanel=this;
		southernPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		next=new JButton(new ImageIcon(guiTool.getImage(12)));
		next.setToolTipText("Nächster Datensatz");
		next.addActionListener(this);
		
		previous=new JButton(new ImageIcon(guiTool.getImage(13)));
		previous.setToolTipText("Vorheriger Datensatz");
		previous.addActionListener(this);
		
		edit=new JButton(new ImageIcon(guiTool.getImage(14)));
		edit.setToolTipText("Datensatz bearbeiten");
		edit.addActionListener(this);
		
		delete=new JButton(new ImageIcon(guiTool.getImage(3)));
		delete.setToolTipText("Datensatz löschen");
		delete.addActionListener(this);
		
		
		setDataRecord(sc.getLastDataRecordId());
		enableFirstName(false);
		enableLastName(false);
		enableMail1(false);
		enableMail2(false);
		enableProffesion(false);
		enableMobile(false);
		enablePrivateTel(false);
		enableTel(false);
		enableShort(false);
		enableIcqElse(false);
		enableCity(false);
		enableAddress(false);
		
		
		southernPanel.add(previous);
		southernPanel.add(next);
		southernPanel.add(edit);
		southernPanel.add(delete);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SqlCon sc=new SqlCon();
		if(e.getSource()==next){
			if(sc.getDataRecordID(pFirstNameTxt.getText(), pLastNameTxt.getText())==sc.getMaxContactID()){
				if(sc.existDataRecord(1)){
				setDataRecord(1);
				sc.setLastDataRecordId(1);}
				else{
					for( int i=2;i<=sc.getMaxContactID();i++){
						if(sc.existDataRecord(i)){
							setDataRecord(i);
							sc.setLastDataRecordId(1);}
						}
					
				}
			}else{
				setDataRecord(sc.getDataRecordID(pFirstNameTxt.getText(), pLastNameTxt.getText())+1);
				sc.setLastDataRecordId(sc.getDataRecordID(pFirstNameTxt.getText(), pLastNameTxt.getText()));
			}
		}else if(e.getSource()==previous){
			if(sc.getDataRecordID(pFirstNameTxt.getText(), pLastNameTxt.getText())==1){
				setDataRecord(sc.getMaxContactID());
				sc.setLastDataRecordId(sc.getMaxContactID());
			}else{
				setDataRecord(sc.getDataRecordID(pFirstNameTxt.getText(), pLastNameTxt.getText())-1);
				sc.setLastDataRecordId(sc.getDataRecordID(pFirstNameTxt.getText(), pLastNameTxt.getText()));
			}
		}else if(e.getSource()==edit){
			int i=sc.getDataRecordID(pFirstNameTxt.getText(), pLastNameTxt.getText());
			TabContainer.tabContainer.addEditPanelTab(i);
		}else if(e.getSource()==delete){
			int opt=JOptionPane.showConfirmDialog(null, "Wollen Sie den Datensatz wirklich löschen?","Datensatz löschen?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon(guiTool.getImage(3)));
			if(opt==0){
				int id=sc.getDataRecordID(pFirstNameTxt.getText(), pLastNameTxt.getText());
				sc.deleteDataRecord(id);
				this.setDataRecord(1);
			}
		}
		
	}
}
