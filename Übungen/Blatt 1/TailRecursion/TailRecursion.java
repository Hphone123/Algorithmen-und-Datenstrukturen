package TailRecursion;

public class TailRecursion {

  // Compute power 2^n recursively.
  //
  // The computation must use _tail recursion_!
  // Note: This requires the implementation of a tail recursive
  //       auxiliary method that is called by pow2()!)
  //
  public static int pow2(int n) {
    return _pow2(1, n);
  }

  private static int _pow2 (int n, int m) {
    if (m == 0) {
      return n;
    } else {
      return _pow2(n * 2, m - 1);
    }
  }

  // Compute the sum of factors (divisors) of n
  // The factors include 1 but exclude n, e.g., sumFactors(6) ==
  // 1+2+3 == 6 .
  //
  // The computation must use _tail recursion_!
  //
  public static int sumFactors(int n) {
    return _sumFactors(n, 1, 0);
  }

  private static int _sumFactors (int n, int m, int sum) {
    if (n == m) {
      return sum;
    } else {
      if (n % m == 0) {
        return _sumFactors(n, m + 1, sum + m);
      } else {
        return _sumFactors(n, m + 1, sum);
      }
    }
  }

  // Test your implementation.
  //
  public static void main(String[] args) {
    System.out.println(pow2(8));
    System.out.println(pow2(0));
    System.out.println(pow2(22));
   
    
    System.out.println(sumFactors(6));
    System.out.println(sumFactors(100));
  }
}
