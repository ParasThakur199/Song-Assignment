package com.extrabeat.usecases;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.extrabeat.bean.Artist;
import com.extrabeat.bean.Playlist;
import com.extrabeat.bean.Role;
import com.extrabeat.bean.Song;
import com.extrabeat.bean.User;
import com.extrabeat.custom.ConsoleColors;
import com.extrabeat.service.ArtistDetails;
import com.extrabeat.service.MusicLibrary;
import com.extrabeat.service.PlaylistDetails;
import com.extrabeat.service.SongsDetails;
import com.extrabeat.service.SongsRecommendation;
import com.extrabeat.service.UserService;

public class Usecase {

	private Set<User> arr = new HashSet<>();
	private HashMap<String, Song> songdetails = new HashMap<>();
	private HashMap<String, Artist> artistdetails = new HashMap<>();
	private PlaylistDetails plDetails = new PlaylistDetails();
	private SongsDetails usecases = new SongsDetails();
	private Map<String, Playlist> playlistdetails = new HashMap<>();
	private Scanner sc = new Scanner(System.in);

	public void showHeader() {
		System.out.println(ConsoleColors.GREEN_BOLD +"  +=-=-=-=-=-=-=-=--=-=--+"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BOLD+"-|    MUSIC APPLICATION   |-"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BOLD+"  +=-=-=-=-=-=-=-=--=-=--+"+ConsoleColors.RESET+"\n");
	}
	public void showMenu() {
		System.out.println(ConsoleColors.BLUE + "+-=-=-=-=-=-=-=-=-=-=-=-=-=-=+" + "\n"
				+ "| 1. Signup                  |" + "\n" + "| 2. Login                   |" + "\n"
				+ "| 3. Get all Users & Artists |" + "\n" + "| 4. Exit                    |" + "\n"
				+ "+-=-=-=-=-=-=-=-=-=-=-=-=-=-=+" + ConsoleColors.RESET);
	}

