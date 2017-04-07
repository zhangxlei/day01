package zxl.ContactSystem;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

//xml的工具类
public class XMLUtil {
	public static Document getDocument(){
		try {
			Document doc = new SAXReader().read("g:/contact.xml");
			return doc;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

		
		
		
	}
	public static  void write2xml(Document doc){
		try {
			FileOutputStream out = new FileOutputStream("g:/contact.xml");
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			XMLWriter xWriter = new XMLWriter(out,format);
			xWriter.write(doc);
			xWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
		
	}
	
}
