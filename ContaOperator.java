package zxl.ContactSystem;

import java.util.List;

public interface ContaOperator {
	public void addContact(Contact contact);//������ϵ��
	public void deleteContact(String id);//ɾ����ϵ��
	public List<Contact> findContact();//������ϵ��
	public void changeContact(Contact contact);//�޸���ϵ��

}
