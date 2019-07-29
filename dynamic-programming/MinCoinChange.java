public class MinCoinChange {

    static int minCoins(int coins[], int m, int V) {
        int dp[] = new int[V + 1];

        dp[0] = 0;

        for (int i = 1; i <= V; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i) {
                    int rest = dp[i - coins[j]];
                    if (rest != Integer.MAX_VALUE && rest + 1 < dp[i]) {
                        dp[i] = rest + 1;
                    }
                }
            }
        }

        return dp[V];
    }

    public static void main(String args[]) {
        int coins[] = { 9, 6, 5, 1 };
        int m = coins.length;
        int value = 15;
        System.out.println("Minimum coins is " + minCoins(coins, m, value));
    }
}
