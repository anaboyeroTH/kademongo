package ana.learning.kademongo.repository;

import ana.learning.kademongo.domain.model.Telegram;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;

public interface TelegramRepository extends MongoRepository<Telegram, String> {

    public Telegram findByHeadline(String headline);
    public Telegram findByContent(String content);
    public Telegram findByAuthor(String author);
    public Telegram findByDate(LocalDate date);
    public Telegram findByMedia(String media);
}
