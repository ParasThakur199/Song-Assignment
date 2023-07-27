package com.extrabeat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extrabeat.bean.Artist;

public class MusicLibrary {
	public void musicLibrary(String genre) {
		SongsPlaylistUsecases usecase = new SongsPlaylistUsecases();
		HashMap<String, Artist> artistdetails = usecase.artistDetails();
		List<Artist> art = new ArrayList<>();
		for (Map.Entry<String, Artist> mp : artistdetails.entrySet()) {
			if (genre.equals(mp.getValue().getArtistGenre())) {
				art.add(mp.getValue());

			}
		}
//		System.out.println(art);
		for (Artist el : art) {
			System.out.println("\nArtistID : " + el.getArtistId());
			System.out.println("Artist Name : " + el.getArtistName());
			System.out.println("Artist Genre : " + el.getArtistGenre());
			System.out.println("Popular Songs : " + el.getPopularSongs() + "\n");
		}
	}

}
