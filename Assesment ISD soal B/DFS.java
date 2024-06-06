import java.util.*;

public class DFS {
    private Stack<String> stack;
    private AdjacencyList adjacencyList;
    private HashMap<String, Boolean> visited;

    public DFS(AdjacencyList adjacencyList) {
        this.adjacencyList = adjacencyList;
        this.visited = new HashMap<>();
        this.stack = new Stack<>();
    }

    public void search(String vertex) {
        stack.push(vertex);

        while (!stack.isEmpty()) {
            String current = stack.pop();

            if (visited.containsKey(current) && visited.get(current)) {
                continue;
            }

            System.out.print(current + " ");
            visited.put(current, true);

            for (String neighbor : adjacencyList.getEdges(current)) {
                if (!visited.getOrDefault(neighbor, false)) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }
}

