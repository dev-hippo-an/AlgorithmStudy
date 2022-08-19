package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class ChickenDelivery_15686 {

    static int N, M, ans;
    static ArrayList<Node> chicken, house;
    static Stack<Node> selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        selected = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    house.add(new Node(i, j));
                } else if (val == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        recursiveFunction(0, 0);
        System.out.println(ans);
    }

    public static void recursiveFunction(int T, int idx) {
        if (T == M) {
            int total = 0;
            for (int i = 0; i < house.size(); i++) {
                int x = house.get(i).x;
                int y = house.get(i).y;
                int temp = Integer.MAX_VALUE;
                for (Node chicken : selected) {
                    temp = Math.min(temp, getDistance(chicken.x, x, chicken.y, y));
                }
                total += temp;
            }
            ans = Math.min(ans, total);
            return;
        }
        for (int i = idx; i < chicken.size(); i++) {
            selected.push(new Node(chicken.get(i).x, chicken.get(i).y));
            recursiveFunction(T + 1, idx + 1);
            selected.pop();
        }

    }

    public static int getDistance(int x, int x1, int y, int y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
