
public class Main {
    public static void main(String[] args) {
    	String message = "In my opinion, it does not look so good. Are you serious? Talk to you later.";
    	String[] text=message.split("");   	
    	
    	String answer = "";
    	for(int i=0; i<text.length; i++)
    	{
    		answer+=text[i];
    	}
    	System.out.println(answer);
    	
    	int ka=0;
    }
}