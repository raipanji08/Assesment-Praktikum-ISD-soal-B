import java.util.Scanner;

public class Main {

    private static void exploreEurope(boolean useBFS) {
        AdjacencyList adjacencyList = new AdjacencyList();
        
        adjacencyList.addEdge("Paris", "Brussels");
        adjacencyList.addEdge("Paris", "Zurich");

        adjacencyList.addEdge("Brussels", "Amsterdam");
        adjacencyList.addEdge("Brussels", "Paris");
        adjacencyList.addEdge("Brussels", "Zurich");

        adjacencyList.addEdge("Zurich", "Prague");
        adjacencyList.addEdge("Zurich", "Vienna");
        adjacencyList.addEdge("Zurich", "Paris");
        adjacencyList.addEdge("Zurich", "Brussels");

        adjacencyList.addEdge("Amsterdam", "Brussels");
        adjacencyList.addEdge("Amsterdam", "Prague");
        adjacencyList.addEdge("Amsterdam", "Hamburg");

        adjacencyList.addEdge("Prague", "Hamburg");
        adjacencyList.addEdge("Prague", "Amsterdam");
        adjacencyList.addEdge("Prague", "Zurich");
        adjacencyList.addEdge("Prague", "Vienna");
        adjacencyList.addEdge("Prague", "Warsaw");

        adjacencyList.addEdge("Hamburg", "Amsterdam");
        adjacencyList.addEdge("Hamburg", "Warsaw");
        adjacencyList.addEdge("Hamburg", "Prague");

        adjacencyList.addEdge("Vienna", "Prague");
        adjacencyList.addEdge("Vienna", "Zurich");
        adjacencyList.addEdge("Vienna", "Budapest");

        adjacencyList.addEdge("Warsaw", "Hamburg");
        adjacencyList.addEdge("Warsaw", "Budapest");
        adjacencyList.addEdge("Warsaw", "Prague");
        
        adjacencyList.addEdge("Budapest", "Vienna");
        adjacencyList.addEdge("Budapest", "Warsaw");

        

        if (useBFS) {
            BFS bfs = new BFS(adjacencyList);
            System.out.println("BFS dari Paris:");
            bfs.search("Paris");
        } else {
            DFS dfs = new DFS(adjacencyList);
            System.out.println("DFS dari Paris:");
            dfs.search("Paris");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih algoritma untuk mencari urutan kunjungan kota:");
        System.out.println("1. BFS");
        System.out.println("2. DFS");
        int choice = scanner.nextInt();
        scanner.close();

        if (choice == 1) {
            exploreEurope(true);
        } else if (choice == 2) {
            exploreEurope(false);
        } else {
            System.out.println("Pilihan tidak valid. Harap pilih 1 untuk BFS atau 2 untuk DFS.");
        }
    }
}
