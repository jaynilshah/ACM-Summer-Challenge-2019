import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jaynil
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParenthesisGameAgain solver = new ParenthesisGameAgain();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class ParenthesisGameAgain {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = in.next();
            }
            Stack<Character> s = new Stack<>();
            int zero = 0;
            int count = 0;
            int pos = 0;
            int neg = 0;
            int l = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                pos = 0;
                neg = 0;
                l = str[i].length();
                for (int j = 0; j < l; j++) {
                    if (!s.isEmpty() && s.peek() == '(' && str[i].charAt(j) == ')') {
                        s.pop();
                    } else {
                        s.push(str[i].charAt(j));
                    }
                }
                if (s.isEmpty()) {
                    zero++;
                    continue;
                }
                while (!s.isEmpty()) {
                    if (s.pop() == '(') {
                        pos++;
                    } else {
                        neg--;
                    }
                }
                if (pos != 0 && neg != 0) {
                    continue;
                }
                if (neg == 0 && pos > 0) {
                    if (map.containsKey(-pos) && map.get(-pos) >= 1) {
                        map.put(-pos, map.get(-pos) - 1);
                        count++;
                    } else {
                        if (map.containsKey(pos)) {
                            map.put(pos, map.get(pos) + 1);
                        } else {
                            map.put(pos, 1);
                        }
                    }
                    continue;
                }
 
                if (pos == 0 && neg < 0) {
                    if (map.containsKey(-neg) && map.get(-neg) >= 1) {
                        map.put(-neg, map.get(-neg) - 1);
                        count++;
                    } else {
                        if (map.containsKey(neg)) {
                            map.put(neg, map.get(neg) + 1);
                        } else {
                            map.put(neg, 1);
                        }
                    }
                    continue;
                }
 
            }
            out.println(count + (zero / 2));
        }
 
    }
 
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
    }
}
