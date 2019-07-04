import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.Set;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
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
        ChrissyLovesPhysics solver = new ChrissyLovesPhysics();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class ChrissyLovesPhysics {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int a[] = new int[n];
            int temp[] = new int[n];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            SortedSet<Integer> ss = new TreeSet<>();
            ss.add(a[n - 1]);
            long ans = 0;
 
            ans = Array.merge(a, temp, 0, n - 1);
            out.println(ans);
        }
 
    }
 
    static class Array<Type> {
        public static long merge(int[] a, int[] temp, int l, int r) {
            if (l < r) {
                int mid = (l + r) / 2;
                long invCount = 0;
                invCount = merge(a, temp, l, mid);
                invCount += merge(a, temp, mid + 1, r);
                invCount += split(a, temp, l, mid + 1, r);
                return invCount;
 
 
            } else {
                return 0;
            }
 
 
        }
 
        public static long split(int[] a, int temp[], int l, int mid, int r) {
            int i = l, k = l, j = mid;
            long splitCount = 0;
            while ((i <= mid - 1) && (j <= r)) {
                if (a[i] <= a[j]) {
                    temp[k++] = a[i++];
                } else {
                    temp[k++] = a[j++];
                    splitCount += (mid - i);
                }
            }
            while (i <= mid - 1) {
                temp[k++] = a[i++];
            }
            while (j <= r) {
                temp[k++] = a[j++];
            }
            for (int p = l; p <= r; p++) {
                a[p] = temp[p];
            }
            return splitCount;
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
