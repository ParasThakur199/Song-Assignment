package com.extrabeat.bean;

public class Artist {
	private Integer artistId;
	private String artistName;
	private String artistGenre;
	private String popularSongs;

	public Artist() {
	}

	public Artist(Integer artistId, String artistName, String popularSongs, String artistGenre) {
		this.artistId = artistId;
		this.artistName = artistName;
		this.artistGenre = artistGenre;
		this.popularSongs = popularSongs;

	}

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistGenre() {
		return artistGenre;
	}

	public void setArtistGenre(String artistGenre) {
		this.artistGenre = artistGenre;
	}

	public String getPopularSongs() {
		return popularSongs;
	}

	public void setPopularSongs(String popularSongs) {
		this.popularSongs = popularSongs;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", artistGenre=" + artistGenre
				+ ", popularSongs=" + popularSongs + "]";
	}

}
