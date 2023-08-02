package com.extrabeat.service;

import java.util.HashMap;

import com.extrabeat.bean.Song;

public class SongsRecommendation {
	public void songRecommendByRating(HashMap<String, Song> songdetails) {
//		SongsPlaylistUsecases usecase = new SongsPlaylistUsecases();
		System.out.println(songdetails);
		songdetails.entrySet().stream()
		.filter(e -> e.getValue().getRating() > 3)
		.forEach(e -> System.out.println("Top Rated Song Name :" + e.getKey() + "  Song Rating : " + e.getValue().getRating()));

	}
}
