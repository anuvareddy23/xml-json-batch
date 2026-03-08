package com.example.batch.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class RecordingXml {

    @XStreamAlias("RECORDING-TITLE-COLLECTING-SOCIETY")
    private String recordingTitle;

    @XStreamAlias("MAIN-ARTIST-NAME-COLLECTING-SOCIETY")
    private String artistName;

    public String getRecordingTitle() {
        return recordingTitle;
    }

    public void setRecordingTitle(String recordingTitle) {
        this.recordingTitle = recordingTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}