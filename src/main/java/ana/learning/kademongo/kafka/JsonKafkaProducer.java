package ana.learning.kademongo.kafka;

import ana.learning.kademongo.domain.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private final KafkaTemplate <String, Greeting> kafkaTemplate;

    JsonKafkaProducer(KafkaTemplate <String, Greeting> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Greeting greeting){

        log.info(String.format("\n+***Message sent -> %s", greeting.toString()));

        Message<Greeting> message = MessageBuilder
                .withPayload(greeting)
                .setHeader(KafkaHeaders.TOPIC, "greetingJson")
                .build();

        kafkaTemplate.send(message);

    }

}
