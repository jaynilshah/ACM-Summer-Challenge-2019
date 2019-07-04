import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Comparator;
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
        TokyoGhoul solver = new TokyoGhoul();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }
 
    static class TokyoGhoul {
        public int divisor(int n, PriorityQueue<Integer> q, int size) {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    if (i * i == n) {
                        q.add(i);
                        size++;
                    } else {
                        q.add(i);
                        q.add(n / i);
                        size++;
                        size++;
                    }
                }
            }
            return size;
        }
 
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            PriorityQueue<Integer> q = new PriorityQueue<Integer>(1000000,new Comparator<Integer>() {
 
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            int size = n;
            for (int i = 0; i < n; i++) q.add(in.nextInt());
            for (int i = 0; i < k; i++) {
                if (size == 0) {
                    out.println("It was easy!!");
                    return;
                } else {
                    size--;
                    size = divisor(q.poll(), q, size);
//                out.println(q);
 
                }
            }
            out.println(size);
 
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
