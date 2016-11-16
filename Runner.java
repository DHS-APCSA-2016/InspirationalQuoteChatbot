import java.util.Scanner;
public class Runner
{
	
	public static void printStatement(String s){
        	for(int i = 0; i < s.length(); i++){
				System.out.print(s.substring(i, i+1));
				try {
					Thread.sleep(80);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		System.out.println("");
    	}
	
	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Chatbot chatbot = new Chatbot();
		
		printStatement(chatbot.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye") || !statement.equals("Goodbye"))
		{
			String response = chatbot.getResponse(statement);
			printStatement(response);	
		
			statement = in.nextLine();
		}
	}

}
