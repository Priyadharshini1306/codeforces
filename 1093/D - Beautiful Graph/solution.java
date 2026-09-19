import java.io.*;
import java.util.*;
 
public class Main {
 
    static final long MOD = 998244353L;
 
    static ArrayList<Integer>[] graph;
    static int[] color;
 
    static long power(long a, int b) {
        long result = 1;
 
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }
 
            a = (a * a) % MOD;
            b >>= 1;
        }
 
        return result;
    }
 
    static long solveComponent(int start) {
 
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
 
        color[start] = 0;
 
        int count0 = 1;
        int count1 = 0;
 
        while (!q.isEmpty()) {
 
            int u = q.poll();
 
            for (int v : graph[u]) {
 
                if (color[v] == -1) {
 
                    color[v] = 1 - color[u];
 
                    if (color[v] == 0) {
                        count0++;
                    } else {
                        count1++;
                    }
 
                    q.offer(v);
 
                } else if (color[v] == color[u]) {
 
                    // Same color connected by an edge
                    // => graph is not bipartite
                    return -1;
                }
            }
        }
 
        long ways0 = power(2, count0);
        long ways1 = power(2, count1);
 
        return (ways0 + ways1) % MOD;
    }
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
 
        StringBuilder output = new StringBuilder();
 
        while (t-- > 0) {
 
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
 
            graph = new ArrayList[n];
 
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
 
            for (int i = 0; i < m; i++) {
 
                st = new StringTokenizer(br.readLine());
 
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
 
                graph[u].add(v);
                graph[v].add(u);
            }
 
            color = new int[n];
            Arrays.fill(color, -1);
 
            long answer = 1;
            boolean possible = true;
 
            for (int i = 0; i < n; i++) {
 
                if (color[i] == -1) {
 
                    long ways = solveComponent(i);
 
                    if (ways == -1) {
                        possible = false;
                        break;
                    }
 
                    answer = (answer * ways) % MOD;
                }
            }
 
            if (!possible) {
                output.append(0).append('
');
            } else {
                output.append(answer).append('
');
            }
        }
 
        System.out.print(output);
    }
}