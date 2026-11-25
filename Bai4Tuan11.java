import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int pairs(int k, List<Integer> arr) {
        int pairs = 0;
        Set<Long> seen = new HashSet<>();

        for (int num : arr) {
            long val = num;
            if (seen.contains(val + k)) {
                pairs++;
            }
            if (seen.contains(val - k)) {
                pairs++;
            }
            seen.add(val);
        }
        return pairs;
    }
}

public class Bai4Tuan11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().trim().split("\\s+"))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pairs(k, arr);
        System.out.println(result);

        bufferedReader.close();
    }
}