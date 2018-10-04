
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author miqdad
 */

class Node{
    int value;
    int index; // represent index of node
    boolean isVisited;
    ArrayList<Node> neighbor;
    
    public Node(int index, int value){
        this.index = index;
        this.value = value;
        this.neighbor = new ArrayList<Node>();
        this.isVisited = false;
    }
    
    public void addNeighbor(Node node){
        this.neighbor.add(node);
    }
}

class Graph{
    int totalNode;
    Node[] nodes;
    
    public Graph(int totalNode){
        this.totalNode = totalNode;
        nodes = new Node[totalNode];
        for(int i=0; i<totalNode; i++){
            int value = (int)(Math.random()*100); // gives random value to node
            nodes[i] = new Node(i, value);
        }
    }
    
    public void addEdge(int s, int d){ // index node
//        add neighbor each other
        nodes[s].addNeighbor(nodes[d]);
        nodes[d].addNeighbor(nodes[s]);
    }
    
    public void initBFS(){
        Node root = nodes[0]; // choose node where bfs start | u can change any index
        Queue<Node> initQueue = new LinkedList<Node>();
        initQueue.add(root);
        BFS(initQueue);
    }
    
    public void BFS(Queue<Node> queue){
        if(queue.isEmpty()){ // check if there is no neighbor
            return;
        }
        Queue<Node> nextQueue = new LinkedList<Node>();
        while(!queue.isEmpty()){
            Node node = queue.poll(); // take neighbor
            if(!nodes[node.index].isVisited){ // check neighbor node is visited or not by his index
                nodes[node.index].isVisited = true; // set visited to true on graph global variable
                System.out.print(node.value + " "); // print the node
                for(Node n : node.neighbor){
                    if(!nodes[n.index].isVisited){ 
                        nextQueue.add(n); // insert every neighbor to nextqueue
                    }
                }
            }
        }
        
        BFS(nextQueue); // recursive visiting node
    }
}

public class BFS {
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
        
        graph.initBFS();
    }
}
