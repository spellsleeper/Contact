package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

import dbInterface.SqlCon;

public class DefaultCardPanel extends JPanel {

	GuiTool guiTool = new GuiTool();

	protected JTextField pFirstNameTxt, pLastNameTxt, professionNameTxt, telTxt,
			mobileTxt, mail1Txt, mail2Txt, privateTelTxt, shortTxt, icqElseTxt,
			cityTxt,addressTxt;

	private JLabel pFirstNameLbl, pLastNameLbl, professionNameLbl, telLbl,
			mobileLbl, mail1Lbl, mail2Lbl, privateTelLbl, shortLbl, icqElseLbl,
			cityLbl,addressLbl;

	JPanel centrePanel, southernPanel;

	public DefaultCardPanel() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pFirstNameLbl = new JLabel("Vorname", new ImageIcon(
				guiTool.getImage(19)), JLabel.LEADING);
		pLastNameLbl = new JLabel("Nachname", new ImageIcon(
				guiTool.getImage(20)), JLabel.LEADING);
		professionNameLbl = new JLabel("Beruf/Titel", new ImageIcon(
				guiTool.getImage(11)), JLabel.LEADING);
		telLbl = new JLabel("Telefon", new ImageIcon(guiTool.getImage(8)),
				JLabel.LEADING);
		mobileLbl = new JLabel("Mobil", new ImageIcon(guiTool.getImage(9)),
				JLabel.LEADING);
		mail1Lbl = new JLabel("E-Mail(1)", new ImageIcon(guiTool.getImage(10)),
				JLabel.LEADING);
		mail2Lbl = new JLabel("E-Mail(2)", new ImageIcon(guiTool.getImage(10)),
				JLabel.LEADING);
		privateTelLbl = new JLabel("Privat Tel.", new ImageIcon(
				guiTool.getImage(8)), JLabel.LEADING);
		shortLbl = new JLabel("Kürzel", new ImageIcon(guiTool.getImage(11)),
				JLabel.LEADING);
		icqElseLbl = new JLabel("Instant-Messaging", new ImageIcon(guiTool.getImage(18)),
				JLabel.LEADING);
		cityLbl=new JLabel("Ort",new ImageIcon(guiTool.getImage(21)),
				JLabel.LEADING);
		addressLbl=new JLabel("Adresse",new ImageIcon(guiTool.getImage(22)),
				JLabel.LEADING);
		centrePanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		southernPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pFirstNameTxt = new JTextField(50);
		pLastNameTxt = new JTextField(50);
		professionNameTxt = new JTextField(50);
		telTxt = new JTextField(50);
		mobileTxt = new JTextField(50);
		mail1Txt = new JTextField(50);
		mail2Txt = new JTextField(50);
		privateTelTxt = new JTextField(50);
		shortTxt = new JTextField(50);
		icqElseTxt=new JTextField(50);
		cityTxt=new JTextField(50);
		addressTxt=new JTextField(50);
		double wxlbl = 0.75;
		int tall = 12;

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 0;
		centrePanel.add(pFirstNameLbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 0;
		centrePanel.add(pFirstNameTxt, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 1;
		centrePanel.add(pLastNameLbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 1;
		centrePanel.add(pLastNameTxt, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 2;
		centrePanel.add(professionNameLbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 2;
		centrePanel.add(professionNameTxt, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 3;
		centrePanel.add(telLbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 3;
		centrePanel.add(telTxt, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 4;
		centrePanel.add(privateTelLbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 4;
		centrePanel.add(privateTelTxt, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 5;
		centrePanel.add(mobileLbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 5;
		centrePanel.add(mobileTxt, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 6;
		centrePanel.add(mail1Lbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 6;
		centrePanel.add(mail1Txt, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 7;
		centrePanel.add(mail2Lbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 7;
		centrePanel.add(mail2Txt, c);

		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 8;
		centrePanel.add(icqElseLbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 8;
		centrePanel.add(icqElseTxt, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 9;
		centrePanel.add(shortLbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 9;
		centrePanel.add(shortTxt, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 10;
		centrePanel.add(cityLbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 10;
		centrePanel.add(cityTxt, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = wxlbl;
		c.ipady = tall;
		c.gridx = 0;
		c.gridy = 11;
		centrePanel.add(addressLbl, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.ipady = tall;
		c.gridx = 1;
		c.gridy = 11;
		centrePanel.add(addressTxt, c);

		add(centrePanel);
		add(southernPanel);
	}

	public void setTextLastName(String s) {
		pLastNameTxt.setText(s);
	}

	public String getTextLastName() {
		return pLastNameTxt.getText();
	}

	public void setTextFirstName(String s) {
		pFirstNameTxt.setText(s);
	}

	public String getTextFirstName() {
		return pFirstNameTxt.getText();
	}

	public void setTextProfession(String s) {
		professionNameTxt.setText(s);
	}

	public String getTextProfession() {
		return professionNameTxt.getText();
	}

	public void setTelTxt(String s) {
		telTxt.setText(s);
	}

	public String getTelTxt() {
		return telTxt.getText();
	}

	public void setMobileTxt(String s) {
		mobileTxt.setText(s);
	}

	public String getMobileTxt() {
		return mobileTxt.getText();
	}

	public void setMail1Txt(String s) {
		mail1Txt.setText(s);
	}

	public String getMail1Txt() {
		return mail1Txt.getText();
	}
	
	public void setMail2Txt(String s) {
		mail2Txt.setText(s);
	}

	
	public String getMail2Txt(){
		return mail2Txt.getText();
	}

	public void setPrivateTelTxt(String s) {
		privateTelTxt.setText(s);
	}

	public String getPrivateTelTxt() {
		return privateTelTxt.getText();
	}

	public void setShortTxt(String s) {
		shortTxt.setText(s);
	}

	public String getShortTxt() {
		return shortTxt.getText();
	}
	
	public void setIcqElseTxt(String s){
		icqElseTxt.setText(s);
	}
	
	public String getIcqElseTxt() {
		return icqElseTxt.getText();
	}
	
	public void setCityTxt(String s){
		cityTxt.setText(s);
	}
	
	public String getCityTxt(){
		return cityTxt.getText();
	}
	
	public void setAddressTxt(String s){
		addressTxt.setText(s);
	}
	
	public String getAddressTxt(){
		return addressTxt.getText();
	}

	public void enableLastName(boolean b) {
		pLastNameTxt.setEditable(b);
	}

	public void enableFirstName(boolean b) {
		pFirstNameTxt.setEditable(b);
	}

	public void enableProffesion(boolean b) {
		professionNameTxt.setEditable(b);
	}

	public void enableTel(boolean b) {
		telTxt.setEditable(b);
	}

	public void enableMobile(boolean b) {
		mobileTxt.setEditable(b);
	}

	public void enableMail1(boolean b) {
		mail1Txt.setEditable(b);
	}
	
	public void enableMail2(boolean b) {
		mail2Txt.setEditable(b);
	}
	
	public void enablePrivateTel(boolean b) {
		privateTelTxt.setEditable(b);
	}

	public void enableShort(boolean b) {
		shortTxt.setEditable(b);
	}
	
	public void enableIcqElse(boolean b) {
		icqElseTxt.setEditable(b);
	}
	
	public void enableCity(boolean b){
		cityTxt.setEditable(b);
	}
	
	public void enableAddress(boolean b){
		addressTxt.setEditable(b);
	}
	
	/**
	 * Anpassungen nötig!!!
	 * @param id
	 */
	public void setDataRecord(int id) {
		SqlCon sc = new SqlCon();
		String[] sa = sc.getRow(id);
		setTextFirstName(sa[1]);
		setTextLastName(sa[0]);
		setTextProfession(sa[2]);
		setShortTxt(sa[3]);
		setTelTxt(sa[6]);
		setMobileTxt(sa[7]);
		setMail1Txt(sa[4]);
		setMail2Txt(sa[5]);
		setPrivateTelTxt(sa[8]);
		setIcqElseTxt(sa[9]);
		setCityTxt(sa[10] + " " + sa[11]);
		setAddressTxt(sa[12]);
	}

	/**
	 * returns
	 * firstname,lastname,profession,tel,mobile,mail1,mail2,privateTel,short
	 * ,icqElse,plz+city,address
	 * 
	 * @return
	 */
	public String[] getDataRecord() {
		String plz, ort;
		int temp=(!getCityTxt().contains(" "))?0:getCityTxt().indexOf(" ");
		plz = getCityTxt().substring(0,temp);
		
		if (temp==0) {
			ort = getCityTxt();
		} else {
			ort = getCityTxt().substring(getCityTxt().indexOf(" ") + 1);
		}
		String[] s = new String[] { getTextLastName(), getTextFirstName(),
				getTextProfession(), getShortTxt(), getMail1Txt(),
				getMail2Txt(), getTelTxt(), getMobileTxt(), getPrivateTelTxt(),
				getIcqElseTxt(), plz, ort, getAddressTxt() };
		return s;
	}

}
