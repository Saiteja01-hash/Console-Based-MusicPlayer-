package com;

public class Song {
	
	private int songId;
	private String title;
	private String artist;
	private double duration;
	
	public int getSongId() {
		return songId;
	}
	
	public void setSongId(int songId) {
		this.songId=songId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public void setDuratoin(double duration) {
		this.duration = duration;
	}
	
	public Song() {
		
	}
	
	public Song(int songId, String titile, String artist, double duaration) {
		
		this.songId = songId;
		this.title = titile;
		this.artist = artist;
		this.duration = duaration;
	}
	
	
	@Override
	public String toString() {
		return "Song [songId=" + songId + ", title=" + title + ", artist=" + artist + ", duration=" + duration + "]";
	}
	
	
	
}



