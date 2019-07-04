import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Deque;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.io.BufferedReader;
import java.util.LinkedList;
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
        UltraInstinct solver = new UltraInstinct();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class UltraInstinct {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int a[] = new int[n + 1];
            int ans[] = new int[n + 1];
            int size[] = new int[n + 1];
            ArrayList<Integer> list[] = new ArrayList[n + 1];
            ArrayList<Integer> temp[] = new ArrayList[n + 1];
            node no[] = new node[n - 1];
            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();
                list[i] = new ArrayList<>();
                temp[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                if (u == 1 || v == 1) {
                    size[1]++;
                }
                temp[u].add(v);
                temp[v].add(u);
            }
            Queue<Integer> q = new LinkedList<>();
            int qsize = 0;
            int dsize = 0;
            TreeSet<Integer> ts = new TreeSet<>();
            Deque<Integer> dq = new LinkedList<Integer>();
 
            ts.add(1);
            dq.add(1);
            dsize++;
            for (int i = 0; i < size[1]; i++) {
                q.add(temp[1].get(i));
                dq.addLast(temp[1].get(i));
                dsize++;
                ts.add(temp[1].get(i));
                list[1].add(temp[1].get(i));
                qsize++;
            }
 
            while (qsize > 0) {
                int front = q.poll();
                qsize--;
                for (int i = 0; i < temp[front].size(); i++) {
                    if (!ts.contains(temp[front].get(i))) {
                        q.add(temp[front].get(i));
                        qsize++;
                        dq.addLast(temp[front].get(i));
                        dsize++;
                        list[front].add(temp[front].get(i));
                        size[front]++;
                        ts.add(temp[front].get(i));
                    }
                }
            }
 
 
//        Array.print(size);
            for (int i = 0; i < dsize; i++) {
                int last = dq.removeLast();
 
                if (a[last] == -1) {
                    ans[last]++;
                }
                for (int j = 0; j < size[last]; j++) {
                    ans[last] += ans[list[last].get(j)];
                }
            }
//        Array.print(ans);
 
            for (int i = 1; i <= n; i++) {
                out.print(ans[i] + " ");
            }
 
 
        }
 
        class node {
            int u;
            int v;
 
            node(int u, int v) {
                this.u = Math.min(u, v);
                this.v = Math.max(u, v);
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
