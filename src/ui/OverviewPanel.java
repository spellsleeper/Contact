package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import dbInterface.SqlCon;

public class OverviewPanel extends JPanel implements ActionListener{
	
	private JTable table;
	private JPanel southPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JScrollPane northScrollPane;
	TabContainer tabCon=TabContainer.tabContainer;
	private SqlCon sc=new SqlCon();
	private GuiTool guiTool=new GuiTool();
	private JButton abortButton=new JButton(new ImageIcon(guiTool.getImage(16)));
	private String[][]rowData;
	public OverviewPanel() {
		super();
		ColumnPushAction cpa=new ColumnPushAction();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		abortButton.setToolTipText("Abbrechen");
		abortButton.addActionListener(this);
		String[] columnHeader={"Vorname","Zuname","Beruf/Titel","Telefon","Priv. Telefon","Handy","E-Mail(1)","E-Mail(2)","Instant-Messaging","Kürzel","Ort","Adresse"};
		rowData=sc.getOverviewData();
		table=new JTable(rowData, columnHeader);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.addMouseListener(cpa);
		for(Component c:table.getComponents()){
			c.addMouseListener(cpa);
		}
		northScrollPane=new JScrollPane(table);
		add(northScrollPane);
		southPanel.add(abortButton);
		add(southPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==abortButton){
			TabContainer.tabContainer.removeOverviewPanelTab();
		}
		
	}
	private class ColumnPushAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			Component c=e.getComponent();
			JTable table=null;
			try {
				if(c.getClass()==Class.forName("javax.swing.JTable")){
					table=(JTable)c;
					int r=table.getSelectedRow();
					int id=sc.getDataRecordID(rowData[r][0], rowData[r][1]);
					System.out.println(id);
					tabCon.exchangingPanel.setDataRecord(id);
					tabCon.setSelectedIndex(tabCon.getSelectedIndex()-1);
					
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		

		
		
	}

}
