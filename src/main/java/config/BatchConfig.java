package com.example.batch.config;

import com.example.batch.model.Recording;
import com.example.batch.model.RecordingXml;
import com.example.batch.processor.RecordingProcessor;
import com.example.batch.writer.JsonRecordingWriter;
import com.example.batch.reader.XmlRecordingReader;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;

import org.springframework.batch.item.xml.StaxEventItemReader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public Step step(JobRepository jobRepository,
                     PlatformTransactionManager transactionManager) {

        return new StepBuilder("xml-to-json-step", jobRepository)
                .<RecordingXml, Recording>chunk(10, transactionManager)
                .reader(new XmlRecordingReader().reader())
                .processor(new RecordingProcessor())
                .writer(new JsonRecordingWriter())
                .build();
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step) {

        return new JobBuilder("xml-to-json-job", jobRepository)
                .start(step)
                .build();
    }
}