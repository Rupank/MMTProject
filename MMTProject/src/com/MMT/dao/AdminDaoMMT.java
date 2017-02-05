package com.MMT.dao;

import java.io.IOException;

import com.MMT.bean.Admin;

public interface AdminDaoMMT {
	Admin search(String Aid) throws IOException, ClassNotFoundException;
}
