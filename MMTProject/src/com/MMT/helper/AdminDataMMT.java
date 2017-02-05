package com.MMT.helper;

import java.util.Scanner;

import com.MMT.bean.Admin;

public class AdminDataMMT {
	private Admin admin=new Admin();
	public void input(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Admin id : ");
		admin.setAdminId("admin");
		System.out.println("Enter Admin name : ");
		admin.setAdminName("admin");
		System.out.println("Enter Admin Phone no : ");
		admin.setAdminPhoneNo(1234);
		System.out.println("Enter Admin EmailID : ");
		admin.setAdminEmailId("admin@gmail.com");
		System.out.println("Enter Admin Address : ");
		admin.setAdminAddress("A 5,Sec 22A");
		System.out.println("Enter Admin Password : ");
		admin.setAdminPassword("admin");
	
		
		
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
