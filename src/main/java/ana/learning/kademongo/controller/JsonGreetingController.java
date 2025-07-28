package ana.learning.kademongo.controller;

import ana.learning.kademongo.domain.greeting.model.Greeting;
import ana.learning.kademongo.kafka.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
public class JsonGreetingController {

    private final JsonKafkaProducer kafkaProducer;

    public JsonGreetingController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Greeting greeting){
        kafkaProducer.sendMessage(greeting);
        return ResponseEntity.ok("Message sent to Greeting topic");
    }
}
