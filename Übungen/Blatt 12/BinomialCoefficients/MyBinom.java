package BinomialCoefficients;

//-----------------------------------------------------------------//
public class MyBinom {
  //---------------------------------------------------------------//
  public static int binom(int n, int k) {
    int[][] C = new int[n + 1][k + 1];
    // Berechnung des Binomialkoeffizienten in einer Bottom-Up-Manier
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= Math.min(i, k); j++) {
            // Basisfall: C(i, 0) = C(i, i) = 1
            if (j == 0 || j == i) {
                C[i][j] = 1;
            } else {
                // Wertberechnung unter Verwendung der vorher gespeicherten Werte
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }

    return C[n][k];
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    System.out.println("7 over 5: " + binom(7, 5));
  }
}
