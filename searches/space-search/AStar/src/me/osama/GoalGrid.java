package me.osama;

/**
 * Created by OsamaRao on 12-Mar-16.
 */
public class GoalGrid extends BaseGrid{
    private static GoalGrid goalGrid;

    private GoalGrid(){

    }

    public static GoalGrid getInstance(){
        if(goalGrid == null) {
            goalGrid = new GoalGrid();
        }
        return goalGrid;
    }

    @Override
    public Grid applyAction(Grid grid, Action action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int manhattanDistance() {
        return 0;
    }
}
