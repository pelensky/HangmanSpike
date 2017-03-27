import java.util.Scanner;
import java.util.ArrayList;

class Hangman {

  static public void guess(String word, int lives){
    char[] emptySpaces = new char[word.length()];

    for(int i=0; i < word.length(); i++){
      emptySpaces[i] = '_';
    }

    Scanner scanner = new Scanner(System.in);
    ArrayList<Character> listOfCharacters = new ArrayList<Character>();

    while(lives>0){
      char x = Character.toUpperCase(scanner.next().charAt(0));
      if(listOfCharacters.contains(x)){
        System.out.println("You have already guessed " + x);
        continue;
      }
      listOfCharacters.add(x);

      if(word.contains(x + "")){
        for (int y = 0; y < word.length(); y++){
          if(word.charAt(y)==x){
            emptySpaces[y]=x;
          }
        }
      }
      else {
        lives -= 1;
      }
    if(word.equals(String.valueOf(emptySpaces))){
      System.out.println(emptySpaces);
      System.out.println("You are the champion!");
      break;
    }

    System.out.print(emptySpaces);
    System.out.print("\n");
    System.out.println("Lives remaining: " + lives);
    }
    if(lives==0){
      System.out.println("You Lose");
    }
  }

  public static void welcome(){
    System.out.println("Welcome to Hangman!");
    System.out.println("Take your first guess");
  }

  public static void main(String[] args) {
    String word = "TIMMY";
    int lives = 5;
    String line = "-------------------------";
    welcome();
    guess(word, lives);
  }
}
