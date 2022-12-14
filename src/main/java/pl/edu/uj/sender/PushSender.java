package pl.edu.uj.sender;

public class PushSender implements Sender {

  @Override
  public void send(Message message, Recipient recipient) throws SenderException {
    if((!(message instanceof PushMessage)) || (!(recipient instanceof PushRecipient))){
      throw new SenderException("message albo recipent jest zlej klasy");
    }
    message.validateMessage();
    recipient.validateRecipient();

    String bodyMD5 = message.anonymizeMessageBody();
    String anonymizedRecipientAddress = recipient.anonymize();

    System.out.printf("[Push] Message sent, title= '%s', bodyMD5= '%s', recipient= '%s'%n", message.getMessageTitle(), bodyMD5, anonymizedRecipientAddress);
  }
}
