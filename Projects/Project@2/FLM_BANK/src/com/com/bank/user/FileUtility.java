package com.bank.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtility {
	public FileUtility() {
	}

	public static void readLogoFromFileSystem() {
		File f = new File("E:/NNBank/NNBank.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = null;

			try {
				line = br.readLine();
			} catch (IOException var4) {
				var4.printStackTrace();
			}

			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException var5) {
			System.out.println("Error in Logo loading , please check and re launch !!");
			System.exit(0);
		}

	}
}
