/* Mathush Muhunthan
 * June 15, 2016
 * ISU - Mastermind 
 * Ms. Karasinska
 * Variable Dictionary
 *  startInstructions -> Holds the value to start the game and keep it going
 *  codeLength -> Holds the value of how long the computer's code will be
 *  code -> Holds the value of the code created
 *  gameMode -> Holds the value of which game mode has been selected
 *  choice -> Holds the string value of a choice that a user has made
 *  choiceLength -> Holds the value of the length the user chooses
 *  choiceLengthNum -> Holds the numeric value of the choice of length that will be returned
 *  mode -> Holds the value of the game mode the user chooses
 *  codeColours -> Holds the value of the 6 colours in a string, with their first letters
 *  computerCode -> Holds the value of the computer code being ranomly generated
 *  cWord -> Holds the value of the computer's code
 *  reults -> Is an array that holds the values of right colours and right colours in right place after comparing the guess
 *  codeGuess -> Holds the value of the user's guess
 *  guessCount -> Holds the value of the number of guesses the user has left in the guess game mode
 *  startTimer -> Holds the value of when the timer is started
 *  endTimer -> Holds the value of when the timer is ended
 *  totalTime -> Holds the value of the total time elapsed
 *  guess -> Holds the value of the guess the user has made
 *  colourRight -> Holds the value of the number of colours in the guess that are right but not in the right spot compared to the actual code
 *  colourPlaceRight -> Holds the value of the number of colours in the guess that are right and in the right spot compared to the actual code
 *  guessResults -> An array that holds the values of the results after comparing the guess to the code
 *  bCountU -> Holds the value of the total number of blues in the user's guess
 *  gCountU -> Holds the value of the total number of greens in the user's guess
 *  rCountU -> Holds the value of the total number of reds in the user's guess
 *  oCountU -> Holds the value of the total number of oranges in the user's guess
 *  pCountU -> Holds the value of the total number of purples in the user's guess
 *  yCountU -> Holds the value of the total number of yellows in the user's guess
 *  bCountC -> Holds the value of the total number of blues in the computer's guess
 *  gCountC -> Holds the value of the total number of greens in the computer's guess
 *  rCountC -> Holds the value of the total number of reds in the computer's guess
 *  oCountC -> Holds the value of the total number of oranges in the computer's guess
 *  pCountC -> Holds the value of the total number of purples in the computer's guess
 *  yCountC -> Holds the value of the total number of yellows in the computer's guess
 *  totalRightColour -> Holds the value of the total number of right colours after comparing the guess and the code
 * Program Description 
 *  This program is a game called Mastermind. This is a text based version of the game. The purpose of the game is to
 *  figure out the colour code that will be randomly genereated by the computer. The game has three levels of 
 *  difficulty. The user can pick the length of the code they have to guess from being 3 colours to 5. The user can
 *  also pick various game modes and depending on which game mode they pick, they can win or lose in different
 *  ways. The three game modes are: unlimited guesses, 10 guesses, and guess the code in less than 60 seconds. After
 *  each guess, the computer will tell how close the user's guess is to the code by telling them the number of right
 *  colours that are not in the right place and the number of right colours in the right spot. The rules and 
 *  instructions are explained more in detail within the game. After each game, the user will be asked if they want to
 *  play again. The game will keep going until they select to quit. 
 */
 
class mastermindISUextraFinal
{
  public static void main (String[] args)
  {
    //This is the code for the main menu 
    String startInstructions = gameStarting();
    
    //This is to make the game keep going until the user does not want to play anymore
    while (startInstructions.equals("1"))
    {
      int codeLength = computerCode();
      String code = createCode(codeLength); 
      String gameMode = modeSelection();
      //Runs a different game mode depending on which was selected
      if (gameMode.equals("1"))
      {
        playGameUnlimited(code, codeLength);
      }
      if (gameMode.equals("2"))
      {
        playGame10Guesses(code, codeLength);
      }
      if (gameMode.equals("3"))
      {
        playGameTimeLimit(code, codeLength);
      }
      startInstructions = playAgain();
    }
    System.out.println("Thanks for playing!");
  }
  
