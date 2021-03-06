package com.brianyarr.battleships.solvers;

import com.brianyarr.battleships.Grid;
import com.brianyarr.battleships.Point;
import com.brianyarr.battleships.Result;
import com.brianyarr.battleships.Solver;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class RandomSolver implements Solver {

    final Random r = new Random();

    @Override
    public Result solve(int n, int b, Grid grid) {
        Result result = new Result();
        while (result.getSize() < b) {
            int x = r.nextInt(n);
            int y = r.nextInt(n);

            if (grid.isHit(x, y)) {
                result.addPoint(new Point(x, y));
            }
        }
        return result;
    }
}
