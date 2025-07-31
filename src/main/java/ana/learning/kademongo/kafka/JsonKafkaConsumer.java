package ana.learning.kademongo.kafka;

import ana.learning.kademongo.domain.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics="greetingJson", groupId="my-group")
    public void consume(Greeting greeting){
        log.info(String.format("\n+*** Message received -> %s", greeting.toString()));
        // Soon, I will save it to a database or perform some action based on the message content
    }

}
