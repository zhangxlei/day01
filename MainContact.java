package zxl.ContactSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainContact {
	public static void main(String[] args) {
		
		try {
			
			//2����ȡ�û�����
				//2.1����ʽһ
			/*Scanner scanner = new Scanner(System.in);
			String comand = scanner.next();*/
				//2.2����ʽ��(�ֽ���ת��Ϊ�ַ���)
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			ContaOperator operator = new ContactOperatorImpl();
			//3����������ִ�в�ͬ����
			while(true){
				//1�������˵�
				printMenu();
				
				String comand = br.readLine();
				
				if ("1".equals(comand)) {
					Contact contact = new Contact();
					System.out.println("��������");
					String id = br.readLine();
					
					System.out.println("����������");
					String name = br.readLine();
					
					System.out.println("�������ֻ���");
					String phone = br.readLine();
					
					contact.setId(id);
					contact.setName(name);
					contact.setPhone(phone);
					operator.addContact(contact);
					
				} else if("2".equals(comand)) {
					System.out.println("������Ҫɾ���ı��");
					String id= br.readLine();
					operator.deleteContact(id);
					
	
				}else if("3".equals(comand)) {
					List<Contact> list = operator.findContact();
					for (Contact contact : list) {
						System.out.println(contact);
					}
	
				}else if("4".equals(comand)) {
					Contact contact = new Contact();
					System.out.println("������Ҫ�޸ĵı��");
					String id = br.readLine();
					
					System.out.println("������Ҫ�޸ĵ�����");
					String name = br.readLine();
					System.out.println("������Ҫ�޸ĵ��ֻ���");
					
					String phone = br.readLine();
					contact.setId(id);
					contact.setName(name);
					contact.setPhone(phone);
					
					operator.changeContact(contact);
					
	
				}else if("5".equals(comand)) {
					break;
				}else {
					System.out.println("�����������������������");
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	private static void printMenu() {
		System.out.println("====================");
		System.out.println("[1]�����ϵ��");
		System.out.println("[2]ɾ����ϵ��");
		System.out.println("[3]������ϵ��");
		System.out.println("[4]�޸���ϵ��");
		System.out.println("[5]�˳�");
		System.out.println("====================");
	}

}
