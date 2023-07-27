package com.extrabeat.bean;

import java.io.Serializable;

public class Playlist implements Serializable {
	private String songName;
	private String artistName;

	public Playlist() {
	}

	public Playlist(String songName, String artistName) {
		this.songName = songName;
		this.artistName = artistName;
	}

	public String getsongName() {
		return songName;
	}

	public void setsongName(String songName) {
		this.songName = songName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@Override
	public String toString() {
		return "Playlist [songName=" + songName + ", artistName=" + artistName + "]";
	}

}
