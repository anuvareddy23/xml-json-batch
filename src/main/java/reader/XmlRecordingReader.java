package com.example.batch.reader;

import com.example.batch.model.RecordingXml;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class XmlRecordingReader {

    @Bean
    public StaxEventItemReader<RecordingXml> reader() {

        StaxEventItemReader<RecordingXml> reader = new StaxEventItemReader<>();
        reader.setResource(new ClassPathResource("input.xml"));
        reader.setFragmentRootElementName("recording");

        Map<String, Class<?>> aliases = new HashMap<>();
        aliases.put("recording", RecordingXml.class);

        XStreamMarshaller marshaller = new XStreamMarshaller();

        marshaller.setAliases(aliases);
        marshaller.setAnnotatedClasses(RecordingXml.class);

        marshaller.getXStream().allowTypes(new Class[]{RecordingXml.class});

        reader.setUnmarshaller(marshaller);

        return reader;
    }
}