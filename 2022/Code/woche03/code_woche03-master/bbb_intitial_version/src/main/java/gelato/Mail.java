package gelato;

public class Mail {
    private final String subject;
    private final String body;

    public Mail(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }



    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
