package com.extrabeat.bean;

import java.io.Serializable;
import java.util.Objects;

public class Song  implements Serializable{
	private String songTitle;
	private String artist;
	private Integer duration;
	private String genre;
	private double rating;

	public Song() {
	}

	public Song(String songTitle, String artist, Integer duration, String genre, double rating) {
		super();
		this.songTitle = songTitle;
		this.artist = artist;
		this.duration = duration;
		this.genre = genre;
		this.rating = rating;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artist, duration, genre, rating, songTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return Objects.equals(artist, other.artist) && Objects.equals(duration, other.duration)
				&& Objects.equals(genre, other.genre)
				&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating)
				&& Objects.equals(songTitle, other.songTitle);
	}

	@Override
	public String toString() {
		return "Song [songTitle=" + songTitle + ", artist=" + artist + ", duration=" + duration + ", genre=" + genre
				+ ", rating=" + rating + "]";
	}
}
