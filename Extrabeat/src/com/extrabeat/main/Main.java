package com.extrabeat.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.extrabeat.bean.Artist;
import com.extrabeat.bean.Playlist;
import com.extrabeat.bean.Song;
import com.extrabeat.bean.User;
import com.extrabeat.service.MusicLibrary;
import com.extrabeat.service.PlaylistDetails;
import com.extrabeat.service.SongsRecommendation;
import com.extrabeat.service.SongsPlaylistUsecases;

public class Main {

	public static void main(String[] args) {

		PlaylistDetails plDetails = new PlaylistDetails();
		SongsPlaylistUsecases usecases = new SongsPlaylistUsecases();
		Map<String, Playlist> playlistdetails = new HashMap<>();
		plDetails.playlistDetailsInput(playlistdetails);
		Scanner sc = new Scanner(System.in);

		int choice;
		do {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=--=-=");
			System.out.println("1. Get Specific Song");
			System.out.println("2. Get Artist Details");
			System.out.println("3. Create Playlist");
			System.out.println("4. Remove Song by Name");
			System.out.println("5. Show Entire Playlist");
			System.out.println("6. Top Songs by Rating");
			System.out.println("7. Music Library(Check by Genre)");
			System.out.println("8. Get User Preference");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=--=-=");
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Please Enter Song Name :");
				String name = sc.nextLine();
				HashMap<String, Song> songdetails = usecases.addAllSongs();
				Song song = songdetails.get(name);
				if (song != null) {
					System.out.println("\nSongID : " + song.getSongId());
					System.out.println("Title : " + song.getSongTitle());
					System.out.println("Artist : " + song.getArtist());
					System.out.println("Genre : " + song.getGenre());
					System.out.println("Rating : " + song.getRating() + "\n");
				} else {
					System.out.println("\nSong not found.\n");
				}
				break;

			case 2:
				System.out.println("Please Enter Artist name");
				String artistName = sc.nextLine();
				HashMap<String, Artist> artistdetails = usecases.artistDetails();
				Artist artist = artistdetails.get(artistName);
				if (artist != null) {
					System.out.println("\nArtistID : " + artist.getArtistId());
					System.out.println("Artist Name : " + artist.getArtistName());
					System.out.println("Artist Genre : " + artist.getArtistGenre());
					System.out.println("Popular Songs : " + artist.getPopularSongs() + "\n");
				} else {
					System.out.println("\nArtist not found\n");
				}
				break;

			case 3:
				System.out.println("Please Enter Song Name");
				String SongName = sc.nextLine();
				System.out.println("Please Enter Artist Name");
				String ArtistName = sc.nextLine();
				Playlist playlist = new Playlist(SongName, ArtistName);
				playlistdetails.put(SongName, playlist);
				plDetails.playlistDetailsOutput(playlistdetails);
				System.out.println("Playlist created: " + playlist);
				break;

			case 4:
				System.out.println("Enter Song Name to delete: ");
				String songNameToDelete = sc.nextLine();

				if (playlistdetails.containsKey(songNameToDelete)) {
					playlistdetails.remove(songNameToDelete);
					plDetails.playlistDetailsOutput(playlistdetails);
					System.out.println("Song deleted Successfully");
				} else {
					System.out.println("Song not found in the playlist.");
				}
				break;

			case 5:
				for (Playlist v : playlistdetails.values()) {
					System.out.println("\nSong-Name: " + v.getsongName() + "     Artist-Name: " + v.getArtistName());
				}
				System.out.println();
				break;

			case 6:
				SongsRecommendation sr = new SongsRecommendation();
				sr.songRecommendByRating();
				break;

			case 7:
				MusicLibrary music = new MusicLibrary();
				System.out.println("Enter the Genre");
				String genre = sc.nextLine();
				music.musicLibrary(genre);
				break;

			case 8:
				User user = new User();
				System.out.println("Please Enter the Genre");
				String gen = sc.nextLine();
				user.getUserPreference(gen);
				break;

			default:
				System.out.println("Invalid choice...Please try again!!");
				break;
			}
		} while (choice != 8);
	}
}
