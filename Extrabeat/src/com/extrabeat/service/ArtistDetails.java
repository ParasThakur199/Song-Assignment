package com.extrabeat.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.extrabeat.bean.Artist;

public class ArtistDetails {
	public void artistDetailsInput(HashMap<String, Artist> artistData) {
		try {
			FileInputStream fis = new FileInputStream("Artist.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			int count = ois.readInt();
			for (int i = 0; i < count; i++) {
				Artist pt = (Artist) ois.readObject();
				artistData.put(pt.getArtistName(), pt);
			}

			fis.close();
			ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void artistDetailsOutput(HashMap<String, Artist> artistData) {

		FileOutputStream fos;
		try {
			fos = new FileOutputStream("Artist.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeInt(artistData.size());

			for (Artist pt : artistData.values()) {
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
//	public HashMap<String, Artist> artistDetails() {
//		HashMap<String, Artist> artistdetails = new HashMap<>();
//
//		Artist a1 = new Artist(1, "Krsna", "Kaha se kaha tak, No Cap, Been a while", "Hip Hop");
//		artistdetails.put(a1.getArtistName(), a1);
//
//		Artist a2 = new Artist(2, "Diljeet Dosanjh", "laung dalashkara, vibe, GOAT", "Bhangra");
//		artistdetails.put(a2.getArtistName(), a2);
//
//		Artist a3 = new Artist(3, "Jagjeet Singh", "Jhuki Jhuki si nazar, tere baare m jab socha nahi tha", "Ghazal");
//		artistdetails.put(a3.getArtistName(), a3);
//
//		Artist a4 = new Artist(4, "Armonium", "layak, ram siya ram, shivtandav strotram", "Bhajan");
//		artistdetails.put(a4.getArtistName(), a4);
//
//		Artist a5 = new Artist(5, "KK", "Labon ko, Zara sa, dil ibaadat", "Romantic");
//		artistdetails.put(a5.getArtistName(), a5);
//
//		Artist a6 = new Artist(6, "Arijit Singh", "Kesariya, Galtiyaan, Khairiyat", "Romantic");
//		artistdetails.put(a6.getArtistName(), a6);
//
//		return artistdetails;
//	}
}
