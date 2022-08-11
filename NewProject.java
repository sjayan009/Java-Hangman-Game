import java.util.*;

public class NewProject
{
    public static char[] split_word;
    public static char[] blankList;
    public static String[] word_list = {"HELLO"};
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        //Introduction
        System.out.println("You are going to play a game of hangman.");
        
        //Choosing Word
        int placeHolder = (int) (Math.random() * (word_list.length));
        String word = word_list[placeHolder]; 
        split_word = word.toCharArray();

        //Updating blankList
        blankList = new char[split_word.length];
        
        //Testing Purposes(REVEAL WORD)
        System.out.println(Arrays.toString(split_word));

        //Game Play
        gamePlay(split_word);
    }

    public static void gamePlay(char[] array)
    {
        int counter = 0;
        while(counter < array.length)
        {
            blankList[counter] = '_';
            counter++;
        }
        System.out.println("Your word is " + array.length + " letters long");
        System.out.println(Arrays.toString(blankList) + "\n");

        char[] guessedLetters = new char[8];

        //counter set to value of zero again
        counter = 0;

        while(counter < 7) //The Number of Maximum Guesses
        {
            System.out.print("Please enter a letter: ");
            char letter = sc.next().charAt(0);
            
            for(int i = 0; i < guessedLetters.length; i++)
            {
                while(guessedLetters[i] == letter)
                {
                    System.out.println("Enter a new letter below: ");
                    letter = sc.next().charAt(0);
                }
                break;
            }

            guessedLetters[counter] = letter;
            
            for(int i = 0; i < split_word.length; i++)
            {
                if(split_word[i] == letter)
                {
                    blankList[i] = letter;
                }
            }

            System.out.println(Arrays.toString(blankList) + "\n");

            //To Keep Track of the arrays being equal:
            boolean result = Arrays.equals(blankList,split_word);
            if(result == true)
            {
                counter = 7;
                end_credits();
                //break;
            }
            
            counter++;
        }
    }

    public static void end_credits()
    {
        System.out.println("Finished.");
    }
        
}