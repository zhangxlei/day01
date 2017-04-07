package zxl.ContactSystem;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestContactOperatorImpl {
	ContaOperator operator = null;
	
	@Before
	public void init(){
		operator = new ContactOperatorImpl();
		
	}

	
	
	@Test
	public void testAddContact(){
		Contact contact = new Contact();
		contact.setId("3");
		contact.setName("Úwæ·");
		contact.setPhone("923857");
		operator.addContact(contact);
		
		
		
	}
	
	@Test
	public void testChangeContact(){
		Contact contact = new Contact();
		contact.setId("3");
		contact.setName("zhaodi");
		contact.setPhone("sfds");
		operator.changeContact(contact);
	
	}
	
	@Test
	public void testDeleteContact(){
		
		operator.deleteContact("3");
	
	}
	@Test
	public void testFindContact(){
		List<Contact> list = operator.findContact();
		for (Contact contact : list) {
			System.out.println(contact);
			
		}
		
	
	}

}
