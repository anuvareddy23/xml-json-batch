package com.example.batch.processor;

import com.example.batch.model.Artist;
import com.example.batch.model.Recording;
import com.example.batch.model.RecordingXml;
import org.springframework.batch.item.ItemProcessor;

import java.util.Collections;

public class RecordingProcessor implements ItemProcessor<RecordingXml, Recording> {

    @Override
    public Recording process(RecordingXml item) {

        Recording recording = new Recording();

        recording.setTitle(item.getRecordingTitle().toUpperCase());

        Artist artist = new Artist();
        artist.setArtist(item.getArtistName().toUpperCase());

        recording.setMainArtists(Collections.singletonList(artist));

        return recording;
    }
}