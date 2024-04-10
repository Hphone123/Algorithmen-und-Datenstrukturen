public class JosephusProblem {

  // Solve the Josephus problem for a list of persons and a number k
  // of persons to be skipped. The solution should "simulate" the
  // counting-out and return a queue that contains all persons in the
  // order they were counted out.
  //
  public static Queue<String> solve(String[] persons, int k) {
    return _solve(persons, new Queue<String>(), k, 0);
  }

  private static Queue<String> _solve (String[] persons, Queue<String> elims, int k, int startEl) {
    if (persons.length == 0) return elims;
    int elimIndex = (k - 1 - startEl) % persons.length;
    elims.enqueue(persons[elimIndex]);
    String[] _persons = new String[persons.length - 1];
    int j = 0;
    for (int i = 0; i < persons.length - 1; i++) {
      if (i == elimIndex) ++j;
      _persons[i] = persons[i+j];
    }

    return _solve(_persons, elims, k, elimIndex);
  }

  public static void main(String[] args) {
    String[] input = {
      "1",
      "2",
      "3",
      "4",
      "5",
      "6"
    };
    System.out.println(solve(input, 4).toString());
  }
}
