package com.kh.keeper.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.keeper.view.KeeperView;

public class KeeperRun {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		prop.setProperty("A", "B");
		
		try {
			prop.storeToXML(new FileOutputStream("member-mapper.xml"), "MEMBER SQL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		new KeeperView().mainMenu();
		
		
		

	}

}
