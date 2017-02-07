package com.MMT.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.MMT.bean.User;

public interface UserDaoMMT {
	public int insert(User user) ;
	public User search(String  uid) ;
	public User delete (String uid) ;
	public boolean update(String uid, User newUser);
	public User displayAll();
}
