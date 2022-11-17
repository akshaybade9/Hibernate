package com.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.FileInfo;
import com.util.HibernateUtil;

public class Test1 {

	public static void main(String[] args) throws IOException {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		String newPath = "F:\\Java\\";

		FileInfo fileInfo = session.get(FileInfo.class, 1);
		
		File file = new File(fileInfo.getfName());

		Path path = Paths.get(newPath + file.getName());

		Files.write(path, fileInfo.getFileData());

	}

}
