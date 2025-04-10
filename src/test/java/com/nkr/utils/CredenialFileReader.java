package com.nkr.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CredenialFileReader {

	public void init_prop() {
	File file = new File ("Config.properties");
	FileInputStream fileinput = null;
	
	try {
		
		fileinput = new FileInputStream (file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		Properties propr = new Properties();
		try {
			
			propr.load(fileinput);
		}catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
}
