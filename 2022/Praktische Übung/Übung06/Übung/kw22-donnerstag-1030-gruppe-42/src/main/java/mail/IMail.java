package mail;

import gelato.Kunde;

public interface IMail {
    public void sendMail(Kunde kunde, Mail mail);
}
