public class TPalindrome {
  // Test if text is a T-palindrome.
  // The input is guaranteed to include only valid characters, i.e.,
  // those in {'a',...,'z','(',')','*'}. You don't need to check this.
  //
  public static boolean isTPalindrome(String text) {
    text.toLowerCase();
    String check = ""; // ?: String to be checked as a Palindrome
    char [] __text = text.toCharArray();
    int brO = 0, brC = 0; // ?: Opening Bracket Index, Closing Bracket Index

    for (int i = 0; i < __text.length; i++) {
      char c = __text[i];
      if (c == '(') {
        brO = i;
        check = "";
      }
      else if (c == ')') {
        brC = i;
        break;
      } else {
        check += c;
      }
    }
    
    if (brO == 0 && brC == 0) return isPalindrome(text); // No brackets found, just check left string
    else if (!isPalindrome(check)) return false; // If words in brackets are no palindrome, everything is no palindrome
    
    // ?: Replace Bracket Palindrome with '*'
    text = "";
    for (int i = 0; i < __text.length; i++) {
      char c = __text[i];
      if ((i < brO) || (i > brC)) text += c;
      else if (i == brO) text += "*";
    } 

    return isTPalindrome(text);
  }

  // ?: This implementation is stolen from Blatt 1
  private static boolean isPalindrome (String text) {
    // text = text.replaceAll("[!?.,-:;*' ]",""); // ?: No Regex checks required here
    Stack<Character> backward = new Stack<Character>();

    // ? Loop through text, pushes current char to stack -> chars are in reverse order
    for (Character symbol : text.toLowerCase().toCharArray()) {
      backward.push(symbol);
    }

    for (Character symbol : text.toLowerCase().toCharArray()) {
      if(!symbol.equals(backward.pop())) { //? Top of Stack is always char of text in reverse order
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isTPalindrome("TODO(PENEP)ODOT"));
    System.out.println(isTPalindrome("BR(non)br"));
  }
}
