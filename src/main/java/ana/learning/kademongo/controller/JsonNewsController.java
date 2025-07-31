package ana.learning.kademongo.controller;

import ana.learning.kademongo.domain.model.News;
import ana.learning.kademongo.kafka.JsonNewsKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/json-news")
public class JsonNewsController {

    private final JsonNewsKafkaProducer kafkaProducer;

    JsonNewsController(JsonNewsKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody News news) {
        kafkaProducer.sendMessage(news);
        return ResponseEntity.ok(news.toString());
    }
}


