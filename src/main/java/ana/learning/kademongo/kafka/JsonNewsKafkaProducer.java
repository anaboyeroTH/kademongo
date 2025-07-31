package ana.learning.kademongo.kafka;

import ana.learning.kademongo.domain.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonNewsKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(JsonNewsKafkaProducer.class);

    private final KafkaTemplate<String, News> kafkaTemplate;

    public JsonNewsKafkaProducer (KafkaTemplate<String, News> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(News news){
        log.info(String.format("\n*** Message sent to Kafka -> %s", news.toString()));

        Message<News> message = MessageBuilder
                .withPayload(news)
                .setHeader(KafkaHeaders.TOPIC, "newsJson")
                .build();

        kafkaTemplate.send(message);
    }
}
