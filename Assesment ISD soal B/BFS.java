import java.util.*;

public class BFS {
    private Queue<String> queue;
    private AdjacencyList adjacencyList;
    private Map<String, Boolean> visited;

    public BFS(AdjacencyList adjacencyList) {
        this.adjacencyList = adjacencyList;
        this.visited = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public void search(String start) {
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (visited.containsKey(current) && visited.get(current)) {
                continue;
            }

            System.out.print(current + " ");
            visited.put(current, true);

            for (String neighbor : adjacencyList.getEdges(current)) {
                if (!visited.getOrDefault(neighbor, false)) {
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}

