package ui;

import javax.swing.JTabbedPane;

public class TabContainer extends JTabbedPane {
	
	static ExchangingPanel exchangingPanel=new ExchangingPanel();
	EditPanel editPanel;
	InsertPanel insertPanel;
	OverviewPanel overviewPanel;
	public static TabContainer tabContainer;
	public TabContainer() {
		super();
		addTab("Hauptkarte",exchangingPanel);
		tabContainer=this;
		
	}
	
	public void addEditPanelTab(int id){
		int tabs=this.getTabCount();
		for(int i=0;i<tabs;i++){
			if(this.getTitleAt(i).equals("Bearbeitung")){
				this.remove(i);
			}
		}
		editPanel=new EditPanel(id);
		this.addTab("Bearbeitung", editPanel);
		this.setSelectedIndex(this.getSelectedIndex()+1);
	}
	
	public void removeEditPanelTab(){
		this.remove(editPanel);
		
	}
	
	public void addInsertPanelTab(){
		int tabs=this.getTabCount();
		for(int i=0;i<tabs;i++){
			if(this.getTitleAt(i).equals("Einfügen")){
				this.remove(i);
			}
		}
		insertPanel=new InsertPanel();
		this.addTab("Einfügen", insertPanel);
		this.setSelectedIndex(this.getSelectedIndex()+1);
	}
	
	public void removeInsertPanelTab(){
		this.remove(insertPanel);
		
	}
	public void addOverviewPanel(){
		int tabs=this.getTabCount();
		for(int i=0;i<tabs;i++){
			if(this.getTitleAt(i).equals("Übersicht")){
				this.remove(i);
			}
		}
		overviewPanel=new OverviewPanel();
		this.addTab("Übersicht", overviewPanel);
		this.setSelectedIndex(this.getSelectedIndex()+1);
	}
	
	public void removeOverviewPanelTab(){
		this.remove(overviewPanel);
	}
	
	
}
