import java.util.ArrayList;
public class Chatbot
{
    /**
     * Get a default greeting   
     * @return a greeting
     */ 
    public String getGreeting()
    {
        return "Hello, let's talk and share our feelings.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        ArrayList<String[]> in = new ArrayList<String[]>();
        ArrayList<String> out = new ArrayList<String>();
        // Lines 27 - 80 hold the arraylists used with transposition to create the 25 context based responses. (2A)
        // transposition using array lists 
        in.add(new String[] {"depressed", "sad", "try", "tried"});
        out.add("Try being a rainbow in someone’s cloud.");
        in.add(new String[] {"impossible"});
        out.add("Nothing is impossible, the word itself says 'I'm possible'!");
        in.add(new String[] {"think"});
        out.add("What we think, we become.");
        in.add(new String[] {"opportunity", "opportunities"});
        out.add("If opportunity doesn’t knock, build a door.");
        in.add(new String[] {"success", "succeed", "successful"});
        out.add("Put your heart, mind, and soul into even your smallest acts. This is the secret of success.");
        in.add(new String[] {"Who are you", "Who am I"});
        out.add("We know what we are, but know not what we may be. The measure of who we are is what we do with what we have.");
        in.add(new String[] {"going"});
        out.add("Believe you can and you’re halfway there.");
        in.add(new String[] {"weather"});
        out.add("Clouds come floating into my life, no longer to carry rain or usher storm, but to add color to my sunset sky.");
        in.add(new String[] {"story", "stories"});
        out.add("Every story I create, creates me. I write to create myself.");
        in.add(new String[] {"believe"});
        out.add("I believe in pink. I believe that laughing is the best calorie burner. I believe in kissing, kissing a lot. I believe in being strong when everything seems to be going wrong. I believe that happy girls are the prettiest girls. I believe that tomorrow is another day and I believe in miracles. ");
        in.add(new String[] {"help"});
        out.add("We can't help everyone, but anyone can help someone.");
        in.add(new String[] {"change"});
        out.add("Let us remember: One book, one pen, one child, and one teacher can change the world.");
        in.add(new String[] {"life"});
        out.add("Let your life lightly dance on the edges of Time like dew on the tip of a leaf.");
        in.add(new String[] {"lose", "lost", "loser"});
        out.add("I don't like losers.");
        in.add(new String[] {"hard", "difficult"});
        out.add("Out of difficulties grow miracles.");
        in.add(new String[] {"decision", "choice", "decide", "chosen", "decided"});
        out.add("It is in your moments of decision that your destiny is shaped.");
        in.add(new String[] {"tomorrow"});
        out.add("Tomorrow is the most important thing in life. Comes into us at midnight very clean. It's perfect when it arrives and it puts itself in our hands. It hopes we've learned something from yesterday. Let us dream of tomorrow where we can truly love from the soul, and know love as the ultimate truth at the heart of all creation.");
        in.add(new String[] {"today", "now"});
        out.add("Today is the only day. Yesterday is gone.");
        in.add(new String[] {"journey", "trip"});
        out.add("The only journey is the one within.");
        in.add(new String[] {"imagine", "imagination", "dream"});
        out.add("The power of imagination makes us infinite.");
        in.add(new String[] {"dark", "darkness", "black", "shadows"});
        out.add("Once I knew only darkness and stillness... my life was without past or future... but a little word from the fingers of another fell into my hand that clutched at emptiness, and my heart leaped to the rapture of living.");
        in.add(new String[] {"cry", "crying", "cried"});
        out.add("Tears are often the telescope by which men see far into heaven.");
        in.add(new String[] {"stress", "stressed", "stressing"});
        out.add("Try to be like the turtle - at ease in your own shell.");
        in.add(new String[] {"Donald Trump", "Trump", "Hillary Clinton", "Clinton"});
        out.add("Do you mind if I sit back a little? Because your breath is very bad.");
        in.add(new String[] {"relationship"});
        out.add("I have a great relationship with the Mexican people.");
        in.add(new String[] {"confused"});
        out.add("Life is really simple, but we insist on making it complicated.");
        in.add(new String[] {"money", "wealth", "riches", "rich"});
        out.add("Wisdom outweighs any wealth.");
        
        boolean changed = false;
        for(int i = 0; i < in.size(); i++){
            for(int j = 0; j < in.get(i).length; j++){
                if(findKeyword(statement, in.get(i)[j]) != -1 && changed == false){
                    response = out.get(i);
                    changed = true;
                }
            }
        }
        
        if (changed == false){
        if (statement.length() == 0) // response if nothing is inputted (4Ai)
        {
            response = "Say something, please.";
        }

        else if (findKeyword(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findKeyword(statement, "mother") >= 0
                || findKeyword(statement, "father") >= 0
                || findKeyword(statement, "sistmoer") >= 0
                || findKeyword(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        }

        // Responses which require transformations
        else if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        }
        else if (findKeyword(statement, "I want", 0) >= 0)
        {
            response = transformIWantStatement(statement);
        }
        else if (findKeyword(statement, "I can't", 0) >= 0)
        {
            response = transformICantStatement(statement);
        }
        else if (findKeyword(statement, "How do I get to", 0) >= 0)
        {
            response = transformGetToStatement(statement);
        )
        else if (findKeyword(statement, "Can I", 0) >= 0)
        {
            int psn = findKeyword(statement, "Can I", 0);

            if (psn >= 0
                    && findKeyword(statement, "my", psn) >= 0)
            {
                response = transformCanIMyStatement(statement);
            }
            else
            {
                response = getRandomResponse();
            }
        }
        else if (findKeyword(statement, "I", 0) >= 0)
        {
            int psn = findKeyword(statement, "I", 0);

            if (psn >= 0
                    && findKeyword(statement, "you", psn) >= 0)
            {
                response = transformIYouStatement(statement);
            }
            else
            {
                response = getRandomResponse();
            }
        }
        else
        {
            // Look for a two word (you <something> me)
            // pattern
            int psn = findKeyword(statement, "you", 0);

            if (psn >= 0
                    && findKeyword(statement, "me", psn) >= 0)
            {
                response = transformYouMeStatement(statement);
            }
            else
            {
                response = getRandomResponse();
            }
        }
        }
       
        return response;
    }
    
    
    private String transformGetToStatement(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() -1);
        if (lastChar.equals(".") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "How do I get to", 0);
        String restOfStatement = statement.substring(psn + 15).trim();
        return "All you need is the plan, the roadmap, and the courage to press on to " + restOfStatement + ".";
        
    }
        /**
     * Take a statement with "I can't<something>." and transform it into 
     * "You must do the things you cannot do. You can <something>?"
     * @param statement the user statement, assumed to contain "I can't"
     * @return the transformed statement
     */
    private String transformICantStatement(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement.length() -1);
        }
        int psn = findKeyword (statement, "I can't", 0);
        String restOfStatement = statement.substring(psn + 7).trim();
        return "You must do the things you cannot do. You can " + restOfStatement + ".";
    }
    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
     // (4Aiii)
    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 7).trim();
        return "Would you be really happy if you had " + restOfStatement + "?";
    }
    
    /**
     * Take a statement with "I <something> you" and transform it into 
     * "What makes you think that you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    private String transformIYouStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfI = findKeyword (statement, "I", 0);
        int psnOfYou = findKeyword (statement, "you", psnOfI + 3);
        
        String restOfStatement = statement.substring(psnOfI + 2, psnOfYou).trim();
        return "What do you " + restOfStatement + " about me?";
    }
    
    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
        
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }
    
    private String transformCanIMyStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfCanI = findKeyword (statement, "can I", 0);
        int psnOfMy = findKeyword (statement, "my", psnOfCanI + 3);
        
        String restOfStatement = statement.substring(psnOfCanI + 5, psnOfMy).trim();
        String endOfStatement = statement.substring(psnOfMy + 2).trim();
        return "What if you do not " + restOfStatement + " your " + endOfStatement;
        
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        
        //  Refinement--make sure the goal isn't part of a word 
        // Word boundary algorithm (3)
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            
            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
            
        }
        
        return -1;
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse() // generate random responses (2B)
    {
        final int NUMBER_OF_RESPONSES =17;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "You change your life by changing your heart.";
        }
        else if (whichResponse == 5)
        {
            response = "Countless as the sands of the sea are human passions.";
        }
        else if (whichResponse == 6)
        {
            response = "How glorious a greeting the sun gives the mountains!";
        }
        else if (whichResponse == 7)
        {
            response = "A compliment is something like a kiss through a veil.";
        }
        else if (whichResponse == 8)
        {
            response = "The authentic self is the soul made visible.";
        }
        else if (whichResponse == 9)
        {
            response = "A man has to learn that he cannot command things, but that he can command himself; that he cannot coerce the wills of others, but that he can mold and master his own will: and things serve him who serves Truth; people seek guidance of him who is master of himself.";
        }
        else if (whichResponse == 10)
        {
            response = "A place for everything, everything in its place.";
        }
        else if (whichResponse == 11)
        {
            response = "Reach for the stars.";
        }
        else if (whichResponse == 12)
        {
            response = "I actually don’t have a bad hairline.";
        }
        else if (whichResponse == 13)
        {
            response = "Winning isn’t everything, it’s the only thing.";
        }
        else if (whichResponse == 14)
        {
            response = "Owning a great golf course gives you great power.";
        }
        else if (whichResponse == 15)
        {
            response = "Everything in life is luck.";
        }
        else if (whichResponse == 16)
        {
            response = "Somebody made the statement that Donald Trump has built or owns the greatest collection of golf courses, ever, in the history of golf. And I believe that is 100 percent true.";
        }
        return response;
    }

}
