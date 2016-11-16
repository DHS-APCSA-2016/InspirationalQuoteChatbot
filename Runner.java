import java.util.Scanner;
public class Runner
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Chatbot chatbot = new Chatbot();
		
		System.out.println (chatbot.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			String response = chatbot.getResponse(statement);
			for(int i = 0; i < response.length(); i++){
				System.out.print(response.substring(i, i+1));
				try {
					Thread.sleep(80);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		
			statement = in.nextLine();
		}
	}

}
