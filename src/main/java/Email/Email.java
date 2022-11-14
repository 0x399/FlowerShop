package Email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class Email {
    private final EmailService emailService;

    public Email(EmailService emailService) {
        this.emailService = emailService;
    }

    public void run() {
        SpringApplication.run(Email.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() throws MessagingException {
        emailService.sendEmailWithAttachment("The program ended with an error or exception!","pryimak.sviat@gmail.com",
                "Flower Shop, logs",
                "C:\\Users\\Приймак Святослав\\IdeaProjects\\FlowerShop\\logs\\taxiLogs\\logs.log");
    }
}