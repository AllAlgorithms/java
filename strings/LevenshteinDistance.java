// Source: https://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Levenshtein_distance#Java
public class LevenshteinDistance {
  private static int minimum(int a, int b, int c) {
    return Math.min(Math.min(a, b), c);
  }


  public static int computeLevenshteinDistance(CharSequence lhs, CharSequence rhs) {
    int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

    for (int i = 0; i <= lhs.length(); i++)
      distance[i][0] = i;
    for (int j = 1; j <= rhs.length(); j++)
      distance[0][j] = j;

    for (int i = 1; i <= lhs.length(); i++)
      for (int j = 1; j <= rhs.length(); j++)
        distance[i][j] = minimum(
            distance[i - 1][j] + 1,
            distance[i][j - 1] + 1,
            distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));

    return distance[lhs.length()][rhs.length()];
  }
  // Driver method to test above
  public static void main(String args[]){
    System.out.println("Distance from 'stull' to 'still' is :"+ LevenshteinDistance.computeLevenshteinDistance("stull", "still"));
    System.out.println("Distance from 'stull' to 'steal' is :"+ LevenshteinDistance.computeLevenshteinDistance("stull", "steal"));
    System.out.println("Distance from 'skill' to 'steal' is :"+ LevenshteinDistance.computeLevenshteinDistance("skill", "steal"));
  }
}