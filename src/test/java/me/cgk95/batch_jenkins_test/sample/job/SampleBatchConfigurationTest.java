package me.cgk95.batch_jenkins_test.sample.job;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@Disabled
@SpringBatchTest
@SpringBootTest
@TestPropertySource(properties = "job.name=sampleBatch")
@TestPropertySource(locations = "classpath:application.yml")
class SampleBatchConfigurationTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void 샘플_배치() throws Exception {
        //given
        JobParametersBuilder builder = new JobParametersBuilder();
        builder.addString("version", LocalDateTime.now().toString());

        //when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(builder.toJobParameters());

        //then
        assertThat(jobExecution.getStatus()).isEqualTo(BatchStatus.COMPLETED);

    }
}