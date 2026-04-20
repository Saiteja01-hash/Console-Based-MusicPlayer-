package com;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MusicPlayer player = new MusicPlayer();
		
		Song s1  = new Song(1, "Na Cheliya padhaalu","Koti",4.34);
		Song s2  = new Song(2, "Chillipiga chusthav ala ", "Karthik", 5.29);
		Song s3  = new Song(3, "Devatha", "Karthik", 3.41);
		Song s4  = new Song(4, "oka maru","Karthik", 3.41);
		Song s5  = new Song(5, "Yevvaro", "Karthik", 3.41);
		Song s6  = new Song(6, "Vintunaava", "Karthik", 3.41);
		Song s7  = new Song(7, "Chitti Nadumune","Mallikarjuna",5.53);
		Song s8  = new Song(8, "Emantaro","SP Charan",6.18);
		Song s9  = new Song(9, "Ye Chillipi","Srinivas",5.15);
		Song s10 = new Song(10,"Nanne Nanne","Tippu",5.54);
		Song s11 = new Song(11,"Yamaha Nagari","hari haran",6.20);
		Song s12 = new Song(12,"Ramma Chillakamma","Udit narayan",4.46);
		Song s13 = new Song(13, "Apna Bana Le","Arjith Singh",4.22);
		Song s14 = new Song(14, "Aaj Se Teri","Arjith Singh",5.12);
		Song s15 = new Song(15, "Channa Mereyaa","Arjith Singh",5.19);
		
		
		player.addSong(s1);
		player.addSong(s2);
		player.addSong(s3);
		player.addSong(s4);
		player.addSong(s5);
		player.addSong(s6);
		player.addSong(s7);
		player.addSong(s8);
		player.addSong(s9);
		player.addSong(s10);
		player.addSong(s11);
		player.addSong(s12);
		player.addSong(s13);
		player.addSong(s14);
		player.addSong(s15);
		
		player.createPlaylist("Telugu Old Songs");
		player.createPlaylist("Telugu Hit Songs");
		player.createPlaylist("Hindi Hit Songs");
		
		
		player.addSongToPlaylist("Telugu Hit Songs", s1);
		player.addSongToPlaylist("Telugu Hit Songs", s2);
		player.addSongToPlaylist("Telugu Melody Songs", s2);
		player.addSongToPlaylist("Telugu Hit Songs", s3);
		player.addSongToPlaylist("Telugu Melody Songs", s4);
		player.addSongToPlaylist("Telugu Old Songs", s5);
		player.addSongToPlaylist("Telugu Melody Songs", s6);
		player.addSongToPlaylist("Telugu Melody Songs", s9);
		player.addSongToPlaylist("Telugu Old Songs", s11);
		player.addSongToPlaylist("Telugu Old Songs", s12);
		player.addSongToPlaylist("Hindi Hit Songs", s13);
		player.addSongToPlaylist("Hindi Hit Songs", s14);
		player.addSongToPlaylist("Hindi Hit Songs", s15);
		
		

		boolean flag = true;
		
		while(flag) {
			System.out.println();

			System.out.println(" ========= MUSIC PLAYER MENU ========= ");
			System.out.println();
			System.out.println("1. Add New Song\n"
					+ "2. Update Existing Song\n"
					+ "3. Delete Song\n"
					+ "4. Display All Songs\n"
					+ "5. Create New Playlist\n"
					+ "6. Add Song to Playlist\n"
					+ "7. Display All Playlists\n"
					+ "8. Display Songs in Playlist\n"
					+ "9. Play Songs in Playlist\n"
					+ "10. Pause Song in Playlist\n"
					+ "11. Stop Song in Playlist\n"
					+ "12. Exit");
			
			System.out.println();
			System.out.println("Enter your choice: ");
			
			if(!sc.hasNextInt()) {
				System.out.println("Try again");
				sc.next();
				continue;
			}
			
			int choice = sc.nextInt();

			switch (choice) {
			
			case 1:
				System.out.println("Enter Song Id :");
				int a= sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Title :");
				String b = sc.nextLine();
				System.out.println("Enter artist :");
				String c = sc.nextLine();
				System.out.println("Enter the duration :");
			    double d =sc.nextDouble();
			    
				player.addSong(new Song (a, b, c, d));
				System.out.println("Song added Sucessfully");
				System.out.println();
				break;
				
			case 2:
				
				sc.nextLine();
				System.out.println("Enter the Song title to update:");
				String oldTitle =sc.nextLine();
				
				System.out.println("Enter Song Id:");
				int newId= sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter the New title:");
				String newTitle = sc.nextLine();
				System.out.println("Enter artist:");
				String newArtist = sc.nextLine();
				System.out.println("Enter the duration:");
			    double newDuration =sc.nextDouble();
			    
				Song s = new Song(newId, newTitle, newArtist, newDuration);
				player.updateSong(oldTitle, s);
				break;
				
			case 3:
				sc.nextLine();
				System.out.println("Enter the Song title to delete");
				String deleSong =sc.nextLine();
				player.deleteSong(deleSong);
				
				break;			
				
			case 4:
				player.displayAllSongs();
				break;
				
			case 5:
				sc.nextLine();
				System.out.println("Enter the Playlist Name to create");
				String Cp =sc.nextLine();
				Boolean created = player.createPlaylist(Cp);
				if(created) {
					System.out.println("Playlist Sucessfully Created...");
				}
				else {
					System.out.println("Playlist name alreaydy exists...");
				}
				break;
				
			case 6:
				sc.nextLine();
				System.out.println("Enter PlaylistName");
				String playlistName =sc.nextLine();
				System.out.println("Enter Song title");
				String songToAdd = sc.nextLine();
				Song t =player.getSongByTitle(songToAdd);
				if(t == null) {
					System.out.println("Song don't exist");
					break;
				}
				boolean tt = player.addSongToPlaylist(playlistName,t);
				if(tt) {
					System.out.println("Song added to Playlist");
				}
				else {
					System.out.println("Playlist not found");
				}
				break;
					
			case 7: 
				player.displayAllPlaylist();
				break;
				
				
			case 8:
				sc.nextLine();
				System.out.println("Enter the Playlist Name");
				String p = sc.nextLine();
				Playlist res= player.getPlaylist(p);
				if(res == null) {
					System.out.println("Playlist don't exist");
				}
				else {
					for(Song songs:res.getListOfSongs()) {
						System.out.println(songs); 
					}
				}
			   break;
			   
			case 9:
				sc.nextLine();
				player.displayAllPlaylist();
				System.out.println();
				System.out.println("Enter Playlist Name to play :");
				String name =sc.nextLine();
				Playlist p1 = player.getPlaylist(name);
				if(p1 == null) {
					System.out.println("Playlist not found enter correct playlistName...");
				}
				player.setActivePlaylist(p1);
				p1.displaySongs();
				System.out.println();
				System.out.println("Select Song title to Play :");
				String ss =sc.nextLine();
				p1.play(ss);
				
				break;
				   
				   
			case 10:
				sc.nextLine();
				player.pauseSong();
				 break;
				   
			case 11:
				sc.nextLine();
				player.stopSong();
				
				break;
				
			case 12:
				System.out.println("Exiting....");
				flag = false;
				break;
				
			}
			
	
		}
		

	}
	

}
