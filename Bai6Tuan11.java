import java.io.*;
import java.util.*;

public class Bai6Tuan11 {

    private static class Node implements Comparable<Node> {
        final int val;
        final int idx;

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.idx, other.idx);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result = new ArrayList<>(a.size());
        TreeSet<Node> set = new TreeSet<>();
        Node mid = null;

        for (int i = 0; i < a.size(); i++) {
            Node cur = new Node(a.get(i), i);
            set.add(cur);

            int size = set.size();
            if (size == 1) {
                mid = cur;
            } else if (size % 2 == 0) {
                if (cur.compareTo(mid) < 0) {
                    mid = set.lower(mid);
                }
            } else {
                if (cur.compareTo(mid) > 0) {
                    mid = set.higher(mid);
                }
            }

            if (size % 2 == 1) {
                result.add((double) mid.val);
            } else {
                Node nextMid = set.higher(mid);
                result.add(((double) mid.val + nextMid.val) / 2.0);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String outputPath = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = (outputPath != null)
                ? new BufferedWriter(new FileWriter(outputPath))
                : new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        String firstLine;
        while ((firstLine = br.readLine()) != null && firstLine.trim().isEmpty()) {
            // Skip empty leading lines
        }
        if (firstLine == null) {
            br.close();
            bw.close();
            return;
        }

        st = new StringTokenizer(firstLine);
        int n = Integer.parseInt(st.nextToken());
        List<Integer> a = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                st = new StringTokenizer(line);
            }
            if (st.hasMoreTokens()) {
                a.add(Integer.parseInt(st.nextToken()));
            }
        }

        List<Double> result = runningMedian(a);
        StringBuilder sb = new StringBuilder();
        for (double median : result) {
            sb.append(String.format(Locale.US, "%.1f", median)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        if (outputPath != null) {
            bw.close();
        }
    }
}
