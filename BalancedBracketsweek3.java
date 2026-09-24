import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BalancedBracketsweek3 {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        Set<Character> mo = new HashSet<>();
        mo.add('[');
        mo.add('(');
        mo.add('{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character now = s.charAt(i);

            if (mo.contains(now)) {
                stack.add(now);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }

                Character top = stack.peek();

                if (now.equals(']')) {
                    if (top.equals('[')) {
                        stack.pop();
                    } else {
                        return "NO";
                    }
                } else if (now.equals(')')) {
                    if (top.equals('(')) {
                        stack.pop();
                    } else {
                        return "NO";
                    }
                } else if (now.equals('}')) {
                    if (top.equals('{')) {
                        stack.pop();
                    } else {
                        return "NO";
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
