class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n+1]; 
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>(); 
        }
        for (int[] edge : times) {
            adj[edge[0]].add(new int[] {edge[1], edge[2]}); 
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = -1; 
        distance[k] = 0;


        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (w1, w2) -> distance[w1] - distance[w2]
        );

        pq.offer(k);

        while (!pq.isEmpty()) {

            int node = pq.poll();

            for (int[] u : adj[node]) {
                //v, t

                if (distance[u[0]] > (distance[node] + u[1])) {
                    distance[u[0]] = (distance[node] + u[1]);
                    pq.offer(u[0]);
                }
            }
        }

        //now we have the shortest path propagated, we just need to verify if a solution exists
        int ans = 0;
        for (int i : distance) {
            if (i == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(i, ans);
        }
        return ans;
    }
}
