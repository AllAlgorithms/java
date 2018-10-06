package me.osama;

/**
 * Created by OsamaRao on 16-Mar-16.
 */
public class Dummy {
    /*


    public static void main(String[] args) {
        // write your code here
//        System.out.println("Start Grid");
        Grid startGrid = new Grid(null, null);
//        int[] startTiles = new int[]{ 8,7,6,5,4,3,2,1,0 };
        int[] startTiles0 = new int[]{ 5,2,4,1,0,3,8,7,6 };

        int[] startTilesA = new int[]{ 1,3,0,8,2,4,7,6,5 };

        int[] startTilesB = new int[]{ 1,3,4,8,6,2,0,7,5 };

        int[] startTilesC = new int[]{ 0,1,3,4,2,5,8,7,6 };

        int[] startTilesD = new int[]{ 7,1,2,8,0,3,6,5,4 };

        int[] startTilesE = new int[]{ 8,1,2,7,0,4,6,5,3 };

        int[] startTilesF = new int[]{ 2,6,3,4,0,5,1,8,7 };

        int[] startTilesG = new int[]{ 7,3,4,6,1,5,8,0,2 };

        int[] startTilesH = new int[]{ 7,4,5,6,0,3,8,1,2 };

//        int[] startTiles = new int[]{ 3,2,1,6,0,8,4,5,7 };
//        startGrid.layGrid();

//        startGrid.printGrid();
//
//        System.out.println("Goal Grid");
        GoalGrid goalGrid = GoalGrid.getInstance();
//        goalGrid.layGrid(new int[]{ 5,2,4,1,7,3,8,6,0 });



        // That site's goal state

        startGrid.layGrid(startTilesC);
        goalGrid.layGrid(new int[]{ 1,2,3,8,0,4,7,6,5 });

        startSearch(startGrid);

//        goalGrid.layGrid(new int[]{ 3,2,1,4,0,8,5,6,7 });
//        goalGrid.layGrid(new int[]{ 2,1,0,3,4,5,8,7,6 });
//        goalGrid.layGrid();
//        System.out.println("Goal Grid");
//        goalGrid.printGrid();
//        startGrid.printGrid();
//        System.out.println(goalGrid.manhattanDistance());
//
//        System.out.println(startGrid.manhattanDistance());

        // PriorityQueue<Node> frontier = new PriorityQueue<>();

//        frontier.add(startState.nextState(Action.UP, 950));
//        frontier.add(startState.nextState(Action.UP, 490));
//        frontier.add(startState.nextState(Action.UP, 910));
//        frontier.add(startState.nextState(Action.UP, 930));
//
//        frontier.poll().call();
//        frontier.poll().call();
//        frontier.poll().call();
//        frontier.poll().call();
//        Node node = new Node(startGrid);
//            Node selectNode = null;
//        for (Action action : Action.values()) {
////            System.out.println(action);
//            Node childNode = node.nextState(action);
////            childNode.grid.printGrid();
////            System.out.println("f(n) = " + childNode.getF());
//            int f = 1000000;
//            if (childNode.getF() < f)
//                selectNode = childNode;
////            if (childNode.grid != null) {
////                if (!explored.contains(childNode) || !frontier.contains(childNode)) {
////                    frontier.add(childNode);
////                } else if (frontier.contains(childNode)) {
////                    frontier.removeIf(new LowerChildPredicate(childNode));
////                    frontier.add(childNode);
////                }
////            }
//        }
//        System.out.println(selectNode.grid.zeroPosition);
//        selectNode.grid.printGrid();
//
//        System.out.println("node selected");
//        System.out.println("applying moves to selected node");
//
//        Node selectedNodeCopy = new Node(selectNode.grid);
//        System.out.println("selectednodecopy zeroposition " + selectedNodeCopy.grid.zeroPosition);
//        for (Action action : Action.values()) {
//            System.out.println(action);
//            Node childNode = selectedNodeCopy.nextState(action);
//            if (childNode.grid != null){
//                System.out.println("After Applied...");
//                childNode.grid.printGrid();
//                int f = 1000000;
//                if (childNode.getF() < f)
//                    selectNode = childNode;
//            } else {
//                System.out.println("Illegal Move");
//            }
//
//
//        }
//        System.out.println(selectNode.grid.zeroPosition);
//        selectNode.grid.printGrid();
    }

    private static void startSearch(Grid startGrid) {
        AStarSearch aStarSearch = new AStarSearch(new Node(startGrid));
        boolean searchStatus = aStarSearch.search();
        if (searchStatus){

            aStarSearch.printPath();
            System.out.println("Search Complete");
        } else {
            System.out.println("Search Failed");
        }
    }



     */
}
