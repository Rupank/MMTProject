package com.MMT.helper;

import java.util.Scanner;

import com.MMT.bean.Admin;

public class AdminDataMMT {
	private Admin admin=new Admin();
	public void input(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Admin id : ");
		admin.setAdminId(sc.nextInt());
		System.out.println("Enter Admin name : ");
		admin.setAdminName(sc.next());
		System.out.println("Enter Admin Phone no : ");
		admin.setAdminPhoneNo(sc.nextInt());
		System.out.println("Enter Admin EmailID : ");
		admin.setAdminEmailId(sc.next());
		System.out.println("Enter Admin Address : ");
		admin.setAdminAddress(sc.next());
		System.out.println("Enter Admin Password : ");
		admin.setAdminPassword(sc.next());
	
		
		
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
