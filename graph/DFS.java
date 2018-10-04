
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author miqdad
 */
class Node {

    int value;
    int index; // represent index of node
    boolean isVisited;
    ArrayList<Node> neighbor;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
        this.neighbor = new ArrayList<Node>();
        this.isVisited = false;
    }

    public void addNeighbor(Node node) {
        this.neighbor.add(node);
    }
}

class Graph {

    int totalNode;
    Node[] nodes;

    public Graph(int totalNode) {
        this.totalNode = totalNode;
        nodes = new Node[totalNode];
        for (int i = 0; i < totalNode; i++) {
            int value = (int) (Math.random() * 100); // gives random value to node
            nodes[i] = new Node(i, value);
        }
    }

    public void addEdge(int s, int d) { // index node
//        add neighbor each other
        nodes[s].addNeighbor(nodes[d]);
        nodes[d].addNeighbor(nodes[s]);
    }

    public void initDFS() {
        Node root = nodes[0];
        DFS(root);
    }

    public void DFS(Node node) {
        if (!nodes[node.index].isVisited) {
            System.out.print(node.value + " ");
            node.isVisited = true;
        }
        for (Node n : node.neighbor) {
            if(!n.isVisited){
                DFS(n);
            }
        }

    }
}

public class DFS {
    public static void main(String[] args){
        Graph graph = new Graph(10); // 10 nodes in this graph
        for(Node n : graph.nodes){
            System.out.printf("Node index %d has value %d\n", n.index, n.value);
        }
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 6);
        graph.addEdge(2, 7);
        graph.addEdge(3, 8);
        graph.addEdge(3, 9);
        graph.addEdge(1, 7);
        
        graph.initDFS();
        System.out.println("");
    }
}
