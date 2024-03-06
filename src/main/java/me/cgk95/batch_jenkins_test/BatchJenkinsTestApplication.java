package me.cgk95.batch_jenkins_test;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.CommandLineJobRunner;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobLauncherApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableBatchProcessing
@SpringBootApplication
public class BatchJenkinsTestApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BatchJenkinsTestApplication.class, args);
    }

    @Bean
    public JobLauncherApplicationRunner jobLauncherApplicationRunner(JobLauncher jobLauncher, JobExplorer jobExplorer, JobRepository jobRepository){
        return new JobLauncherApplicationRunner(jobLauncher,jobExplorer,  jobRepository);
    }

}
