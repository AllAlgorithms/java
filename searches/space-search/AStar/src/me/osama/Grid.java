package me.osama;

import java.util.HashMap;

/**
 * Created by Osama Rao on 12-Mar-16.
 */
public class Grid extends BaseGrid {

    public Grid(Grid grid) {
        this(grid.gridMap, grid.zeroPosition);
    }

    public Grid(HashMap<Position, Integer> gridMap, Position zeroPosition) {
        this.zeroPosition = zeroPosition;
        if (gridMap != null)
            this.gridMap = new HashMap<Position, Integer>(gridMap);
    }

    @Override
    public Grid applyAction(Grid grid, Action action) {
        int newX, newY;
        switch (action) {
            case UP:
                // add 1 to x
                // calculate new position
                newX = grid.zeroPosition.getX() + 1;
                if (!isLegalMove(newX)) {
                    return null; // invalid move
                } else {
                    Grid grid1 = new Grid(this);
//                    System.out.println("applying " + action);
//                    grid.printGrid();
                    swapZero(grid1, new Position(newX, grid1.zeroPosition.getY()));
                    return grid1;
                }
            case DOWN:
                // subtract 1 from x
                // calculate new position
                newX = grid.zeroPosition.getX() - 1;
                if (!isLegalMove(newX)) {
                    return null; // invalid move
                } else {
                    Grid grid1 = new Grid(this);
//                    System.out.println("applying " + action);
//                    grid.printGrid();
                    swapZero(grid1, new Position(newX, grid1.zeroPosition.getY()));
                    return grid1;
                }
            case RIGHT:
                newY = grid.zeroPosition.getY() + 1;
                if (!isLegalMove(newY)) {
                    return null; // invalid move
                } else {
                    Grid grid1 = new Grid(this);
//                    System.out.println("applying " + action);
//                    grid.printGrid();
                    swapZero(grid1, new Position(grid1.zeroPosition.getX(), newY));
                    return grid1;
                }
            case LEFT:
                newY = grid.zeroPosition.getY() - 1;
                if (!isLegalMove(newY)) {
                    return null; // invalid move
                } else {
                    Grid grid1 = new Grid(this);
//                    System.out.println("applying " + action);
//                    grid.printGrid();
                    swapZero(grid1, new Position(grid1.zeroPosition.getX(), newY));
                    return grid1;
                }
            default:
                return null;
        }
    }

    private boolean isLegalMove(int value) {
        return value <= 2 && value >= 0;
    }

    private void swapZero(Grid grid, Position toPosition) {
//        System.out.println("Before Swap");
//        System.out.println("tileAtToPosition " + toPosition);
//        System.out.println("zeroPosition " + grid.zeroPosition);
        Integer tileAtToPosition = grid.gridMap.get(toPosition);
        grid.gridMap.put(toPosition, grid.gridMap.get(grid.zeroPosition));
        grid.gridMap.put(grid.zeroPosition, tileAtToPosition);
        grid.zeroPosition = toPosition;
//        System.out.println("After Swap");
//        System.out.println("tileAtToPosition " + toPosition);
//        System.out.println("zeroPosition " + grid.zeroPosition);
    }


    @Override
    public int manhattanDistance() {
        int manhattanDistance = 0;
        for (int i = 0; i < 9; i++) {
            // Find tile in current gridMap
            Position tilePositionOnCurrentGrid = findTile(i, gridMap);
            // Find tile in goal gridMap
            Position tilePositionOnGoalGrid = findTile(i, GoalGrid.getInstance().gridMap);
            // Calculate difference
            manhattanDistance += calculateAbsoluteDifference(tilePositionOnCurrentGrid, tilePositionOnGoalGrid);
        }
        return manhattanDistance;
    }

    private int calculateAbsoluteDifference(Position tilePositionOnCurrentGrid, Position tilePositionOnGoalGrid) {
        return Math.abs((tilePositionOnCurrentGrid.getX() - tilePositionOnGoalGrid.getX())) + Math.abs((tilePositionOnCurrentGrid.getY() - tilePositionOnGoalGrid.getY()));
    }

    private Position findTile(int tile, HashMap<Position, Integer> gridMap) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (gridMap.get(new Position(x, y)) == tile) {
                    return new Position(x, y);
                }
            }
        }
        return null;
    }


}
