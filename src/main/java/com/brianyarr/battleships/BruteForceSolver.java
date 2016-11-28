package com.brianyarr.battleships;

public class BruteForceSolver implements Solver {

    @Override
    public Result solve(int n, int b, Grid grid) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.isHit(i, j)) {
                    final Point p1 = new Point(i, j);
                    if (grid.isHit(i+b-1, j)) {
                        return new Result(p1, new Point(i+b-1, j));
                    } else {
                        return new Result(p1, new Point(i, j+b-1));
                    }
                }
            }
        }
        return null;
    }

}
