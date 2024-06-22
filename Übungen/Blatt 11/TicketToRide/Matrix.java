package TicketToRide;

public class Matrix {
  private static final String dimension_error = "Illegal matrix dimensions.";
  private final int M; // number of rows
  private final int N; // number of columns
  private final int[][] data; // M-by-N array

  // create M-by-N matrix of 0's
  public Matrix(int M, int N) {
    if (M <= 0 || N <= 0)
      throw new RuntimeException(dimension_error);
    this.M = M;
    this.N = N;
    data = new int[M][N];
  }

  // create a square N-by-N matrix
  public Matrix(int N) {
    this(N, N);
  }

  // create matrix based on 2d array
  public Matrix(int[][] data) {
    M = data.length;
    N = data[0].length;
    this.data = new int[M][N];
    for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
        this.data[i][j] = data[i][j];
  }

  // copy constructor
  public Matrix(Matrix A) {
    this(A.data);
  }

  public int get(int row_id, int column_id) {
    return data[row_id][column_id];
  }

  public void set(int row_id, int column_id, int value) {
    data[row_id][column_id] = value;
  }

  // return C = A * B
  public Matrix times(Matrix B) {
    Matrix A = this;
    if (A.N != B.M)
      throw new RuntimeException(dimension_error);
    Matrix C = new Matrix(A.M, B.N);
    for (int i = 0; i < C.M; i++)
      for (int j = 0; j < C.N; j++)
        for (int k = 0; k < A.N; k++)
          C.data[i][j] += (A.data[i][k] * B.data[k][j]);
    return C;
  }

  public int[] getRow(int row_id) {
    int[] result = new int[N];
    for (int i = 0; i < N; ++i)
      result[i] = data[row_id][i];
    return result;
  }

  public int[] getColumn(int column_id) {
    int[] result = new int[M];
    for (int i = 0; i < M; ++i)
      result[i] = data[i][column_id];
    return result;
  }

  // print matrix to standard output
  public String toString() {
    StringBuilder output = new StringBuilder("");
    // --- find out decimals we need in each column
    int[] dec = new int[N];
    for (int i = 0; i < N; ++i) {
      int[] col = getColumn(i);
      int tmp = 0;
      for (int j = 0; j < M; j++)
        if (Math.abs(col[j]) > tmp)
          tmp = Math.abs(col[j]);
      int cnt = 0;
      do {
        ++cnt;
        tmp /= 10;
      } while (tmp > 0);
      dec[i] = cnt;
    }
    // ---
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        int lng = dec[j];
        Integer val = data[i][j];
        String tmp_val = val.toString();
        while (tmp_val.length() < lng)
          tmp_val = " " + tmp_val;
        tmp_val = val < 0 ? " " + tmp_val : "  " + tmp_val;
        output.append(tmp_val);
      }
      output.append("\n");
    }
    return output.toString();
  }

  // create and return the transpose of the invoking matrix
  public Matrix transpose() {
    Matrix A = new Matrix(N, M);
    for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
        A.data[j][i] = this.data[i][j];
    return A;
  }

  // return C = A + B
  public Matrix plus(Matrix B) {
    Matrix A = this;
    if (B.M != A.M || B.N != A.N)
      throw new RuntimeException(dimension_error);
    Matrix C = new Matrix(M, N);
    for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
        C.data[i][j] = A.data[i][j] + B.data[i][j];
    return C;
  }

  // return C = A - B
  public Matrix minus(Matrix B) {
    Matrix A = this;
    if (B.M != A.M || B.N != A.N)
      throw new RuntimeException(dimension_error);
    Matrix C = new Matrix(M, N);
    for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
        C.data[i][j] = A.data[i][j] - B.data[i][j];
    return C;
  }

  // A == B exactly?
  public boolean equals(Matrix B) {
    Matrix A = this;
    if (B.M != A.M || B.N != A.N)
      throw new RuntimeException(dimension_error);
    for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
        if (A.data[i][j] != B.data[i][j])
          return false;
    return true;
  }
}
