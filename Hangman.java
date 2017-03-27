import java.util.Scanner;
import java.util.ArrayList;

class Hangman {

  static public void guess(String word, int lives){
    char[] charactersInWord = new char[word.length()];
    setCharactersInWord(word, charactersInWord);
    printWord(charactersInWord, lives);

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
            charactersInWord[y]=x;
          }
        }
      }
      else {
        lives -= 1;
      }
    if(word.equals(String.valueOf(charactersInWord))){
      winningSituation(charactersInWord);
      break;
    }
      printWord(charactersInWord, lives);
    }
    if(lives==0){
      losingSituation();
    }
  }

  public static void welcome(){
    System.out.println("Welcome to Hangman!");
    System.out.println("Take your first guess");
  }

  public static void setCharactersInWord(String word, char[] charactersInWord){
    for(int i=0; i < word.length(); i++){
      charactersInWord[i] = '_';
    }
  }

  public static void printWord(char[] charactersInWord, int lives){
    System.out.print(charactersInWord);
    System.out.print("\n");
    System.out.println("Lives remaining: " + lives);
  }

    public static void winningSituation(char[] charactersInWord){
      System.out.println(charactersInWord);
      System.out.println("You are the champion!");
    }

    public static void losingSituation(){
      System.out.println("You Lose");
    }

  public static void main(String[] args) {
    String word = "TIMMY";
    int lives = 5;
    welcome();
    guess(word, lives);
  }
}
