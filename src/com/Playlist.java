package com;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements Playable{
	
	private int playlistId;
	private String playlistName;
	private List<Song> listOfSongs = new ArrayList<>();
	private Song currentSong;
	
	public Playlist(int playlistId, String playlistName) {
		this.playlistId = playlistId;
		this.playlistName = playlistName;
	}
	
	public List<Song> getListOfSongs(){
		return listOfSongs;
	}
	
	public void addSong(Song song) {
		listOfSongs.add(song);
	//	System.out.println("Song added to Playlist");
	}
	
	public void removeSong(String title) {
		
		boolean found = false;
		
		 for(int i=0; i< listOfSongs.size(); i++) {
			 if(listOfSongs.get(i).getTitle().equalsIgnoreCase(title)) {
				 listOfSongs.remove(i);
				 found = true;
			System.out.println("Song removed sucessfully");
			break;
			 }
		 }
		 if(!found) {
				System.out.println("Song not found in list....");
			}
	}
		
	public void removeSong (int songId) {
		
		boolean found = false;
		
		for(int i=0;i< listOfSongs.size();i++) {
			if(listOfSongs.get(i).getSongId() == songId) {
				listOfSongs.remove(i);
				found = true;
				System.out.println("Song removed sucessfully");
				break;
			}
		}
		 if(!found) {
				System.out.println("Song not found in list....");
			}
	}
	
	public void displaySongs() {
		
		for(Song res: listOfSongs) {
			System.out.println(res);
		}
		
	}
	
	//Polymorphism

	@Override
	public void play(int songId) {
		
		boolean found = false;
	
		for(Song song:listOfSongs) {
			
			if(song.getSongId() == songId) {
				currentSong = song;
				System.out.println("Playing song :"+ song.getTitle());
				found = true;
				break;
			}
		}
		 if(!found) {
			System.out.println("Song not found");
		}
	}

	@Override
	public void play(String title) {
		
		boolean found = false;
		
		for(Song s:listOfSongs) {

			if(s.getTitle().equalsIgnoreCase(title)) {
				currentSong = s;
				System.out.println("Playing song: "+s.getTitle()); 
				found = true;
				break;
			}	
		}
		if(!found){
			System.out.println("Song not found....");
		}	
	}

	@Override
	public void pause() {
		
		if(currentSong != null) {
			System.out.println("Song paused :" + currentSong.getTitle());
		}
		else {
			System.out.println("No Song is playing....");
		}	
		
	}

	@Override
	public void stop() {

		if(currentSong != null) {
			System.out.println("Song Stopped :"+ currentSong.getTitle());
			currentSong = null;
		}
		else {
			System.out.println("Currently there is no active Song....");
		}
			
		}
	
	public int getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	
	@Override
	public String toString() {
		return "Playlist [PlaylistId=" + playlistId + ", playlistName=" + playlistName + "]";
	}
	
	
	

}
