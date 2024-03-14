import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 규칙성을 발견하는 문제
        // 정렬하고 작은 숫자 부터 오른쪽 왼쪽 오른쪽 왼쪽 .. 하면 됨
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] answer = new int[n];
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }

            Arrays.sort(arr);

            int lt = 0;
            int rt = n - 1;

            for (int j = 0; j < n; j++) {
                int num = arr[j];

                if (j % 2 == 0) {
                    answer[lt++] = num;
                } else {
                    answer[rt--] = num;
                }
            }

            int min = Math.abs(answer[0] - answer[n - 1]);

            for (int j = 1; j < n; j++) {
                min = Math.max(min, Math.abs(answer[j - 1] - answer[j]));
            }

            System.out.println(min);
        }
    }

}