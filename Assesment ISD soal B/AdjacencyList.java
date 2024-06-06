import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdjacencyList {
    private Map<String, List<String>> adjacencyList;

    public AdjacencyList() {
        this.adjacencyList = new HashMap<>();
    }

    private void addVertex(String vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void addEdge(String source, String destination) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }

        adjacencyList.get(source).add(destination);
    }

    public void removeVertex(String vertex) {
        if (this.adjacencyList.containsKey(vertex)) {
            this.adjacencyList.remove(vertex);
            for (String key : this.adjacencyList.keySet()) {
                List<String> edges = this.adjacencyList.get(key);
                edges.remove(vertex);
                this.adjacencyList.put(key, edges);
            }
        }
    }

    public void removeEdge(String vertex1, String vertex2) {
        if (this.adjacencyList.containsKey(vertex1) && this.adjacencyList.containsKey(vertex2)) {
            List<String> edges = this.adjacencyList.get(vertex1);
            edges.remove(vertex2);
            this.adjacencyList.put(vertex1, edges);
        }
    }

    public List<String> getEdges(String vertex) {
        return this.adjacencyList.get(vertex);
    }

    public Map<String, List<String>> getAdjacencyList() {
        return this.adjacencyList;
    }

    public void printAdjacencyList() {
        for (String key : this.adjacencyList.keySet()) {
            System.out.print(key + " -> ");
            List<String> edges = this.adjacencyList.get(key);
            for (String edge : edges) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
}