	public void adminOrCustomer() {
		int choice;
		do {
			showHeader();
			showMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println(ConsoleColors.ROSY_PINK + "Welcome !! Please Signup your Account" + ConsoleColors.RESET);
				signUp();
				break;
			case 2:
				System.out.println(ConsoleColors.ROSY_PINK + "Welcome !! Please Signin your Account" + ConsoleColors.RESET);
				logIn();
				break;
			case 3:
				System.out.println(ConsoleColors.ROSY_PINK + "Show All Users & Artists Accounts" + ConsoleColors.RESET);
				getAll();
				break;
			case 4:
				System.out.println(ConsoleColors.ROSY_PINK + "Thank you !! Visit Again" + ConsoleColors.RESET);
				break;
			default:
				System.out.println(ConsoleColors.RED_BACKGROUND + "Please choose a number from below Options !!"+ ConsoleColors.RESET);
			}
		} while (choice != 4);
	}

	private void getAll() {
		UserService uService = new UserService();
		uService.userDetailsInput(arr);
		for (User usr : arr) {
			System.out.println(usr.getUsername() + " " + usr.getRole());
		}
	}

	private void signUp() {
		try {
			User u1 = new User();
			System.out.println("Please Enter Name");
			sc.nextLine();
			u1.setUsername(sc.nextLine());
			System.out.println("Please Enter Email");
			u1.setEmail(sc.nextLine());
			System.out.println("Please Enter Password");
			u1.setPassword(sc.nextLine());
			System.out.println("Please Enter Preferences");
			u1.setPreferences(sc.nextLine());
			System.out.println("Please Enter Role (ADMIN or CUSTOMER)");
			String roleInput = sc.next();
			if (roleInput.equalsIgnoreCase("ADMIN")) {
				u1.setRole(Role.ADMIN);
			} else {
				u1.setRole(Role.CUSTOMER);
			}
			arr.add(u1);

			UserService uService = new UserService();
			uService.userDetailsOutput(arr);
			System.out.println(u1);
		} catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED + "Invalid input format!!" + ConsoleColors.RESET);
		} catch (Exception e) {
			System.out.println(ConsoleColors.RED + "Something went wrong...Please try again!!" + ConsoleColors.RESET);
		}
	}

	private void logIn() {
		try {
			System.out.println("Please Enter Email");
			sc.nextLine();
			String email = sc.nextLine();
			System.out.println("Please Enter Password");
			String password = sc.nextLine();
			boolean loginDone = arr.stream()
					.anyMatch(e -> e.getEmail().equals(email) && e.getPassword().equals(password));
			if (loginDone) {
				System.out.println(
						ConsoleColors.GREEN_BACKGROUND_BRIGHT + "Congrats..Login Successfully!!" + ConsoleColors.RESET);
				User loggedUser = arr.stream()
						.filter(e -> e.getEmail().equals(email) && e.getPassword().equals(password)).findFirst()
						.orElse(null);

				if (loggedUser != null) {
					if (loggedUser.getRole() == Role.ADMIN) {
						System.out.println(ConsoleColors.ROSY_PINK + "You are an admin..." + ConsoleColors.RESET);
						adminCases();
					} else {
						System.out.println(ConsoleColors.ROSY_PINK + "You are a customer..." + ConsoleColors.RESET);
						customerCases();
					}
				} else {
					System.out.println(ConsoleColors.RED + "User not found." + ConsoleColors.RESET);
				}
			} else {
				System.out.println(ConsoleColors.RED_BACKGROUND + "Login failed...Please check your credentials!!"+ ConsoleColors.RESET);
			}
		} catch (Exception e) {
			System.out.println(ConsoleColors.RED + "Something went wrong...Please try again!!" + ConsoleColors.RESET);
		}
	}

	public void customerCases() {
		int choice2;
		do {
			System.out.println(ConsoleColors.PURPLE_BOLD + "=-=-=-=-=-=-=-=-=-=-=-=-=--=-=" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "1. Show all Songs" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "2. Get Specific Song" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "3. Show All Artists" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "4. Get Specific Artist Details" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "5. Create Playlist" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "6. Remove Song by Name" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "7. Show Entire Playlist" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "8. Top Songs by Rating" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "9. Check by Genre" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "10. Back" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "11. Exit" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "=-=-=-=-=-=-=-=-=-=-=-=-=--=-=" + ConsoleColors.RESET);
			System.out.println("Enter your choice : ");
			choice2 = sc.nextInt();
			sc.nextLine();

			switch (choice2) {
			case 1:
				usecases.songsDetailsInput(songdetails);
				for (Song el : songdetails.values()) {
					System.out.println("\nSong Title : " + el.getSongTitle());
					System.out.println("Song Artist : " + el.getArtist());
					System.out.println("Duration : " + el.getDuration());
					System.out.println("Genre : " + el.getGenre());
					System.out.println("Rating : " + el.getRating() + "\n");
				}
				break;
			case 2:
				try {
					System.out.println("Please Enter Song Name :");
					String name = sc.nextLine();
					boolean songExist = songdetails.entrySet().stream()
							.anyMatch(e -> e.getValue().getSongTitle().equalsIgnoreCase(name));
					if (songExist) {
						for (Song el : songdetails.values()) {
							if (el.getSongTitle().equalsIgnoreCase(name)) {
								System.out.println("\nTitle : " + el.getSongTitle());
								System.out.println("Artist : " + el.getArtist());
								System.out.println("Duration : " + el.getDuration());
								System.out.println("Genre : " + el.getGenre());
								System.out.println("Rating : " + el.getRating() + "\n");
							}
						}
					} else {
						System.out.println("\nSong not found.\n");
					}
				} catch (InputMismatchException e) {
					System.out.println(ConsoleColors.RED + "Invalid input...Please enter valid Song Name!!" + ConsoleColors.RESET);
				} catch (Exception e) {
					System.out.println(ConsoleColors.RED + "Something went wrong...Please try again!!" + ConsoleColors.RESET);
				}
				break;
			case 3:
				ArtistDetails ArtistDetail = new ArtistDetails();
				ArtistDetail.artistDetailsInput(artistdetails);
				for (Artist el : artistdetails.values()) {
					System.out.println("\nArtist Name : " + el.getArtistName());
					System.out.println("Artist : " + el.getArtistGenre());
					System.out.println("Rating : " + el.getPopularSongs() + "\n");
				}
				break;
			case 4:
				try {
					System.out.println("Please Enter Artist name");
					String artistName = sc.nextLine();
					ArtistDetails ArtistDetails = new ArtistDetails();
					ArtistDetails.artistDetailsInput(artistdetails);
					boolean artistExist = artistdetails.entrySet().stream()
							.anyMatch(e -> e.getValue().getArtistName().equalsIgnoreCase(artistName));
					if (artistExist) {
						for (Artist el : artistdetails.values()) {
							if (el.getArtistName().equalsIgnoreCase(artistName)) {
								System.out.println("\nArtist Name :" + el.getArtistName());
								System.out.println("Artist Genre :" + el.getArtistGenre());
								System.out.println("Popular Songs :" + el.getPopularSongs() + "\n");
							}
						}
					} else {
						System.out.println(ConsoleColors.RED + "\nArtist not found.\n" + ConsoleColors.RESET);
					}
				} catch (InputMismatchException e) {
					System.out.println(ConsoleColors.RED + "Invalid input...Please enter valid Artist Name!!"+ ConsoleColors.RESET);
				} catch (Exception e) {
					System.out.println(ConsoleColors.RED + "Something went wrong...Please try again!!" + ConsoleColors.RESET);
				}
				break;

			case 5:
				try {
					System.out.println("Please Enter Song Name");
					String SongName = sc.nextLine();
					System.out.println("Please Enter Artist Name");
					String ArtistName = sc.nextLine();
					Playlist playlist = new Playlist(SongName, ArtistName);
					playlistdetails.put(SongName, playlist);
					plDetails.playlistDetailsOutput(playlistdetails);
					System.out.println("Playlist created: " + playlist);
				} catch (Exception e) {
					System.out.println(ConsoleColors.RED + "Something went wrong...Please try again!!" + ConsoleColors.RESET);
				}
				break;

			case 6:
				try {
					System.out.println("Enter Song Name that you wanna delete");
					String songNameToDelete = sc.nextLine();

					if (playlistdetails.containsKey(songNameToDelete)) {
						playlistdetails.remove(songNameToDelete);
						plDetails.playlistDetailsOutput(playlistdetails);
						System.out.println("Song deleted Successfully");
					} else {
						System.out.println("Song not found in the playlist.");
					}
				} catch (Exception e) {
					System.out.println(ConsoleColors.RED + "Something went wrong...Please try again!!" + ConsoleColors.RESET);
				}
				break;

			case 7:
				for (Playlist v : playlistdetails.values()) {
					System.out.println("\nSong-Name: " + v.getsongName() + "     Artist-Name: " + v.getArtistName());
				}
				System.out.println();
				break;

			case 8:
				SongsRecommendation sr = new SongsRecommendation();
				sr.songRecommendByRating(songdetails);
				break;

			case 9:
				try {
					MusicLibrary music = new MusicLibrary();
					System.out.println("Enter the Genre");
					String genre = sc.nextLine();
					music.musicLibrary(genre, songdetails);
				} catch (InputMismatchException e) {
					System.out.println(ConsoleColors.RED + "Invalid input...Please enter valid Genre!!" + ConsoleColors.RESET);
				} catch (Exception e) {
					System.out.println(ConsoleColors.RED + "Something went wrong...Please try again!!" + ConsoleColors.RESET);
				}
				break;

			case 10:
				Usecase main = new Usecase();
				main.adminOrCustomer();
				break;

			case 11:
				System.exit(0);

			default:
				System.out.println(ConsoleColors.RED + "Invalid choice...Please try again!!" + ConsoleColors.RESET);
				break;
			}
		} while (choice2 != 10);
	}

	public void adminCases() {
		int choice1;
		do {
			System.out.println(ConsoleColors.PURPLE_BOLD + "1. Add Songs" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "2. Add Artist" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "3. Back" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.PURPLE_BOLD + "Enter Choice" + ConsoleColors.RESET);
			choice1 = sc.nextInt();
			sc.nextLine();
			switch (choice1) {
			case 1:
				try {
					Song s1 = new Song();
					System.out.println("Please Enter Song Title");
					s1.setSongTitle(sc.nextLine());
					System.out.println("Please Enter Song Artist");
					s1.setArtist(sc.nextLine());
					System.out.println("Please Enter duration");
					s1.setDuration(sc.nextInt());
					sc.nextLine();
					System.out.println("Please Enter genre");
					s1.setGenre(sc.nextLine());
					System.out.println("Please Enter rating");
					s1.setRating(sc.nextDouble());

					songdetails.put(s1.getSongTitle(), s1);
					SongsDetails songRecord = new SongsDetails();
					songRecord.songsDetailsOutput(songdetails);
					System.out.println(ConsoleColors.GREEN_BOLD + "Record Added Successfully : " + s1 + ConsoleColors.RESET);
				} catch (InputMismatchException e) {
					System.out.println(ConsoleColors.RED + "Invalid input format!!" + ConsoleColors.RESET);
				} catch (Exception e) {
					System.out.println(ConsoleColors.RED + "Something went wrong...Please try again!!" + ConsoleColors.RESET);
				}
				break;

			case 2:
				try {
					System.out.println("Please Enter Artist Name");
					String name = sc.nextLine();
					System.out.println("Please Enter Artist Genre");
					String genre = sc.nextLine();
					System.out.println("Please Enter Popular Song");
					String popularSongs = sc.nextLine();
					Artist artist = new Artist(name, genre, popularSongs);
					artistdetails.put(name, artist);
					ArtistDetails artistDetail = new ArtistDetails();
					artistDetail.artistDetailsOutput(artistdetails);
					System.out.println(ConsoleColors.GREEN_BOLD + "Artist added successfully: " + artist + ConsoleColors.RESET);
				} catch (InputMismatchException e) {
					System.out.println(ConsoleColors.RED + "Invalid input format!!" + ConsoleColors.RESET);
				} catch (Exception e) {
					System.out.println(ConsoleColors.RED + "Something went wrong...Please try again!!" + ConsoleColors.RESET);
				}
				break;

			case 3:
				Usecase main = new Usecase();
				main.adminOrCustomer();
				break;

			default:
				System.out.println(ConsoleColors.RED + "Invalid choice...Please try again!!" + ConsoleColors.RESET);
				break;
			}
		} while (choice1 != 3);
	}

	
}
