import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FilterInputStream;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;
 
/**
 * @author Jenish
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BokuNoHeroAcademia solver = new BokuNoHeroAcademia();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class BokuNoHeroAcademia {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int q = in.scanInt();
            int a[] = new int[n];
            int b[] = new int[n];
            in.scanInt(a);
            in.scanInt(b);
            HashMap<Long, ArrayList<pair>> hashMap = new HashMap<>();
            for (int A : a) {
                for (int B : b) {
                    long gcd = CodeX.GCD(A, B);
                    if (gcd == 0) continue;
                    long aaA = A / gcd;
                    long bbB = B / gcd;
                    long hsh = CodeX.compute_hash(aaA, bbB);
                    if (!hashMap.containsKey(hsh)) hashMap.put(hsh, new ArrayList<>());
                    hashMap.get(hsh).add(new pair(A, B));
                }
            }
 
            for (ArrayList<pair> kk : hashMap.values()) {
                Collections.sort(kk, new Comparator<pair>() {
 
                    public int compare(pair o1, pair o2) {
                        if (o1.a == o2.a) return Integer.compare(o1.b, o2.b);
                        return Integer.compare(o1.a, o2.a);
                    }
                });
            }
 
 
            while (q-- > 0) {
                int c = in.scanInt();
                int d = in.scanInt();
                int k = in.scanInt();
                long gcd = CodeX.GCD(c, d);
                long cc = c / gcd;
                long dd = d / gcd;
                long hsh = CodeX.compute_hash(cc, dd);
                if (hashMap.containsKey(hsh)) {
                    if (k <= hashMap.get(hsh).size()) {
                        pair pp = hashMap.get(hsh).get(k - 1);
                        out.println(pp.a + " " + pp.b);
                    } else {
                        out.println("NIE");
                    }
                } else {
                    out.println("NIE");
                }
            }
 
 
        }
 
        class pair {
            int a;
            int b;
 
            public pair(int a, int b) {
                this.a = a;
                this.b = b;
            }
 
        }
 
    }
 
    static class CodeX {
        public static int GCD(int A, int B) {
 
            if (A == 0) return B;
            if (B == 0)
                return A;
            else
                return GCD(B, A % B);
        }
 
        public static long compute_hash(long a, long b) {
            long temp = a * 1456973978l;
            if (temp >= 8008808808808813l) temp -= 8008808808808813l;
            long t2 = (b * 234792734l);
            if (t2 >= 8008808808808813l) t2 -= 8008808808808813l;
            temp = temp + t2;
            if (temp >= 8008808808808813l) temp -= 8008808808808813l;
            return temp;
        }
 
    }
 
    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;
 
        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }
 
        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }
 
        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }
 
        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }
 
        public void scanInt(int[] A) {
            for (int i = 0; i < A.length; i++) A[i] = scanInt();
        }
 
    }
}