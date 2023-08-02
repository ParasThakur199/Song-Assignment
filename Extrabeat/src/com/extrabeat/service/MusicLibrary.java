package com.extrabeat.service;

import java.util.HashMap;

import com.extrabeat.bean.Song;

public class MusicLibrary {
	public void musicLibrary(String genre, HashMap<String, Song> songdetails) {

		System.out.println(songdetails);
		songdetails.entrySet().stream()
		.filter(e -> e.getValue().getGenre().equalsIgnoreCase(genre))
		.forEach(e -> System.out.println("\nSong Title :"+e.getValue().getSongTitle()));
	}

}
