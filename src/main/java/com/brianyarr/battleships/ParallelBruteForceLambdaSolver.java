package com.brianyarr.battleships;

import java.util.stream.Collector;
import java.util.stream.IntStream;

public class ParallelBruteForceLambdaSolver implements Solver {

    @Override
    public Result solve(int n, int b, Grid grid) {
        return IntStream.range(0, n * n)
                .unordered()
                .parallel()
                .mapToObj(i -> new Point(i % n, i / n))
                .filter(grid::isHit)
                .limit(b)
                .collect(Result::new, Result::addPoint, Result::addResult);
    }

}