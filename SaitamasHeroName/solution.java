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
        SaitamasHeroName solver = new SaitamasHeroName();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class SaitamasHeroName {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int a[] = new int[27];
            int n = in.nextInt();
            int k = in.nextInt();
            StringBuilder ans = new StringBuilder("");
            for (int i = 0; i < n; i++) {
                a[in.next().charAt(0) - 'a']++;
            }
            int set = 0;
            if (k % 2 == 1) {
                set = 1;
                k--;
            }
            for (int i = 0; i < 26; i++) {
                if (a[i] >= k) {
                    for (int j = 0; j < k / 2; j++) {
                        ans.append((char) (97 + i));
                    }
                    a[i] = a[i] - k;
                    k = 0;
                    break;
                } else {
                    if (a[i] % 2 == 0) {
                        for (int j = 0; j < a[i] / 2; j++) {
                            ans.append((char) (97 + i));
                        }
                        k = k - a[i];
                        a[i] = 0;
                    } else {
                        for (int j = 0; j < a[i] / 2; j++) {
                            ans.append((char) (97 + i));
                        }
                        k = k - a[i] + 1;
                        a[i] = 1;
                    }
                }
 
            }
 
            StringBuilder x = new StringBuilder(ans.toString());
            ans.reverse();
            if (set == 1) {
                for (int j = 0; j < 26; j++) {
                    if (a[j] >= 1) {
                        x.append((char) (97 + j));
                        set = 0;
                        break;
                    }
                }
            }
            if (k == 0 && set == 0) {
                x.append(ans);
                out.println("YES");
                out.println(x);
            } else {
                out.println("NO");
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