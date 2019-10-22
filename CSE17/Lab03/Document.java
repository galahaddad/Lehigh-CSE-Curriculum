public class Document {
    private String text;    //takes in any textual content for the document
    public Document() {
        text = "";  //initiailizes text as an empty string
    }
    public Document(String textString) {
        text = textString;  //records text information
    }

    public String toString() {
        return text;    //returns value of text
    }
      
}