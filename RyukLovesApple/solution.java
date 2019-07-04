import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        RyukLovesApple solver = new RyukLovesApple();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class RyukLovesApple {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            if (n == 1) {
                int temp = in.nextInt();
                out.println("YES");
                out.println(0);
                return;
            }
            int x = (int) Math.ceil((double) n / 2);
 
            int a[] = new int[n];
            int ao[] = new int[n / 2];
            int ae[] = new int[x];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            int j = 0, k = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    ae[j] = a[i];
                    j++;
                } else {
                    ao[k] = a[i];
                    k++;
                }
            }
//        for(int i=0;i<n/2;i++) out.print(ao[i] + " ");
//        for(int i=0;i<x;i++) out.print(ae[i]);
            int odd = Array.isCircSortedAsce(ao, n / 2);
            if (odd == -1) {
                out.print("NO");
                return;
            }
            int even = Array.isCircSortedAsce(ae, x);
            if (even == -1) {
                out.print("NO");
                return;
            }
            Arrays.sort(ao);
            Arrays.sort(ae);
            for (int i = 0; i < n / 2; i++) {
                if (ae[i] <= ao[i]) {
                    if (i + 1 != n / 2) {
                        if (ao[i] <= ae[i + 1]) {
                            continue;
                        } else {
                            out.println("NO");
                            return;
                        }
                    }
                } else {
                    out.println("NO");
                    return;
                }
            }
            if (x != n / 2) {
                if (ao[n / 2 - 1] > ae[x - 1]) {
                    out.println("NO");
                    return;
                }
            }
            out.println("YES");
//        out.print(even);
//        out.print(odd);
            out.println(Math.min(x - even, even) + Math.min(n / 2 - odd, odd));
 
        }
 
    }
 
    static class Array {
        public static int isCircSortedAsce(int a[], int n) {
            int k = 0;
            int count = 0;
            for (int i = 0; i < n; i++)
                if (a[i] > a[(i + 1) % n]) {
                    count++;
                    k = i + 1;
                }
 
            return count <= 1 ? k : -1;
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
