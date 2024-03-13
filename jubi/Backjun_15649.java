import java.util.Scanner;

public class Main {

    private static int n;
    private static int m;
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];
        arr = new int[m];

        dfs(0);
    }

    private static void dfs(int L) {
        if (L == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    arr[L] = i + 1;
                    dfs(L + 1);
                    visited[i] = false;
                }
            }
        }
    }

}