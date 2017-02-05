package com.MMT.helper;

import java.util.Scanner;

import com.MMT.bean.User;

public class UserDataMMT {
	
	private User user = new User(null, null, 0, null, null, null,null);
	private Scanner sc;
	public void input(){
		sc = new Scanner(System.in);
		System.out.println("Enter Username : ");
		user.setUserId(sc.next());
		System.out.println("Enter your first name : ");
		user.setUserName(sc.next());
		System.out.println("Enter your Phone no : ");
		user.setUserPhoneNo(sc.nextInt());
		System.out.println("Enter your EmailID : ");
		user.setUserEmailId(sc.next());
		System.out.println("Enter your Address : ");
		user.setUserAddress(sc.next());
		System.out.println("Enter your Password : ");
		user.setUserpassword(sc.next());
		System.out.println("Enter your Wallet ID : ");
		user.setUserWalletId(sc.next());
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
