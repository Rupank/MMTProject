package com.MMT.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.MMT.bean.User;
import com.MMT.helper.MyAppendObjectOutputStream;

public class UserDaoImplMMT implements UserDaoMMT {
	@Override
	public User search(String uid) throws FileNotFoundException, IOException, ClassNotFoundException {
		File userFile=new File("UserFile");
		FileInputStream fis=new FileInputStream(userFile);
		ObjectInputStream ois=new ObjectInputStream(fis);
		while(fis.available()>0){
			User user=(User)ois.readObject();
			if(user.getUserId().equals(uid)){
				ois.close();
				fis.close();
				return user;
			}
		}
		ois.close();
		fis.close();
		return null;
	}
	public boolean addUser(User user) throws FileNotFoundException, IOException {
		File userFile = new File("UserFile");
		ObjectOutputStream oos=null;
		FileOutputStream  fos=null;
		if(!userFile.exists()){
			fos=new FileOutputStream(userFile);
			oos=new ObjectOutputStream(fos);
		}
		else{
			fos=new FileOutputStream(userFile,true);
			oos=new MyAppendObjectOutputStream(fos);
		}
		oos.writeObject(user);
		oos.close();
		fos.close();
		return true;
	}
}
