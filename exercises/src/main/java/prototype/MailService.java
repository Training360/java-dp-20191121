package prototype;

import java.util.Arrays;
import java.util.List;

public class MailService {

    private MailSender mailSender;

    public MailService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    private Mail mailTemplate =
        new Mail(Arrays.asList(new Address("Mindenki", "all@training360.com")),
                new Address("Training360", "info@training360.com"),
                "Körlevél", new MailContent("text/plain",
                "Kedves Mindenki!\nVárunk mindenkit a havi megbeszélésre! Training360"));

    public void send(Address to) {
        Mail mail = new Mail(mailTemplate);
        mail.setTo(Arrays.asList(to));
        mailSender.send(mail);
    }

    public void send(Address to, String mimeType, String content) {
        Mail mail = new Mail(mailTemplate);
        mail.setTo(List.of(to));
        mail.setMailContent(new MailContent(mimeType, content));
        mailSender.send(mail);
    }


}
