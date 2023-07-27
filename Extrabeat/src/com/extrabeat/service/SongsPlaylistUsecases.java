package com.extrabeat.service;

import java.util.HashMap;

import com.extrabeat.bean.Artist;
import com.extrabeat.bean.Song;

public class SongsPlaylistUsecases {

	public HashMap<String, Song> addAllSongs() {
		HashMap<String, Song> songdetails = new HashMap<>();

		Song s1 = new Song(1, "Kaha se kaha tak", "Krsna", 3, "Hip Hop", 2);
		songdetails.put(s1.getSongTitle(), s1);

		Song s2 = new Song(2, "laung da lashkara", "Amar Singh Chamkeela", 40, "Bhangra", 5);
		songdetails.put(s2.getSongTitle(), s2);

		Song s3 = new Song(3, "Hosh waalo ko khabar kya", "adnaan saami", 2, "Ghazal", 4);
		songdetails.put(s3.getSongTitle(), s3);

		Song s4 = new Song(4, "Achyutam keshavam", "Ankit Batra", 20, "Bhajan", 3);
		songdetails.put(s4.getSongTitle(), s4);

		Song s5 = new Song(5, "Labon ko", "KK", 26, "Romantic", 2);
		songdetails.put(s5.getSongTitle(), s5);

		return songdetails;
	}

	public HashMap<String, Artist> artistDetails() {
		HashMap<String, Artist> artistdetails = new HashMap<>();

		Artist a1 = new Artist(1, "Krsna", "Kaha se kaha tak, No Cap, Been a while", "Hip Hop");
		artistdetails.put(a1.getArtistName(), a1);

		Artist a2 = new Artist(2, "Diljeet Dosanjh", "laung dalashkara, vibe, GOAT", "Bhangra");
		artistdetails.put(a2.getArtistName(), a2);

		Artist a3 = new Artist(3, "Jagjeet Singh", "Jhuki Jhuki si nazar, tere baare m jab socha nahi tha", "Ghazal");
		artistdetails.put(a3.getArtistName(), a3);

		Artist a4 = new Artist(4, "Armonium", "layak, ram siya ram, shivtandav strotram", "Bhajan");
		artistdetails.put(a4.getArtistName(), a4);

		Artist a5 = new Artist(5, "KK", "Labon ko, Zara sa, dil ibaadat", "Romantic");
		artistdetails.put(a5.getArtistName(), a5);

		Artist a6 = new Artist(6, "Arijit Singh", "Kesariya, Galtiyaan, Khairiyat", "Romantic");
		artistdetails.put(a6.getArtistName(), a6);

		return artistdetails;
	}

}
