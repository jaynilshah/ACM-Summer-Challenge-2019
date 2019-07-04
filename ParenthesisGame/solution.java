import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
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
        ParenthesisGame solver = new ParenthesisGame();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class ParenthesisGame {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String x = in.next();
            int l = x.length();
            int ans = 0;
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < l; i++) {
                if (x.charAt(i) == ')' && stack.empty()) {
                    continue;
                }
                if (x.charAt(i) == '(') {
                    stack.push('(');
                    continue;
                }
                if (x.charAt(i) == ')') {
                    stack.pop();
                    ans++;
                    ans++;
                }
            }
            out.print(ans);
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
 
    }
}
