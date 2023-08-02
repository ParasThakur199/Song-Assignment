package com.extrabeat.bean;

import java.io.Serializable;
import java.util.Objects;

public class Artist implements Serializable{
	private String artistName;
	private String artistGenre;
	private String popularSongs;

	public Artist() {
	}

	public Artist(String artistName, String artistGenre, String popularSongs) {
		this.artistName = artistName;
		this.artistGenre = artistGenre;
		this.popularSongs = popularSongs;
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
	public int hashCode() {
		return Objects.hash(artistGenre, artistName, popularSongs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		return Objects.equals(artistGenre, other.artistGenre) && Objects.equals(artistName, other.artistName)
				&& Objects.equals(popularSongs, other.popularSongs);
	}

	@Override
	public String toString() {
		return "Artist [artistName=" + artistName + ", artistGenre=" + artistGenre + ", popularSongs=" + popularSongs
				+ "]";
	}

}
