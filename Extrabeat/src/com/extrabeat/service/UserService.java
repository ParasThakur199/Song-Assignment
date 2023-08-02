package com.extrabeat.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

import com.extrabeat.bean.User;

public class UserService {

	public void userDetailsInput(Set<User> arr) {
		try {
			FileInputStream fis = new FileInputStream("User.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			int count = ois.readInt();
			for (int i = 0; i < count; i++) {
				User pt = (User) ois.readObject();
				System.out.println(pt);
				arr.add(pt);
			}

			fis.close();
			ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void userDetailsOutput(Set<User> arr) {

		FileOutputStream fos;
		try {
			fos = new FileOutputStream("User.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeInt(arr.size());

			for (User pt : arr) {
				oos.writeObject(pt);
			}

			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
