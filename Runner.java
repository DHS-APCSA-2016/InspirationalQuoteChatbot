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
			System.out.println (chatbot.getResponse(statement));
			statement = in.nextLine();
		}
	}

}
