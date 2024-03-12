import java.util.Scanner;

public class Main {

    private static int n;
    private static int[] arr = new int[9];
    private static boolean[] visted = new boolean[9];
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = 9;

        for (int i = 0; i < 9; i++) {
            arr[i] = scanner.nextInt();
        }

        dfs(0, 0, 0);
    }

    private static void dfs(int p, int total, int cnt) {
        if (flag) {
            return;
        }

        if (p == 9) {
            if (total == 100 && cnt == 7) {
                flag = true;

                for (int i = 0; i < 9; i++) {
                    if (visted[i]) {
                        System.out.println(arr[i]);
                    }
                }
            }
        } else {
            visted[p] = true;
            dfs(p + 1, total + arr[p], cnt + 1);
            visted[p] = false;
            dfs(p + 1, total, cnt);
        }
    }
}