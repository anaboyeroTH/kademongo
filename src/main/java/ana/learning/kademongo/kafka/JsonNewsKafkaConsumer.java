package ana.learning.kademongo.kafka;

import ana.learning.kademongo.domain.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonNewsKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(JsonNewsKafkaConsumer.class);

    @KafkaListener(topics="newsJson", groupId="my-group")
    public void consume(News news){
//        log.info(String.format("\n*** Message consumed -> %s", news.toString()));
        log.info(String.format("\n*** EXTRA, EXTRA! -> %s", news.toString()));



    }

}
