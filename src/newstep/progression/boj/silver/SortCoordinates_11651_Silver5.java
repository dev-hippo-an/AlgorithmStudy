package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortCoordinates_11651_Silver5 {

    private static Node[] arr;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new Node[N + 1];

        for (int i = 1;i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, 1, N + 1, (n1, n2) -> {
            if (n1.y == n2.y) return n1.x - n2.x;
            return n1.y - n2.y;
        });

        for (int i = 1; i <= N; i++) sb.append(arr[i].x).append(" ").append(arr[i].y).append("\n");

        System.out.println(sb);
    }

    public static class Node {
        int x;
        int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
