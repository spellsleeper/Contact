package ui;

import java.awt.Image;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class GuiTool {

	private static ArrayList<Image> imageList = new ArrayList<Image>();

	public Image getImage(int i) {
		if (imageList.isEmpty()) {
			loadImgs();
		}
		return imageList.get(i);
	}

	private void loadImgs() {
		String[] imgUrls = {
				"/media/emblem-people.png",
				"/media/emblem-desktop.png", 
				"/media/emblem-default.png",
				"/media/emblem-trash.png",
				"/media/gnome-logout.png",
				"/media/applications-graphics.png",
				"/media/dialog-information.png",
				"/media/stock_unknown.png",
				"/media/stock_landline-phone.png",
				"/media/handy.png",					//10 -[9]
				"/media/stock_mail-import.png",
				"/media/stock_contact.png",
				"/media/go-next.png",
				"/media/go-previous.png",
				"/media/preferences-system.png",
				"/media/stock_edit.png",
				"/media/process-stop.png",
				"/media/stock_addressbook.png",
				"/media/msg.png",
				"/media/format-indent-less.png",	//20 -[19]
				"/media/format-indent-more.png",
				"/media/emblem-web.png",
				"/media/go-home.png"};
		
		for (int i = 0; i < imgUrls.length; i++) {
			try {
				imageList.add(ImageIO.read(getClass().getResource(imgUrls[i])));

			} catch (Exception ex) {
				System.err.println("Fehler beim Laden der Bilder");
				ex.printStackTrace();
			}
		}
	}
}
