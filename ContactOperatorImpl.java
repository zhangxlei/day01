package zxl.ContactSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ContactOperatorImpl implements ContaOperator {//实现接口的功能

	@Override
	public void addContact(Contact contact) {
		// TODO Auto-generated method stub
		try {
			File file = new File("g:/contact.xml");
			Document doc = null;
			Element rootElement =  null;
			if(!file.exists()){
				 doc = DocumentHelper.createDocument();
				 rootElement = doc.addElement("contactList");
				
				
			}else {
				//如果有xml文档则读取
				 doc = XMLUtil.getDocument();
				 rootElement = doc.getRootElement();
			}
			
			Element conele = rootElement.addElement("contact");
			Element idAtt = conele.addAttribute("id", contact.getId());
			conele.addElement("name").setText(contact.getName());
			conele.addElement("phone").setText(contact.getPhone());
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} 

	}

	
	
	@Override
	public void deleteContact(String id) {
		// TODO Auto-generated method stub
		try {
			Document doc = XMLUtil.getDocument();
			Element conEle = (Element) doc.selectSingleNode("//contact[@id='"+id+"']");
			conEle.detach();
			
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		

	}

	
	
	@Override
	public List<Contact> findContact() {
		// TODO Auto-generated method stub
		Document doc = XMLUtil.getDocument();
		ArrayList<Contact> list = new ArrayList<Contact>();
		List<Element> conList = (List<Element>)doc.selectNodes("//contact");
		for (Element element : conList) {
			Contact contact = new Contact();
			contact.setId(element.attributeValue("id"));
			contact.setName(element.elementText("name"));
			contact.setPhone(element.elementText("phone"));
			list.add(contact);
			
		}
		return list;
	}

	
	
	
	@Override
	public void changeContact(Contact contact) {
		// TODO Auto-generated method stub
		try {
			Document doc = XMLUtil.getDocument();
			Element conEle = (Element) doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
			conEle.element("name").setText(contact.getName());
			conEle.element("phone").setText(contact.getPhone());
			
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		

	}

}
