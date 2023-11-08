/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1; 
  private Player player2; 
  private Board game; 
  private int playerGuessPhrase;

  /* your code here - constructor(s) */ 
  public PhraseSolver(){ 
    player1 = new Player(); 
    player2 = new Player(); 
    game = new Board(); 
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      
      /* your code here - game logic */
      String guess = ""; 
      boolean guessPhrase = false; 
      while (currentPlayer == 1){ 
        System.out.println("Current phrase solved: " + game.getSolvedPhrase()); 
        System.out.println("Point value of the next letter guess: " + game.getCurrentLetterValue()); 
        System.out.println("Current player name: " + player1.getName()); 
        System.out.println("Player points: " + player1.getPoints()); 
        System.out.println("Type in a guess(type in a letter, for guessing the entire phrase or when it is revealed, type in \" try phrase\"): "); 
        guess = input.nextLine();
      
      
      /* your code here - determine how game ends */
      solved = true; 
    } 
   
  }
  
}
