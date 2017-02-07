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
	public int insert(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User search(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String uid, User newUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User displayAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