  //This method is for the start up menu
  public static String gameStarting()
  {
    //This is the title of the game
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    System.out.println("| %       %      %      % % % %   % % % % %   % % % %   % % % %   %       %   % % %   %       %   % % %   |");
    System.out.println("| % %   % %     % %     %             %       %         %     %   % %   % %     %     % %     %   %     % |");
    System.out.println("| %   %   %    %   %    % % % %       %       % % %     % % % %   %   %   %     %     %   %   %   %     % |");
    System.out.println("| %       %   % % % %         %       %       %         %   %     %       %     %     %     % %   %     % |");
    System.out.println("| %       %  %       %  % % % %       %       % % % %   %     %   %       %   % % %   %       %   % % %   |");
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    System.out.println("Welcome to Mastermind - text based version!!!");
    System.out.println("The challange is to guess the radnomly chosen colour code from the 6 colours");
    System.out.println("Please select one of the following options with their corresponding number");
    System.out.println("1: Start Game");
    System.out.println("2: Instructions");
    String choice = In.getString();
    
    //This is to make sure they input a valid length
    while (!((choice.equals("1")) || (choice.equals("2"))))
    {
      System.out.println("Please select one of the following options with their CORRESPONDING number");
      System.out.println("1: Start Game");
      System.out.println("2: Instructions");
      choice = In.getString(); 
    }
    
    //This is the code to print out the instructions of the game
    if (choice.equals("2"))
    {
      System.out.println("Here are the instructions");
      System.out.println("The computer will generate a random code of a certain amount of colours, that you select, from the following 6 colours:");
      System.out.println("blue, green, red, orange, purple and yellow");
      System.out.println("It is your job to guess the code by selecting the amount of the colours you chose");
      System.out.println("In order to select a colour, insert its first letter (ex. b - blue)");
      System.out.println("An example of a guess would be brby (blue, red, blue, yellow)");
      System.out.println("The program will state how many right colours you have and how many are in the right place for every guess");
      System.out.println("There are different ways to win and lose depending on which game mode you select, rules will be explained when selecting");
      System.out.println("When you are ready, press 1 to start");
      choice = In.getString();
      
      //This is to make sure they input the valid option of 1
      while (!(choice.equals("1")))
      {
        System.out.println("PLEASE press 1 to start");
        choice = In.getString(); 
      }
    }
    return choice;
  }
  
  //This method is for the play again menu
  public static String playAgain()
  {
    System.out.println("Would you like to play again? (Select the corresponding number)");
    System.out.println("1: Yes");
    System.out.println("2: No");
    String choice = In.getString();
    
    //This is to make sure that a valid input is put in
    while (!((choice.equals("1")) || (choice.equals("2"))))
    {
      System.out.println("Would you like to play again? (Select the CORRESPONDING number)");
      System.out.println("1: Yes");
      System.out.println("2: No");
      choice = In.getString();; 
    }
    
    return choice;
  }
  
  //This method is to get the computer's code length chosen by the user
  public static int computerCode()
  {
    System.out.println("How long do you want the code to be? (Input the length you want)");
    System.out.println("3: Easy");
    System.out.println("4: Medium");
    System.out.println("5: Hard");
    String choiceLength = In.getString();
    
    //This is to make sure they input a valid length
    while (!((choiceLength.equals("3")) || (choiceLength.equals("4")) || (choiceLength.equals("5"))))
    {
      System.out.println("How long do you want the code to be? (Input the VALID LENGTH you want)");
      System.out.println("3: Easy");
      System.out.println("4: Medium");
      System.out.println("5: Hard");
      choiceLength = In.getString(); 
    }
    //This is so that an int value is returned depending on the length chosen
    int choiceLengthNum = 0;
    if (choiceLength.equals("3"))
    {
      choiceLengthNum = 3;
    }
    
    if (choiceLength.equals("4"))
    {
      choiceLengthNum = 4;
    }
    
    if (choiceLength.equals("5"))
    {
      choiceLengthNum = 5;
    }
    
    return choiceLengthNum;
  }        
  
