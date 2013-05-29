package conf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class ConfInterface {
	
	
	
	private InputStream is;

	public String getInfoAttribute() {
		String infoAttribute = "";
		try {
			is=this.getClass().getClassLoader().getResourceAsStream("conf/conf.xml");
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(is);
			Element root = doc.getRootElement();
			Element info = root.getChild("Info");

			int i = 1;
			while (info.getChild("p" + i) != null) {
				Element tempElement = info.getChild("p" + i);
				infoAttribute += (tempElement.getText() + "\n");
				i++;
			}
		} catch (Exception e) {
			System.err.println("Fehler beim einlesen des Info-XML-Attributes");
			e.printStackTrace();
		}
		return infoAttribute;
	}
	
}