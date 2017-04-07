package zxl.ContactSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainContact {
	public static void main(String[] args) {
		
		try {
			
			//2、获取用户输入
				//2.1、方式一
			/*Scanner scanner = new Scanner(System.in);
			String comand = scanner.next();*/
				//2.2、方式二(字节流转换为字符流)
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			ContaOperator operator = new ContactOperatorImpl();
			//3、根据输入执行不同操作
			while(true){
				//1、看到菜单
				printMenu();
				
				String comand = br.readLine();
				
				if ("1".equals(comand)) {
					Contact contact = new Contact();
					System.out.println("请输入编号");
					String id = br.readLine();
					
					System.out.println("请输入姓名");
					String name = br.readLine();
					
					System.out.println("请输入手机号");
					String phone = br.readLine();
					
					contact.setId(id);
					contact.setName(name);
					contact.setPhone(phone);
					operator.addContact(contact);
					
				} else if("2".equals(comand)) {
					System.out.println("请输入要删除的编号");
					String id= br.readLine();
					operator.deleteContact(id);
					
	
				}else if("3".equals(comand)) {
					List<Contact> list = operator.findContact();
					for (Contact contact : list) {
						System.out.println(contact);
					}
	
				}else if("4".equals(comand)) {
					Contact contact = new Contact();
					System.out.println("请输入要修改的编号");
					String id = br.readLine();
					
					System.out.println("请输入要修改的姓名");
					String name = br.readLine();
					System.out.println("请输入要修改的手机号");
					
					String phone = br.readLine();
					contact.setId(id);
					contact.setName(name);
					contact.setPhone(phone);
					
					operator.changeContact(contact);
					
	
				}else if("5".equals(comand)) {
					break;
				}else {
					System.out.println("输入的命令有误！请重新输入");
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
		System.out.println("[1]添加联系人");
		System.out.println("[2]删除联系人");
		System.out.println("[3]查找联系人");
		System.out.println("[4]修改联系人");
		System.out.println("[5]退出");
		System.out.println("====================");
	}

}
