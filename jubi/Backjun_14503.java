import java.util.Scanner;

public class Backjun_14503 {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    private static int[][] arr;
    private static int n;
    private static int m;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n][m];

        int c = scanner.nextInt();
        int r = scanner.nextInt();
        int d = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        while (true) {
            if (arr[c][r] == 0) {
                answer++;

                arr[c][r] = -1;
            }

            if (check(r, c)) {
                r = r - dx[d % 4];
                c = c - dy[d % 4];

                if (arr[c][r] == 1) {
                    break;
                }
            } else {
                d = d + 3;

                if (arr[c + dy[d % 4]][r + dx[d % 4]] == 0) {
                    r = r + dx[d % 4];
                    c = c + dy[d % 4];
                }
            }
        }

        System.out.println(answer);
    }

    // return true 면 청소되지 않은 빈 칸이 없는 경우
    // return false 면 청소되지 않은 빈 칸이 있는 경우
    private static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < m && nx >= 0 && ny < n && ny >= 0 && arr[ny][nx] == 0) return false;
        }

        return true;
    }
}
