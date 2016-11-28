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
                .collect(Collector.of(MinMax::new, MinMax::accept, MinMax::accept, MinMax::toResult, Collector.Characteristics.UNORDERED));
    }

    private static class MinMax {
        private Point min;
        private Point max;

       public void accept(Point p) {
           if (min == null) {
               min = p;
           } else {
               if (p.compareTo(min) < 0)  {
                   min = p;
               }
           }
           if (max == null) {
               max = p;
           } else if (p.compareTo(max) > 0) {
               max = p;
           }
       }

       public MinMax accept(MinMax other) {
           this.accept(other.min);
           this.accept(other.max);
           return this;
       }

       public Result toResult() {
           return new Result(min, max);
       }

    }


}