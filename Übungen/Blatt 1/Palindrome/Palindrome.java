package Palindrome;

import aud.Stack;

public class Palindrome {

  public static boolean isPalindrome(String text) {
    // Check against regex for punctuation and spaces
    text = text.replaceAll("[!?.,-:;*' ]","");
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
    System.out.println(isPalindrome("O, Streit irritiert so!"));
    System.out.println(isPalindrome("Ein nichtpalindromiger Satz!!"));
  }
}
