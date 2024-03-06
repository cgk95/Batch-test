package me.cgk95.batch_jenkins_test.sample.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
@Slf4j
@Configuration
@ConditionalOnProperty(name = "job.name", havingValue = SampleBatchConfiguration2.JOB_NAME)
@RequiredArgsConstructor
public class SampleBatchConfiguration2 extends DefaultBatchConfiguration {
    public static final String JOB_NAME = "sampleBatch22";

    @Bean
    public Job job(JobRepository jobRepository, Step step01) {

        return new JobBuilder(JOB_NAME, jobRepository)
                .start(step01)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step step01(JobRepository jobRepository, PlatformTransactionManager transactionManager) {

        return new StepBuilder("sampleStep", jobRepository)
                .tasklet(((contribution, chunkContext) -> {
                    log.info("샘플 배치222입니다!");
                    return RepeatStatus.FINISHED;
                }), transactionManager)
                .build();
    }
}
