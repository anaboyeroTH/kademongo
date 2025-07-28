package ana.learning.kademongo.controller;

import ana.learning.kademongo.kafka.NewsKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

    private final NewsKafkaProducer kafkaProducer;
    private static final Logger log = LoggerFactory.getLogger(NewsController.class);

    NewsController(NewsKafkaProducer kafkaProducer){
     this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        log.info(String.format("\n*** Message sent to News Topic -> %s", message));
        return ResponseEntity.ok("Message sent to News topic");
    }
}
