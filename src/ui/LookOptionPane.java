package ui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



import conf.ConfInterface;


public class LookOptionPane extends JOptionPane {
	
	public LookOptionPane() {
		GuiTool uitool = new GuiTool();
		String[] genderOptions = { "Metall-LookAndFeel", "Nimbus-LookAndFeel",
				"System-LookAndFeel", "Motif-LookAndFeel" };
		String gender = (String) JOptionPane.showInputDialog(null, "Style",
				"Bevorzugtes LookAndFeel wählen:", JOptionPane.QUESTION_MESSAGE,
				new ImageIcon(uitool.getImage(5)), genderOptions,
				genderOptions[1]);
		
		try {
			if (gender.equals(genderOptions[0])) {
				GUI.setStyle("javax.swing.plaf.metal.MetalLookAndFeel");
			} else if (gender.equals(genderOptions[1])) {
				GUI.setStyle("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} else if (gender.equals(genderOptions[2])) {
				GUI.setStyle("System");
			} else if (gender.equals(genderOptions[3])) {
				GUI.setStyle("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			}
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
	}

}
