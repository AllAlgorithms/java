package me.osama;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter Start Grid Config");

        Grid startGrid = new Grid(null, null);

        startGrid.layGrid();
        System.out.println("Start Grid");
        startGrid.printGrid();

        System.out.println("Enter Goal Grid Config");

        GoalGrid goalGrid = GoalGrid.getInstance();
        goalGrid.layGrid();

        System.out.println("Goal Grid");
        goalGrid.printGrid();
        System.out.println(" ----  ----  ----  ----  ----  ----  ----  ---- ");
        startSearch(startGrid);
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


}
