package com.extrabeat.bean;

public class Song {
	private Integer songId;
	private String songTitle;
	private String artist;
	private Integer duration;
	private String genre;
	private Integer rating;

	public Song() {
	}

	public Song(Integer songId, String songTitle, String artist, Integer duration, String genre, Integer rating) {
		this.songId = songId;
		this.songTitle = songTitle;
		this.artist = artist;
		this.duration = duration;
		this.genre = genre;
		this.rating = rating;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songTitle=" + songTitle + ", artist=" + artist + ", duration=" + duration
				+ ", genre=" + genre + ", rating=" + rating + "]";
	}

}
