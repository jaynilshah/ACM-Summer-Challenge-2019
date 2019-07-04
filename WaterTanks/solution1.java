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
            WaterTanks solver = new WaterTanks();
            solver.solve(1, in, out);
            out.close();
        }
     
        static class WaterTanks {
            public void solve(int testNumber, InputReader in, PrintWriter out) {
     
                int n = in.nextInt();
                long k = in.nextLong();
                int a[] = new int[n];
                int postMax[] = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }
                postMax[n - 1] = -1;
                for (int i = n - 2; i >= 0; i--) {
                    postMax[i] = Math.max(postMax[i + 1], a[i + 1]);
                }
                long max = 0;
                for (int i = 0; i < n - 1; i++) {
                    max = Math.max(k * (postMax[i] - a[i]), max);
                }
                out.println(max);
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
     
            public long nextLong() {
                return Long.parseLong(next());
            }
     
        }
    }
