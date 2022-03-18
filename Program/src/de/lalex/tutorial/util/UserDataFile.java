package de.lalex.tutorial.util;

import java.io.File;

public class UserDataFile {

	private static String winpath = "C://ProgramData";
	private static String path = "C://Freemusic_App";
	private static File win = new File(winpath);
	private static File dir = new File(path);
	
	public static void main(String[] args) {		

		if(win.exists()) {
			String path2 = "C://ProgramData//Freemusic_App";
			File dir2 = new File(path2);
			if(!dir2.exists()) {
				if(dir2.mkdir()) {
					System.out.println("Folder has been created successfully");
				} else {
					System.out.println("Folder failed to be created");
				}
			} else {
			System.out.println("Folder already exist");
			}
		} else {
			if(!dir.exists()) {
				if(dir.mkdir()) {
					System.out.println("Folder has been created successfully");
				} else {
					System.out.println("Folder failed to be created");
				}
			} else {
			System.out.println("Folder already exist");
			}
		}
		
	}
	
	public static String path() {
		if(win.exists()) return winpath + "//Freemusic_App";
		return path;
	}
	
}
