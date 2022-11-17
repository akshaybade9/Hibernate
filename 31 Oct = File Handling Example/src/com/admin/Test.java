package com.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.FileInfo;
import com.util.HibernateUtil;

public class Test {

	public static void main(String[] args) throws IOException {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session  = sf.openSession();
		
		FileInfo fileInfo = new FileInfo();
		
		File file =new File("F:\\File1.txt");
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());
		
		
		Path path =Paths.get(file.getAbsolutePath());      //  Data byte madhe ahe tr to DB madhe upload kraycha asel tr.....
		byte [] b = Files.readAllBytes(path);
		
		fileInfo.setfName(file.getAbsolutePath());
		fileInfo.setFileData(b);
		fileInfo.setFileSize(file.length());
		
		

		Date date = new Date(System.currentTimeMillis());
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy hh:mm:sss");
		String strDate = simpleDateFormat.format(date);
		
		fileInfo.setFileUploadDate(strDate);
		
		
		
		session.save(fileInfo);
		session.beginTransaction().commit();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
