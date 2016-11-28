package com.brianyarr.battleships;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

//@RunWith(Parameterized.class)
public class SolverTest {

    Solver solver;

    @Before
    public void init() {
        solver = new ParallelBruteForceLambdaSolver();
    }


    @Test
    public void testWorks() {
        final int n = 100;
        final Point p1 = new Point(99, 99);
        final Point p2 = new Point(99, 99);
        final GridImpl grid = new GridImpl(n, p1, p2);

        final Result result = solver.solve(n, 1, grid);
        assertEquals(p1, result.p1);
        assertEquals(p2, result.p2);
    }

}