/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name = "";
  private double points;
  /* your code here - constructor(s) */ 
  public Player(){ 
    System.out.println("Please input your name:"); 
    Scanner sc = new Scanner(System.in); 
    name = sc.nextLine(); 
    points = 0; 
    System.out.println("Welcome to the game " + name + "!");
  }
  public Player(String inputName){
    name = inputName;points = 0;
    System.out.println("Welcome to the game " + name + "!");
  }
  /* your code here - accessor(s) */
  public String getName(){
    return name;
  }
  public double getPoints(){
    return points;
  }

  /* your code here - mutator(s) */
  public void addToPoints(double inputValue){
    points += inputValue;
  }
}
