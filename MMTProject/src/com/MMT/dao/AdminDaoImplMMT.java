package com.MMT.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.MMT.bean.Admin;

public class AdminDaoImplMMT implements AdminDaoMMT {
	public Admin search(String Aid)  throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		File file=new File("AdminFile");
		FileInputStream fis=new FileInputStream(file) ;
		ObjectInputStream ois=new ObjectInputStream(fis);
		while(fis.available()>0){
			Admin ad=(Admin)ois.readObject();
			if(ad.getAdminId().equals(Aid)){
				
				ois.close();
				fis.close();
				return ad;
			}
		}
		ois.close();
		fis.close();
		
		
		return null;
	}

}
