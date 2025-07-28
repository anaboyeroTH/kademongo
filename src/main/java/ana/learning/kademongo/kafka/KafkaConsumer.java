package ana.learning.kademongo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="greeting", groupId="my-group")
    public void consume(String message){
        log.info(String.format("\n+*** Message received -> %s", message));
        // Soon, I will save it to a database or perform some action based on the message content
    }
}
