package ana.learning.kademongo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NewsConsumer {

    private static final Logger log = LoggerFactory.getLogger(NewsConsumer.class);

    @KafkaListener(topics="news", groupId="my-group")
    public void consume(String message) {
        log.info(String.format("Message received -> %s", message));
    }
}
