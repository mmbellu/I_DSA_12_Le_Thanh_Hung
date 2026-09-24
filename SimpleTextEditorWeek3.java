import java.io.*;
import java.util.*;

public class SimpleTextEditorWeek3 {

    public static void main(String[] args) throws IOException {
        Stack<String> history = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder S = new StringBuilder();
        String line = br.readLine();
        if (line == null) return;
        int Q = Integer.parseInt(line.trim());

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                String W = st.nextToken();
                history.push(S.toString());
                S.append(W);

            } else if (type == 2) {
                int k = Integer.parseInt(st.nextToken());
                history.push(S.toString());
                S.delete(S.length() - k, S.length());

            } else if (type == 3) {
                int k = Integer.parseInt(st.nextToken());
                System.out.println(S.charAt(k - 1));

            } else if (type == 4) {
                if (!history.isEmpty()) {
                    S = new StringBuilder(history.pop());
                }
            }
        }
    }
}
