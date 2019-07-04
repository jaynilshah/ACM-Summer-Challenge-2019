import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
        EvenProbability solver = new EvenProbability();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class EvenProbability {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int q = in.nextInt();
            tree t = new tree(n, k);
            while (q-- > 0) {
                int step = in.nextInt();
                long ans = t.getProb(step);
                if (ans == -1) {
                    out.println("All odd");
                } else {
                    out.println(ans);
                }
            }
 
        }
 
        class node {
            node l;
            node m;
            node r;
            int val;
            int h;
 
            node(int val, int h) {
                this.val = val;
                this.h = h;
            }
 
        }
 
        class tree {
            int ans[];
            node root;
            int k;
 
            tree(int n, int k) {
                this.ans = new int[12];
                this.root = new node(n, 0);
                this.k = k;
                this.create(this.root);
            }
 
            public void create(node x) {
                int val = x.val;
                int h = x.h;
                if (val % 2 == 0) {
                    ans[h]++;
                }
                if (h == 10) {
                    return;
                }
                x.l = new node(val & k, h + 1);
                x.m = new node(val | k, h + 1);
                x.r = new node(val ^ k, h + 1);
                create(x.l);
                create(x.m);
                create(x.r);
            }
 
            long getProb(int step) {
                long num = ans[step];
                if (num == 0) {
                    return -1;
                }
                long den = (long) Math.pow(3, step);
                long gcd = Maths.gcd(num, den);
                num = num / gcd;
                den = den / gcd;
 
 
                return num + den;
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
 
    static class Maths {
        static long gcd(long a, long b) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
 
            long r, i;
            while (b != 0) {
                r = a % b;
                a = b;
                b = r;
            }
            return a;
 
 
//        while (a != b)
//        {
//            if (a > b)
//                a = a - b;
//            else
//                b = b - a;
//        }
//        return a;
        }
 
    }
}
