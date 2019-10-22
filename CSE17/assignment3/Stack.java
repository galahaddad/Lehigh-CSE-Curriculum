/**
 * Stack Program - CSE 17 - Professor Houria
 * Ralph Haddad
 */
public class Stack {
    private String [] elements;
    private int size, capacity;
    public Stack() {
        this.capacity=20;
        elements = new String[20];
        for(int i=0; i<elements.length; i++) {
            elements[i] = "";
        }
    }

    public Stack(int cap) {
        elements = new String [cap];
        this.capacity=cap;
        for(int i=0; i<elements.length; i++) {
            elements[i]="";
        }
    }
    public boolean empty() {
        if(elements[0].isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public String peek(){
        int i;
        if(elements[0].isEmpty()){
            return "Bruh, string's empty yo.";
        } else {
            for(i=elements.length-1; i>=0;i--){
                if(!elements[i].isEmpty()){
                    break;
                }
            }
        }
        return "Last request: " + elements[i]; 
    }

    public void push(String pushString) {
        for(int i=0; i<elements.length; i++) {
            if(elements[i].isEmpty()){
                elements[i]=pushString;
                break;
            }
        }
    }

    public String pop() {
        if (elements[0].isEmpty()) {
            return "No requests in the stack bruv";
        } else {
            for(int i = 1; i<elements.length; i++) {
                if (elements[i].length()==0) {
                    elements[i-1] = "";
                    break;
                }
            }
            return "Request removed sucessfully.";
        }
    }

    public int getSize() {
        int tick=0;
        for (int i=0; i<elements.length; i++) {
            if(!elements[i].isEmpty()){
                tick++;
            } else {
                break;
            }
        }
        return tick;
    }
}