  //This method is see which game mode they are going to select
  public static String modeSelection()
  {
    System.out.println("Which game mode do you want to play? (Input the corresponding number)");
    System.out.println("1: Unlimited Guesses (You always win!)");
    System.out.println("2: 10 Guesses (Guess in 10 tries or you lose)");
    System.out.println("3: Time limit (If it has taken you more than 60 seconds to solve the code, you lose)");
    String mode = In.getString();
    
    //This is to make sure they input a valid number choice
    while (!((mode.equals("1")) || (mode.equals("2")) || (mode.equals("3"))))
    {
      System.out.println("Which game mode do you want to play? (Input the CORRESPONDING number)");
      System.out.println("1: Unlimited Guesses (You always win!)");
      System.out.println("2: 10 Guesses (Guess in 10 tries or you lose)");
      System.out.println("3: Time limit (If it has taken you more than 60 seconds to solve the code, you lose)");
      mode = In.getString(); 
    }
    
    //This returns the game mode they have selected
    return mode;
  }
  
  //Once the length has been chosen, this method generates the actual code the user has to guess
  public static String createCode(int codeLength)
  {
    String codeColours = "bgropy";
    String computerCode = "";
    //Generates the code randomly and returns it
    for (int i = 0; i < codeLength; i++)
    {
      computerCode = computerCode + codeColours.charAt((int)((Math.random()*6)));
    } 
    return computerCode;
  }
  
  //This method is for the game mode with unlimited guesses
  public static void playGameUnlimited(String cWord, int codeLength)
  {
    System.out.println("Time to play!!");
    //This is an array that will print out the results of the user
    int[] results = new int[2];
    
    //This is for the selection of a code with 3 colours
    if (codeLength == 3)
    {
      while (results[1] != 3)
      {
        System.out.println("Please insert 3 colours for your guess from the following colours (make sure lower case)");
        System.out.println("b, g, r, o, p, y");
        String codeGuess = In.getString();
        //This is to make sure for a valid input
        while (!inputChecker(codeGuess, codeLength))
        {
          System.out.println("Please insert 3 colours for your guess from the FOLLOWING colours (make sure LOWER CASE)");
          System.out.println("b, g, r, o, p, y");
          codeGuess = In.getString();
        }
        
        //This is to see how correct the guess is to the answer and reutrn the results 
        results = guessCompare(codeGuess, cWord);
        System.out.println("Number of colours right but not in right place: " + results[0]);
        System.out.println("Number of colours right and in right place: " + results[1]);
        System.out.println("");
      }
    }
    
    //This is for the selection of a code with 4 colours
    if (codeLength == 4)
    {
      while (results[1] != 4)
      {
        System.out.println("Please insert 4 colours for your guess from the following colours (make sure lower case)");
        System.out.println("b, g, r, o, p, y");
        String codeGuess = In.getString();
        while (!inputChecker(codeGuess, codeLength))
        {
          System.out.println("Please insert 4 colours for your guess from the FOLLOWING colours (make sure LOWER CASE)");
          System.out.println("b, g, r, o, p, y");
          codeGuess = In.getString();
        }
        results = guessCompare(codeGuess, cWord);
        System.out.println("Number of colours right but not in right place: " + results[0]);
        System.out.println("Number of colours right and in right place: " + results[1]);
        System.out.println("");
      }
    }
    
    //This is for the selection of a code with 5 colours
    if (codeLength == 5)
    {
      while (results[1] != 5)
      {
        System.out.println("Please insert 5 colours for your guess from the following colours (make sure lower case)");
        System.out.println("b, g, r, o, p, y");
        String codeGuess = In.getString();
        while (!inputChecker(codeGuess, codeLength))
        {
          System.out.println("Please insert 5 colours for your guess from the FOLLOWING colours (make sure LOWER CASE)");
          System.out.println("b, g, r, o, p, y");
          codeGuess = In.getString();
        }
        results = guessCompare(codeGuess, cWord);
        System.out.println("Number of colours right but not in right place: " + results[0]);
        System.out.println("Number of colours right and in right place: " + results[1]);
        System.out.println("");
      }
    }
    //This will print once they have guessed the code
    System.out.println("You Win!");
  }
  
