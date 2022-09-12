package com.demoapp.modals;

public class Contact {
	private int user_id;
	private String user_name;
	private String user_email_id;
	private String user_phone_number;
	private int is_user_a_customer;
	private int is_user_in_contact_book;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email_id() {
		return user_email_id;
	}

	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
	}

	public String getUser_phone_number() {
		return user_phone_number;
	}

	public void setUser_phone_number(String user_phone_number) {
		this.user_phone_number = user_phone_number;
	}

	public int getIs_user_a_customer() {
		return is_user_a_customer;
	}

	public void setIs_user_a_customer(int is_user_a_customer) {
		this.is_user_a_customer = is_user_a_customer;
	}

	public int getIs_user_in_contact_book() {
		return is_user_in_contact_book;
	}

	public void setIs_user_in_contact_book(int is_user_in_contact_book) {
		this.is_user_in_contact_book = is_user_in_contact_book;
	}
}