package ana.learning.kademongo.controller;

import ana.learning.kademongo.domain.greeting.model.Greeting;
import ana.learning.kademongo.kafka.JsonKafkaProducer;
import ana.learning.kademongo.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingController {

    private final JsonKafkaProducer kafkaProducer;

    public GreetingController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> 
}
