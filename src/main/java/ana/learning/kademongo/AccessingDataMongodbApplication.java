package ana.learning.kademongo;

import ana.learning.kademongo.domain.model.Telegram;
import ana.learning.kademongo.repository.TelegramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

    @Autowired
    private TelegramRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        LocalDate titanicSinkingDate = LocalDate.of(1912, 4, 15);
        repository.save(new Telegram("Se hunde el Titanic", titanicSinkingDate));
        LocalDate WWIIEnd = LocalDate.of(1945, 9, 2);
        repository.save(new Telegram("World War II ends", WWIIEnd));
        repository.save(new Telegram("FINALLY! World War II ends", WWIIEnd));


        // fetch all customers
        System.out.println("Telegrams found with findAll():");
        System.out.println("-------------------------------");
        for (Telegram telegram : repository.findAll()) {
            System.out.println(telegram);
        }
        System.out.println();

        // fetch an individual telegram
        System.out.println("Telegram found with findByDate():");
        System.out.println("--------------------------------");
        System.out.println(repository.findByDate(titanicSinkingDate).toString());
        System.out.println(repository.findByHeadline("World War II ends").toString());
    }
}
