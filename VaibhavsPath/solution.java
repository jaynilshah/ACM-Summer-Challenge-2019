import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        VaibhavsPath solver = new VaibhavsPath();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }
 
    static class VaibhavsPath {
        public void grid(String grid[][], ArrayList<String> a, StringBuilder x, boolean v, int n, int m, int i, int j) {
//        System.out.println("n" + i + "m"+j);
 
            if (i == n && j == m) {
                x.append(grid[i - 1][j - 1]);
                if (v == true || grid[i - 1][j - 1].equals("a") || grid[i - 1][j - 1].equals("e") || grid[i - 1][j - 1].equals("i") || grid[i - 1][j - 1].equals("o") || grid[i - 1][j - 1].equals("u")) {
                    a.add(x.toString());
 
                }
                return;
 
            }
 
            x.append(grid[i - 1][j - 1]);
            if (v != true) {
                v = grid[i - 1][j - 1].equals("a") || grid[i - 1][j - 1].equals("e") || grid[i - 1][j - 1].equals("i") || grid[i - 1][j - 1].equals("o") || grid[i - 1][j - 1].equals("u");
            }
            StringBuilder xs;
            if (i + 1 <= n) {
                xs = new StringBuilder(x);
                grid(grid, a, xs, v, n, m, i + 1, j);
 
            }
            if (j + 1 <= m) {
                xs = new StringBuilder(x);
                grid(grid, a, xs, v, n, m, i, j + 1);
            }
            return;
 
 
        }
 
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            ArrayList<String> a = new ArrayList<>();
            String[][] s = new String[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    s[i][j] = in.next();
                }
            }
 
            StringBuilder p = new StringBuilder();
            grid(s, a, p, false, n, m, 1, 1);
            int length = a.size();
            if (length < k) {
                out.println(-1);
                return;
            }
            Collections.sort(a);
//        for(String x:a){
//            out.println(x);
//        }
            out.println(a.get(k - 1));
 
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
