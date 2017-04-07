package zxl.ContactSystem;

import java.util.List;

public interface ContaOperator {
	public void addContact(Contact contact);//增加联系人
	public void deleteContact(String id);//删除联系人
	public List<Contact> findContact();//查找联系人
	public void changeContact(Contact contact);//修改联系人

}
