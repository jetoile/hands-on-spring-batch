package handson.springbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelloWorldWriter implements ItemWriter<String> {
    Logger logger = LoggerFactory.getLogger(HelloWorldWriter.class);

    @Override
    public void write(List<? extends String> items) throws Exception {
        // TODO : afficher les items via slf4j

        for (String item : items) {
            logger.warn(item);
        }
//		throw new RuntimeException("TODO: not yet implemented");
    }

}
