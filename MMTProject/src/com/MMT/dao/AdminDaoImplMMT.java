package com.MMT.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.MMT.bean.Admin;

import com.MMT.helper.MyAppendObjectOutputStream;

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
	public boolean addAdmin(Admin admin) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		File adminFile = new File("AdminFile");
		ObjectOutputStream oos=null;
		FileOutputStream  fos=null;
		if(!adminFile.exists()){
			fos=new FileOutputStream(adminFile);
			oos=new ObjectOutputStream(fos);
		}
		else{
			fos=new FileOutputStream(adminFile,true);
			oos=new MyAppendObjectOutputStream(fos);
		}
		oos.writeObject(admin);
		oos.close();
		fos.close();
		return true;
	}
}
