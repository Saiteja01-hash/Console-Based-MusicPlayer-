package com; 

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
	
	private List<Song> allsongs= new ArrayList<>();
	private List<Playlist> playlists = new ArrayList<>();
	private int playlistCounter =1;
	private Playlist activePlaylist;
	
	
	public void addSong(Song song) {
		allsongs.add(song);
		
	}
	
	public void updateSong(String title, Song song) {
		boolean found = false;
		
		for(int i=0; i< allsongs.size(); i++) {
			
			if(allsongs.get(i).getTitle().equalsIgnoreCase(title)) {
				allsongs.set(i, song);
				found = true;
				System.out.println("Song details updated sucessfully");
				break;
			}
		}
		if(!found) {
			System.out.println("No song found with that title");
		}
	}
	
	public boolean deleteSong(String songTitle) {
	
		for(int i=0; i< allsongs.size(); i++) {
			
			if(allsongs.get(i).getTitle().equalsIgnoreCase(songTitle)) {
				allsongs.remove(i);	
	
			for(Playlist p:playlists) {
				p.removeSong(songTitle);
				}
			return true;
			
			}	
		}
		return false;	
	}
	
	public void displayAllSongs() {
		for(Song res:allsongs) {
		//	System.out.println("Hi ra kannnaaa");
			System.out.println(res);
		}
		
	}
	
	public boolean createPlaylist(String playlistName) {

		for(Playlist res:playlists) {
			if(res.getPlaylistName().equalsIgnoreCase(playlistName)) {
				return false;
			}	
		}
		Playlist p = new Playlist(playlistCounter, playlistName);
			playlists.add(p);
			playlistCounter++;
		return true;

	}
	
	public Playlist getPlaylist(String playlistName) {
		
		for(Playlist p:playlists) {
			if(p.getPlaylistName().equalsIgnoreCase(playlistName)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean addSongToPlaylist(String playlistName, Song song) {

		 Playlist p = getPlaylist(playlistName);
		 
		 if(p != null) {
			p.addSong(song);
			return true;
			
		 }
		return false;
	}
	
	public boolean playPlaylist(String playlistName) {
		
		for(Playlist p:playlists) {
			if(p.getPlaylistName().equalsIgnoreCase(playlistName)) {
				activePlaylist = p;
				for(Song s:p.getListOfSongs()) {
					String t =s.getTitle();
					p.play(t);
				}
				return true;	
			}	
		}
		return false;
	}
	
	public void displayAllPlaylist() {
		
		for(Playlist  p:playlists) {
			System.out.println(p);
		}
		
	}
	
	public void pauseSong() {
		if(activePlaylist != null) {
			activePlaylist.pause();
		}
	}
	
	public void stopSong() {
		if(activePlaylist != null) {
			activePlaylist.stop();
		}
	}
	
	
	//Extra method
	
	public Song getSongByTitle(String songTitile) {
		
		for(Song s:allsongs) {
			if(s.getTitle().equalsIgnoreCase(songTitile)) {
				return s;
			}
		}
		return null;
	}
	
	public void playSongFromPlaylist(String playlistName, String songTitile) {
		
		for(Playlist p:playlists) {
			if(p.getPlaylistName().equalsIgnoreCase(playlistName)) {
				p.play(songTitile);
				activePlaylist = p;
				p.play(songTitile);
					}
				}
			}
	
	public void activePlaylistSongs() {
	
		for(Song s:activePlaylist.getListOfSongs()) {
			System.out.println(s);
			}
		}
	

	public void setActivePlaylist(Playlist p) {
		this.activePlaylist =p;
	}
}