  //This method is for the game mode where the user only gets ten guesses
  public static void playGame10Guesses(String cWord, int codeLength)
  {
    System.out.println("Time to play!!");
    int[] results = new int[2];
    //This is to begin the count down for number of guesses
    int guessCount = 10;
    System.out.println("Guesses Left: " + guessCount);
    
    //This is for the selection of a code with 3 colours
    if (codeLength == 3)
    {
      while ((results[1] != 3) && (guessCount != 0))
      {
        System.out.println("Please insert 3 colours for your guess from the following colours (make sure lower case)");
        System.out.println("b, g, r, o, p, y");
        String codeGuess = In.getString();
        while (!inputChecker(codeGuess, codeLength))
        {
          System.out.println("Please insert 3 colours for your guess from the FOLLOWING colours (make sure LOWER CASE)");
          System.out.println("b, g, r, o, p, y");
          codeGuess = In.getString();
        }
        results = guessCompare(codeGuess, cWord);
        System.out.println("Number of colours right but not in right place: " + results[0]);
        System.out.println("Number of colours right and in right place: " + results[1]);
        //This subtracts the count down and prints the number of guesses left
        guessCount--;
        System.out.println("Guesses Left: " + guessCount);
        System.out.println("");
      }
      //This is to check if they have managed to guess the code in 10 guesses and output the result
      if (guessCount == 0)
      {
        if (results[1] == 3)
        {
          System.out.println("You Win!"); 
        }
        else
        {
          System.out.println("Sorry, You Lose");
          System.out.println("The code was " + cWord);
        }
      }
      else
      {
        System.out.println("You Win!");
      }
    }
    
    //This is for the selection of a code with 4 colours
    if (codeLength == 4)
    {
      while ((results[1] != 4) && (guessCount != 0))
      {
        System.out.println("Please insert 4 colours for your guess from the following colours (make sure lower case)");
        System.out.println("b, g, r, o, p, y");
        String codeGuess = In.getString();
        while (!inputChecker(codeGuess, codeLength))
        {
          System.out.println("Please insert 4 colours for your guess from the FOLLOWING colours (make sure LOWER CASE)");
          System.out.println("b, g, r, o, p, y");
          codeGuess = In.getString();
        }
        results = guessCompare(codeGuess, cWord);
        System.out.println("Number of colours right but not in right place: " + results[0]);
        System.out.println("Number of colours right and in right place: " + results[1]);
        guessCount--;
        System.out.println("Guesses Left: " + guessCount);
        System.out.println("");
      }
      
      if (guessCount == 0)
      {
        if (results[1] == 4)
        {
          System.out.println("You Win!"); 
        }
        else
        {
          System.out.println("Sorry, You Lose");
          System.out.println("The code was " + cWord);
        }
      }
      else
      {
        System.out.println("You Win!");
      }
    }
    
    //This is for the selection of a code with 5 colours
    if (codeLength == 5)
    {
      while ((results[1] != 5) && (guessCount != 0))
      {
        System.out.println("Please insert 5 colours for your guess from the following colours (make sure lower case)");
        System.out.println("b, g, r, o, p, y");
        String codeGuess = In.getString();
        while (!inputChecker(codeGuess, codeLength))
        {
          System.out.println("Please insert 5 colours for your guess from the FOLLOWING colours (make sure LOWER CASE)");
          System.out.println("b, g, r, o, p, y");
          codeGuess = In.getString();
        }
        results = guessCompare(codeGuess, cWord);
        System.out.println("Number of colours right but not in right place: " + results[0]);
        System.out.println("Number of colours right and in right place: " + results[1]);
        guessCount--;
        System.out.println("Guesses Left: " + guessCount);
        System.out.println("");
      }
      
      if (guessCount == 0)
      {
        if (results[1] == 5)
        {
          System.out.println("You Win!"); 
        }
        else
        {
          System.out.println("Sorry, You Lose");
          System.out.println("The code was " + cWord);
        }
      }
      else
      {
        System.out.println("You Win!");
      }
    } 
  }
  
