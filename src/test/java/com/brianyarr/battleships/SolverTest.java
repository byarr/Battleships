package com.brianyarr.battleships;

import com.brianyarr.battleships.solvers.BruteForceLambdaSolver;
import com.brianyarr.battleships.solvers.BruteForceSolver;
import com.brianyarr.battleships.solvers.ParallelBruteForceLambdaSolver;
import com.brianyarr.battleships.solvers.RandomSolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolverTest {

    @Parameterized.Parameters(name = "{0}")
    public static Object[] data() {
        return new Object[] { new BruteForceSolver(), new BruteForceLambdaSolver(), new ParallelBruteForceLambdaSolver(), new RandomSolver() };
    }

    @Parameterized.Parameter
    public Solver solver;

    @Test
    public void testCornersWorks() {
        final int n = 100;
        final GridGenerator gridGenerator = new GridGenerator();

        final GridImpl[] grids = gridGenerator.generateCorners(n, 1);
        for(GridImpl g : grids) {
            final Result result = solver.solve(n, 1, g);
            assertEquals(g.getResult(), result);
        }

    }

}