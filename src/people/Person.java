package people;

import java.io.Serializable;

public class Person implements Serializable {// ���л��ӿ�

	String categorie; // ����
	String number; // ���
	String sex;  //�Ա�
	String name; // ����
	int age; // ����
	double salary; // ����

	public Person() { 
	}

	public Person(String categorie, String number, String sex,String name, int age, double salary) {
		this.categorie = categorie;
		this.number = number;
		this.sex= sex;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String toString() {
		return "���ţ�" + categorie + "��ţ�" + number + "�Ա�"+sex+"������" + name + "���䣺" + age + "���ʣ�" + salary;
	}

}
