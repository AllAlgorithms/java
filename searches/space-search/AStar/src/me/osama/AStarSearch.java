package me.osama;

import java.util.PriorityQueue;
import java.util.function.Predicate;

/**
 * Created by OsamaRao on 12-Mar-16.
 */
public class AStarSearch implements Search, PrintPath {

    private final Node startNode;
    private final Node goalNode;
    private PriorityQueue<Node> frontier = new PriorityQueue<Node>();
    private PriorityQueue<Node> explored = new PriorityQueue<Node>();


    public AStarSearch(Node startNode) {
        this.startNode = startNode;
        goalNode = new Node(GoalGrid.getInstance());
    }

    @Override
    public boolean search() {
        frontier.add(startNode);

        while (true) {
            if (frontier.isEmpty())
                return false;

            Node node = frontier.poll();

            if (node.equals(goalNode)) {
                explored.add(node);
//                node.grid.printGrid();
                return true;
            }

            explored.add(node);

            for (Action action : Action.values()) {

                Node childNode = node.nextState(action);
                if (childNode.grid != null) {
                    if (!explored.contains(childNode) || !frontier.contains(childNode)) {
                        frontier.add(childNode);
                    } else if (frontier.contains(childNode)) {
                        //frontier.removeIf(new LowerChildPredicate(childNode));
                        for (Node someNode : frontier) {
                            if (childNode.equals(someNode)) {
                               if ( childNode.getF() < someNode.getF() ){
                                    frontier.remove(someNode);
                               }
                            }
                        }
                        frontier.add(childNode);
                    }
                }
            }

            //node.grid.printGrid();
        }
    }

    @Override
    public void printPath(Node node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void printPath() {
        Node.printPath(explored.poll());
    }

    private class LowerChildPredicate implements Predicate<Node> {

        private Node childNode;

        public LowerChildPredicate(Node childNode) {

            this.childNode = childNode;
        }

        @Override
        public boolean test(Node nodeInFrontier) {
            if (childNode.equals(nodeInFrontier)) {
                return childNode.getF() < nodeInFrontier.getF();
            }
            return false;
        }
    }
}
