class Hangman {
 
  static public void guess(String word, int lives){
    char[] emptySpaces = new char[word.length()];
    
   for(int i=0; i < word.length(); i++){
      emptySpaces[i] = '_';
    }
    System.out.print(emptySpaces);
    System.out.println("Lives remaining: " + lives);
  }

  public static void main(String[] args) {
    String word = "TIMMY";
    int lives = 5;
    guess(word, lives);
  }
}
