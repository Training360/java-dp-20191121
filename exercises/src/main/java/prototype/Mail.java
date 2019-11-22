package prototype;

import java.util.ArrayList;
import java.util.List;

public class Mail {

    private List<Address> to;

    private Address from;

    private String subject;

    private MailContent mailContent;

    public Mail(List<Address> to, Address from, String subject, MailContent mailContent) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.mailContent = mailContent;
    }

    public Mail(Mail mailTemplate) {
        this.to = new ArrayList<>(mailTemplate.to);
        this.from = mailTemplate.from;
        this.subject = mailTemplate.subject;
        this.mailContent = new MailContent(mailTemplate.mailContent);
    }

    public List<Address> getTo() {
        return to;
    }

    public void setTo(List<Address> to) {
        this.to = to;
    }

    public Address getFrom() {
        return from;
    }

    public void setFrom(Address from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MailContent getMailContent() {
        return mailContent;
    }

    public void setMailContent(MailContent mailContent) {
        this.mailContent = mailContent;
    }
}
