package com.MMT.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.MMT.bean.User;

public interface UserDaoMMT {
	public boolean addUser(User user) throws FileNotFoundException, IOException;
	public User search(String  uid) throws FileNotFoundException, IOException, ClassNotFoundException;
}
