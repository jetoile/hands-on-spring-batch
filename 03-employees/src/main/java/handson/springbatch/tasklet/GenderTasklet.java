package handson.springbatch.tasklet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class GenderTasklet implements Tasklet {
	Logger logger = LoggerFactory.getLogger(GenderTasklet.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

        int  nbM = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM EMPLOYEES WHERE gender = 'M'");
        int nbF = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM EMPLOYEES WHERE gender = 'F'");
        logger.warn("nb M {}", nbM);
        logger.warn("nb F {}", nbF);

        chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put("MALE", nbM);
        chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put("FEMALE", nbF);

		// TODO : afficher le nombre d’employée masculins et féminins à l'aide Slf4j
		return RepeatStatus.FINISHED;
	}

}
