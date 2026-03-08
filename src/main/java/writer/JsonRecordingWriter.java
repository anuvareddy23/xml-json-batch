package com.example.batch.writer;

import com.example.batch.model.Recording;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import java.io.File;

public class JsonRecordingWriter implements ItemWriter<Recording> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void write(Chunk<? extends Recording> items) throws Exception {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("output.json"), items.getItems());
    }
}