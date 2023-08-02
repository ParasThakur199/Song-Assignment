package com.extrabeat.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.extrabeat.bean.Playlist;

public class PlaylistDetails {
	
		public void playlistDetailsInput(Map<String, Playlist> playlistdetails) {
			try {
				FileInputStream fis = new FileInputStream("Playlist.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				int count = ois.readInt();
				for (int i = 0; i < count; i++) {
					Playlist pt = (Playlist) ois.readObject();
					playlistdetails.put(pt.getsongName(), pt);
				}

				fis.close();
				ois.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}

		public void playlistDetailsOutput(Map<String, Playlist> playlistdetails) {
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("Playlist.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeInt(playlistdetails.size());

				for (Playlist pt : playlistdetails.values()) {
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
