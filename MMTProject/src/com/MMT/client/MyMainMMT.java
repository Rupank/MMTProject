package com.MMT.client;

import java.util.Scanner;

import com.MMT.ui.MyMenuMMT;

public class MyMainMMT {
	public static void main(String[] args) {
		MyMenuMMT menu=new MyMenuMMT();
		Scanner sc=new Scanner(System.in);
		while(true){
			menu.displayMenu();
		}
	}

}
