import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int n;
    private static int m;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];

        dfs(1, 0);
    }

    private static void dfs(int L, int cnt) {
        if (cnt == m) {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    System.out.println(i);
                }
            }
        } else {
            visited[L] = true
            dfs(L + 1, cnt + 1);
            visited[L] = false
            dfs(L, cnt);
        }
    }
}