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
        correct = game.guessLetter(guess);
        if (guess.length() == 1 && correct){
          System.out.println("You got it correct! You will receive " +game.getCurrentLetterValue() + " points.");
          player1.addToPoints(game.getCurrentLetterValue());
          game.setLetterValue();
          if (game.getSolvedPhrase().indexOf("_") == -1){
            currentPlayer = 0;
            solved = true;
            System.out.println("You have solved the phrase!");
            if (player1.getPoints()>player2.getPoints()){
              System.out.println(player1.getName() + " wins with the highestscore!");
            }else if(player2.getPoints()>player1.getPoints()) {
              System.out.println(player2.getName() + " wins with the highestscore!");
            }else{
              System.out.println(player1.getName() + " and " + player2.getName() +" ties the game!");
            }
          }
        }else if(guess.equals("try phrase")) {
          currentPlayer = 0;
          playerGuessPhrase = 1;
          guessPhrase = true;
        }else if (!correct){
          System.out.println("Your guess was incorrect!");
          currentPlayer = 2;
        }
      }while (currentPlayer == 2) {
        System.out.println("Current phrase solved: " + game.getSolvedPhrase());
        System.out.println("Point value of the next letter guess: " +game.getCurrentLetterValue());
        System.out.println("Current player name: " + player2.getName());
        System.out.println("Player points: " + player2.getPoints());
        System.out.println("Type in a guess(type in a letter, for guessing the entire phrase or when it is revealed, type in \" try phrase\"): ");
        guess = input.nextLine();
        correct = game.guessLetter(guess);
        if (guess.length() == 1 && correct){
          System.out.println("You got it correct! You will receive " +game.getCurrentLetterValue() + " points.");
          player2.addToPoints(game.getCurrentLetterValue());game.setLetterValue();
          if (game.getSolvedPhrase().indexOf("_") == -1){
            currentPlayer = 0;solved = true;
            System.out.println("You have solved the phrase!");
            if (player1.getPoints()>player2.getPoints()){
              System.out.println(player1.getName() + " wins with the highestscore!");
            }else if(player2.getPoints()>player1.getPoints()) {
              System.out.println(player2.getName() + " wins with the highestscore!");
            }else{
              System.out.println(player1.getName() + " and " + player2.getName()+ " ties the game!");
            }
          }
        }else if(guess.equals("try phrase")) {
          currentPlayer = 0;
          playerGuessPhrase = 2;
          guessPhrase = true;
        }else if (!correct){
          System.out.println("You guess was incorrect!");
          currentPlayer = 1;
        }
      }
      
      /* your code here - determine how game ends */
      if (guessPhrase){
        System.out.println("Type in your guess for the entire phrase: ");
        guess = input.nextLine();
        if (game.isSolved(guess)){
          solved = true;
          System.out.println("The phrase has been solved!");
          if (player1.getPoints()>player2.getPoints()){
            System.out.println(player1.getName() + " wins with the highest score!");
          }else if(player2.getPoints()>player1.getPoints()) {
            System.out.println(player2.getName() + " wins with the highest score!");
          }else{
            System.out.println(player1.getName() + " and " + player2.getName() + "ties the game!");
          }
        }else{
          System.out.println("Your guess for the phrase was incorrect! The chance will pass on to the other player!");
          if (playerGuessPhrase == 1){
            currentPlayer = 2;
          }else{
            currentPlayer = 1;
          }
        }
      }
    }
  }
}
      
