package me.osama;

/**
 * Created by Osama Rao on 17-Feb-16.
 */
public class Node implements INode, Comparable<INode> {
    Node parent;
    BaseGrid grid;


    public Node(BaseGrid fromGrid) {
        grid = fromGrid;
    }


    @Override
    public void call() {
        System.out.println(getF());
    }

    @Override
    public int getF() {
        return 1 + grid.manhattanDistance(); // cost of next state plus the Manhattan Distance of the next State
    }

    @Override
    public Node nextState(Action action) {
        Node node = new Node(grid.applyAction((Grid) grid, action));
        node.parent = this;
        return node;
    }

    @Override
    public int compareTo(INode o) {
        if (getF() > o.getF()) {
            return 1;
        } else if (getF() < o.getF()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object another) {
        Node node = (Node) another;
        return this.grid.manhattanDistance() == node.grid.manhattanDistance();
    }



    @Override
    public int hashCode() {
        int result = parent != null ? parent.hashCode() : 0;
        result = 31 * result + (grid != null ? grid.hashCode() : 0);
        return result;
    }


    public static void printPath(Node node) {
        if (node.parent != null){

//            System.out.println(" /\\");
//            System.out.println("  | ");
//            System.out.println("  | ");

            printPath(node.parent);
            node.grid.printGrid();
        } else {
            node.grid.printGrid();
        }
    }

}
