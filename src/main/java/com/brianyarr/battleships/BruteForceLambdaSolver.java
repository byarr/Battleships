package com.brianyarr.battleships;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BruteForceLambdaSolver implements Solver {

    @Override
    public Result solve(int n, int b, Grid grid) {
        final List<Point> points = IntStream.range(0, n*n)
                .mapToObj(i -> new Point(i % n, i / n))
                .filter(grid::isHit)
                .limit(b)
                .collect(Collectors.toList());
        return new Result(points.get(0), points.get(points.size()-1));
    }


}
