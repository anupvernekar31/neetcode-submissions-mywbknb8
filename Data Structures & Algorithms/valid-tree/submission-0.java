class Solution {

    // =======================================================================
    // A graph is a tree ⇔ it is connected and has exactly n - 1 edges. 
    //                                 OR 
    // A graph is a tree ⇔ it is connected and has no cycle.
    // u can simply check if graph has n-1 edges and connected for this problem!!
    // =======================================================================

    public boolean validTree(int n, int[][] edges) {

    List<List<Integer>> graph = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add undirected edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // If a cycle exists, it is not a tree
        if (hasCycle(0, -1, graph, visited)) {
            return false;
        }

        // If any node is not visited, graph is disconnected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(
            int node,
            int parent,
            List<List<Integer>> graph,
            boolean[] visited
    ) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, node, graph, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // Reached a previously visited node that is not the parent
                return true;
            }
        }

        return false;
    }
}
