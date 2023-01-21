package gelato.marketing;

import gelato.external.Kalender;
import gelato.mailversand.Mail;
import gelato.wetter.Wetter;
import gelato.wetter.WetterDienst;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MarketingCoreTest {

@Test
@DisplayName("Bei gemäßigtem Wetter an einem Samstag wird Zuppa Inglese angeboten")
void test_1(){
  // Arrange
  WetterDienst w = () -> new Wetter(20,3);
  Kalender k = mock(Kalender.class);
  when(k.now()).thenReturn(LocalDateTime.of(2021,6,5,12,30));
  MarketingCore marketingCore = new MarketingCore(w,k);

  // Act
  Mail mail = marketingCore.createMail("Hugo");

  // Assert
  assertThat(mail.getSubject()).isEqualTo("Tante Irma hat Zuppa Inglese gemacht");
  assertThat(mail.getBody()).contains("dieses Wochenende hat Tante Irma ihre berühmte Zuppa Inglese gemacht");
  assertThat(mail.getBody()).contains("Hallo Hugo,");
}



}
