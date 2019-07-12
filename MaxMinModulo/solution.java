import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
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
        MaxMinModulo solver = new MaxMinModulo();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class MaxMinModulo {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            PriorityQueue<Integer> a = new PriorityQueue<>(new Comparator<Integer>() {
 
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            PriorityQueue<Integer> b = new PriorityQueue<>();
            ArrayList<Long> al = new ArrayList<>();
            ArrayList<Long> bo = new ArrayList<>();
 
            int n = in.nextInt();
            int k = in.nextInt();
            for (int i = 0; i < k - 1; i++) {
                int temp = in.nextInt();
                a.add(temp);
                b.add(temp);
            }
            long alice = 0;
            long bob = 0;
            for (int i = 0; i < n - k + 1; i++) {
                int temp = in.nextInt();
                a.add(temp);
                b.add(temp);
                long max = a.poll();
                al.add(max);
                alice += max;
                long min = b.poll();
                bo.add(min);
                bob += min;
            }
            long gcd = Maths.gcd(bob, alice);
            bob = bob / gcd;
            alice = alice / gcd;
            for (int i = 0; i < al.size(); i++) out.print(al.get(i) + " ");
            out.println();
            for (int i = 0; i < bo.size(); i++) out.print(bo.get(i) + " ");
            out.println();
            out.println((bob + alice) % 1000000007);
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