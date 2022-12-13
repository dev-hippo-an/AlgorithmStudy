package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintSame_11718_Bronze5 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String s = br.readLine();

                if (s == null || s.length() == 0) {
                    break;
                }

                sb.append(s)
                        .append("\n");
            }
            System.out.println(sb);
        }
    }
}
