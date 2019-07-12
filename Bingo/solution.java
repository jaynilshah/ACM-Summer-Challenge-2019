import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        BINGO solver = new BINGO();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class BINGO {
        public int calc(boolean a[][]) {
            int counti = 0;
            int countj = 0;
            int max = 0;
            for (int i = 0; i < 5; i++) {
                counti = 0;
                countj = 0;
                for (int j = 0; j < 5; j++) {
                    if (a[i][j] == true) {
                        counti++;
                    }
                    if (a[j][i] == true) {
                        countj++;
                    }
                }
                max = Math.max(max, counti);
                max = Math.max(max, countj);
            }
            counti = 0;
            countj = 0;
            for (int i = 0; i < 5; i++) {
                if (a[i][i] == true) {
                    counti++;
                }
                if (a[i][4 - i] == true) {
                    countj++;
                }
            }
            max = Math.max(max, counti);
            max = Math.max(max, countj);
 
 
            return max;
        }
 
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            HashMap<Integer, Integer> a = new HashMap<>();
            HashMap<Integer, Integer> b = new HashMap<>();
            int t[] = new int[25];
            boolean aa[][] = new boolean[5][5];
            boolean bb[][] = new boolean[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    a.put(in.nextInt(), i * 10 + j);
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    b.put(in.nextInt(), i * 10 + j);
                }
            }
            for (int i = 0; i < 25; i++) t[i] = in.nextInt();
            int prox = 0;
            int at = 0;
            int bt = 0;
            for (int i = 0; i < 25; i++) {
                prox = t[i];
                aa[a.get(prox) / 10][a.get(prox) % 10] = true;
                bb[b.get(prox) / 10][b.get(prox) % 10] = true;
                at = calc(aa);
                bt = calc(bb);
                out.println(at + " " + bt);
                if (at == bt && at == 5) {
                    out.println("It's a tie!");
                    break;
                }
                if (at == 5) {
                    out.println("I Won!");
                    break;
                }
                if (bt == 5) {
                    out.println("You won -_-");
                    break;
                }
 
            }
 
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