import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Collections;
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
        DextersAlgorithm solver = new DextersAlgorithm();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class DextersAlgorithm {
        public long pend(long x, int index) {
            StringBuilder y = new StringBuilder("00000000000000000000000000000000000" + Long.toString(x));
            return Long.parseLong(y.substring(y.length() - 4 * (index), y.length() - 4 * (index - 1)));
 
        }
 
        public void store(ArrayList<DextersAlgorithm.node> a, int n, int index) {
            for (int i = 0; i < n; i++) {
                a.get(i).weight = pend(a.get(i).entry, index);
            }
        }
 
        public boolean checker(ArrayList<DextersAlgorithm.node> a, int n) {
            for (int i = 0; i < n; i++) {
                if (a.get(i).weight != 0) {
                    return true;
                }
            }
            return false;
        }
 
        public void printer(ArrayList<DextersAlgorithm.node> a, int n, PrintWriter out) {
            for (int i = 0; i < n; i++) {
                out.print(a.get(i).entry + " ");
            }
            out.println();
        }
 
        public void indi(ArrayList<DextersAlgorithm.node> a, int n) {
            for (int i = 0; i < n; i++) {
                a.get(i).indi = i;
            }
        }
 
        public void sol(ArrayList<DextersAlgorithm.node> a, int index, int n, PrintWriter out) {
            store(a, n, index);
            if (checker(a, n) == true) {
 
                Collections.sort(a, new DextersAlgorithm.sortByWeight());
                printer(a, n, out);
                indi(a, n);
                sol(a, index + 1, n, out);
            }
            return;
 
        }
 
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            ArrayList<DextersAlgorithm.node> a = new ArrayList<DextersAlgorithm.node>();
            for (int i = 0; i < n; i++) {
                a.add(new DextersAlgorithm.node(in.nextLong(), 0, i));
            }
 
            sol(a, 1, n, out);
        }
 
        static class node {
            long entry;
            long weight;
            int indi;
 
            node(long entry, long weight, int indi) {
                this.entry = entry;
                this.weight = weight;
                this.indi = indi;
            }
 
        }
 
        static class sortByWeight implements Comparator<DextersAlgorithm.node> {
            public int compare(DextersAlgorithm.node a, DextersAlgorithm.node b) {
                if (a.weight > b.weight) {
                    return 1;
                }
                if (a.weight < b.weight) {
                    return -1;
                }
                if (a.weight == b.weight) {
                    return a.indi - b.indi;
                }
                return 0;
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
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
    }
}
