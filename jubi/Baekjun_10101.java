import java.util.Scanner;

public class Baekjun_10101 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // 세 각의 크기가 모두 60이면, Equilateral
        if (a == 60 && b == 60 && c== 60) {
            System.out.println("Equilateral");
        } else if (a + b + c == 180) {
            if (a == b || b == c || c == a) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else {
            System.out.println("Error");
        }
    }
}