  //This method is used for the game mode with a timer
  public static void playGameTimeLimit(String cWord, int codeLength)
  {
    System.out.println("Time to play!!");
    System.out.println("Your 60 seconds start now!");
    //This variable is used to initialize the timer
    final long startTimer = System.currentTimeMillis();
    //This varaible is going to be used to end the timer
    long endTimer;
    //This varaible will get the overall time elapsed
    long totalTime;
    int[] results = new int[2];
    
    //This is for the selection of a code with 3 colours
    if (codeLength == 3)
    {
      while (results[1] != 3)
      {
        System.out.println("Please insert 3 colours for your guess from the following colours (make sure lower case)");
        System.out.println("b, g, r, o, p, y");
        String codeGuess = In.getString();
        while (!inputChecker(codeGuess, codeLength))
        {
          System.out.println("Please insert 3 colours for your guess from the FOLLOWING colours (make sure LOWER CASE)");
          System.out.println("b, g, r, o, p, y");
          codeGuess = In.getString();
        }
        results = guessCompare(codeGuess, cWord);
        System.out.println("Number of colours right but not in right place: " + results[0]);
        System.out.println("Number of colours right and in right place: " + results[1]);
        System.out.println("");
      }
      
      //The timer is ended and then compared to get the overall time
      endTimer = System.currentTimeMillis();
      totalTime = ((endTimer - startTimer)/1000);
      System.out.println("It has taken you " + totalTime + " seconds");
      
      //This is to check if the user has either won or lost from how long it has taken them
      if (totalTime > 60)
      {
        System.out.println("Sorry, You Lose");
      }
      else
      {
        System.out.println("You Win!");
      }
    }
    
    //This is for the selection of a code with 4 colours
    if (codeLength == 4)
    {
      while (results[1] != 4)
      {
        System.out.println("Please insert 4 colours for your guess from the following colours (make sure lower case)");
        System.out.println("b, g, r, o, p, y");
        String codeGuess = In.getString();
        while (!inputChecker(codeGuess, codeLength))
        {
          System.out.println("Please insert 4 colours for your guess from the FOLLOWING colours (make sure LOWER CASE)");
          System.out.println("b, g, r, o, p, y");
          codeGuess = In.getString();
        }
        results = guessCompare(codeGuess, cWord);
        System.out.println("Number of colours right but not in right place: " + results[0]);
        System.out.println("Number of colours right and in right place: " + results[1]);
        System.out.println("");
      }
      
      endTimer = System.currentTimeMillis();
      totalTime = ((endTimer - startTimer)/1000);
      System.out.println("It has taken you " + totalTime + " seconds");
      
      if (totalTime > 60)
      {
        System.out.println("Sorry, You Lose");
      }
      else
      {
        System.out.println("You Win!");
      }
    }
    
    //This is for the selection of a code with 5 colours
    if (codeLength == 5)
    {
      while (results[1] != 5)
      {
        System.out.println("Please insert 5 colours for your guess from the following colours (make sure lower case)");
        System.out.println("b, g, r, o, p, y");
        String codeGuess = In.getString();
        while (!inputChecker(codeGuess, codeLength))
        {
          System.out.println("Please insert 5 colours for your guess from the FOLLOWING colours (make sure LOWER CASE)");
          System.out.println("b, g, r, o, p, y");
          codeGuess = In.getString();
        }
        results = guessCompare(codeGuess, cWord);
        System.out.println("Number of colours right but not in right place: " + results[0]);
        System.out.println("Number of colours right and in right place: " + results[1]);
        System.out.println("");
      }
      
      endTimer = System.currentTimeMillis();
      totalTime = ((endTimer - startTimer)/1000);
      System.out.println("It has taken you " + totalTime + " seconds");
      
      if (totalTime > 60)
      {
        System.out.println("Sorry, You Lose");
      }
      else
      {
        System.out.println("You Win!");
      }
    } 
  }
  
 //This method checks to see if the user is imputing a proper input and returns true if they have
  public static boolean inputChecker (String guess, int codeLength)
  {
    if (guess.length() != codeLength)
    {
      return false;
    }
    else
    {
      for (int i = 0; i < guess.length(); i++)
      {
        if (!((guess.charAt(i)==('b')) || (guess.charAt(i)==('g')) || (guess.charAt(i)==('r')) || (guess.charAt(i)==('o')) || (guess.charAt(i)==('p')) || (guess.charAt(i)==('y'))))
        {
          return false;
        }
      }
      return true;
    }
  }
  
