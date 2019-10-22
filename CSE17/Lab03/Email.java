public class Email extends Document{
    private String sender, recipient, subject;

    public Email() {    //empty email
        super();
        sender = "";
        recipient = "";
        subject = "";
    }

    public Email(String senderString, String recipString, String subjecString, String body) {
        super(body);
        sender = senderString;
        recipient = recipString;
        subject = subjecString;
        
    }
    //mutators
    public void setSender(String sendString) {
        sender = sendString;
    }
    public void setRecip(String recipString) {
        recipient = recipString;
    }
    public void setSubject(String subjString) {
        subject = subjString;
    }
    //acessors
    public String getSender() {
        return sender;
    }
    public String getRecip() {
        return recipient;
    }
    public String getSubject() {
        return subject;
    }

    public String toString() {
        return "From: "+sender+"\nTo: "+recipient+"\nSubject: "+subject+"\nbody: "+super.toString(); 
    }
        
}