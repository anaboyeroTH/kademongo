package ana.learning.kademongo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NewsKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(NewsKafkaProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    NewsKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("news", message);
        log.info(String.format("Message sent -> %s", message));
    }
}
