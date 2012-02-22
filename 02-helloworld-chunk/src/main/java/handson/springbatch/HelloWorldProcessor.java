package handson.springbatch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class HelloWorldProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {

        if (StringUtils.countOccurrencesOf(item, "o") != 0) {
            return null;
        } else {
            return "hello " + item;
        }
//		// TODO : filtrer les items contenant un 'o'
//
//		// TODO : returner 'hello ' + item
//
//		throw new RuntimeException("TODO: not yet implemented");
	}

}
