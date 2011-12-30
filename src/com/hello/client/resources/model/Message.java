package com.hello.client.resources.model;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Message extends BaseModel {
	public Message(){
		
	}
	public Message(String id, String name, String org, int age) {
		super();
		this.setId(id);
		this.setName(name);
		this.setOrg(org);
		this.setAge(age);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getId() {
		return super.get("id");
	}
	public void setId(String id) {
		super.set("id", id);
	}
	public String getName() {
		return super.get("name");
	}
	public void setName(String name) {
		super.set("name", name);
	}
	public String getOrg() {
		return super.get("org");
	}
	public void setOrg(String org) {
		super.set("org", org);
	}
	public int getAge() {
		return super.get("age");
	}
	public void setAge(int age) {
		super.set("age", age);
	}
	
}
