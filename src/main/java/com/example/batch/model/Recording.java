package com.example.batch.model;

import java.util.List;

public class Recording {

    private String title;
    private List<Artist> mainArtists;

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public List<Artist> getMainArtists() { return mainArtists; }

    public void setMainArtists(List<Artist> mainArtists) { this.mainArtists = mainArtists; }
}