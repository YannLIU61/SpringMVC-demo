package com.springmvc.entities;

public class User {
	private Integer id;
	private String name;
	private String mail;
	private String pwd;
	private int age;

	private Addresse addresse;

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Addresse getAddresse() {
		return addresse;
	}

	public void setAddresse(Addresse addresse) {
		this.addresse = addresse;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mail=" + mail + ", pwd=" + pwd + ", age=" + age + "]";
	}

	public User(Integer id, String name, String mail, String pwd, int age) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.pwd = pwd;
		this.age = age;
	}

	public User(String name, String mail, String pwd, int age) {
		this.name = name;
		this.mail = mail;
		this.pwd = pwd;
		this.age = age;
	}

	public User() {
	}

	

}
