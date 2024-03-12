import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Point[] arr = new Point[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            Point point = arr[i];

            System.out.println(point.x + " " + point.y);
        }
    }
}

class Point implements Comparable<Point> {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.y == o.y) {
            return this.x - o.x;
        } else {
            return this.y - o.y;
        }
    }
}