  //This method sees if the colour is right and in the right spot, also returns the resluts from comparing the user's guess to the computer's answer
  public static int[] guessCompare (String uGuess, String cWord)
  {
    //Initializes the variables to be used to count the number of right colours
    int colourRight = 0;
    int colourPlaceRight = 0;
    //Gets the total number of right colours that are in the right spot
    for (int i = 0; i < uGuess.length(); i++)
    {
      if (uGuess.charAt(i)==cWord.charAt(i))
      {
        colourPlaceRight++; 
      }
    }
    //Gets the actual amount of colours that are right but not in the right place
    colourRight = getColourNumber(uGuess, cWord);
    colourRight = colourRight - colourPlaceRight;
    
    //Puts the results into an array and returns it
    int[] guessResults = {colourRight, colourPlaceRight};
    return guessResults;
  }
  
  //This method is used to see if the guess is the right colour
  public static int getColourNumber (String user, String com)
  {
    //***This is very unefficent but since there was no other way figured out to solve it, this method was used. You also said it was okay.***
    
    //The following variables are initialized with a value of 0
    int bCountU = 0;
    int gCountU = 0;
    int rCountU = 0;
    int oCountU = 0;
    int pCountU = 0;
    int yCountU = 0;
    int bCountC = 0;
    int gCountC = 0;
    int rCountC = 0;
    int oCountC = 0;
    int pCountC = 0;
    int yCountC = 0;
    int totalRightColour = 0;
    
    //This is to count the number of appreances of each colour in the computer's code
    for (int i = 0; i < com.length(); i++)
    {
      if (com.charAt(i) == 'b')
      {
        bCountC++; 
      }
    }
    for (int i = 0; i < com.length(); i++)
    {
      if (com.charAt(i) == 'g')
      {
        gCountC++; 
      }
    }
    for (int i = 0; i < com.length(); i++)
    {
      if (com.charAt(i) == 'r')
      {
        rCountC++; 
      }
    }
    for (int i = 0; i < com.length(); i++)
    {
      if (com.charAt(i) == 'o')
      {
        oCountC++; 
      }
    }
    for (int i = 0; i < com.length(); i++)
    {
      if (com.charAt(i) == 'p')
      {
        pCountC++; 
      }
    }
    for (int i = 0; i < com.length(); i++)
    {
      if (com.charAt(i) == 'y')
      {
        yCountC++; 
      }
    }
    
    //This is to count the number of appreances of each colour in the user's guess
    for (int i = 0; i < user.length(); i++)
    {
      if (user.charAt(i) == 'b')
      {
        bCountU++; 
      }
    }
    for (int i = 0; i < user.length(); i++)
    {
      if (user.charAt(i) == 'g')
      {
        gCountU++; 
      }
    }
    for (int i = 0; i < user.length(); i++)
    {
      if (user.charAt(i) == 'r')
      {
        rCountU++; 
      }
    }
    for (int i = 0; i < user.length(); i++)
    {
      if (user.charAt(i) == 'o')
      {
        oCountU++; 
      }
    }
    for (int i = 0; i < user.length(); i++)
    {
      if (user.charAt(i) == 'p')
      {
        pCountU++; 
      }
    }
    for (int i = 0; i < user.length(); i++)
    {
      if (user.charAt(i) == 'y')
      {
        yCountU++; 
      }
    }
    
    //This compares the number of appreances and adds the number of times the colour is right for each colour to a total
    if (bCountC <= bCountU)
    {
      totalRightColour = totalRightColour + bCountC;
    }
    else
    {
      totalRightColour = totalRightColour + bCountU;
    }
    
    if (gCountC <= gCountU)
    {
      totalRightColour = totalRightColour + gCountC;
    }
    else
    {
      totalRightColour = totalRightColour + gCountU;
    }
    
    if (rCountC <= rCountU)
    {
      totalRightColour = totalRightColour + rCountC;
    }
    else
    {
      totalRightColour = totalRightColour + rCountU;
    }
    
    if (oCountC <= oCountU)
    {
      totalRightColour = totalRightColour + oCountC;
    }
    else
    {
      totalRightColour = totalRightColour + oCountU;
    }
    
    if (pCountC <= pCountU)
    {
      totalRightColour = totalRightColour + pCountC;
    }
    else
    {
      totalRightColour = totalRightColour + pCountU;
    }
    
    if (yCountC <= yCountU)
    {
      totalRightColour = totalRightColour + yCountC;
    }
    else
    {
      
      totalRightColour = totalRightColour + yCountU;
    }
    
    //The total number of right colours is then returned
    return totalRightColour;
  }  
}