package people;

import java.io.Serializable;

public class Person implements Serializable {// 序列化接口

	String categorie; // 部门
	String number; // 编号
	String sex;  //性别
	String name; // 姓名
	int age; // 年龄
	double salary; // 工资

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
		return "部门：" + categorie + "编号：" + number + "性别；"+sex+"姓名：" + name + "年龄：" + age + "工资：" + salary;
	}

}
