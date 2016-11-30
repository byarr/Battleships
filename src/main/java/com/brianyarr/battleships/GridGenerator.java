package com.brianyarr.battleships;

public class GridGenerator {

    GridImpl[] generateCorners(final int n, final int b) {
        if (b == 1) {
            return new GridImpl[]{
                    new GridImpl(n, new Point(0,0), new Point(0, 0)),
                    new GridImpl(n, new Point(0,n-1), new Point(0, n-1)),
                    new GridImpl(n, new Point(n-1,0), new Point(n-1, 0)),
                    new GridImpl(n, new Point(n-1,n-1), new Point(n-1, n-1)),
            };
        }
        else if (b == n) {
            return new GridImpl[]{
                    new GridImpl(n, new Point(0,0), new Point(n, 0)),
                    new GridImpl(n, new Point(0,0), new Point(0, n)),
                    new GridImpl(n, new Point(n-1,0), new Point(n-1, n-1)),
                    new GridImpl(n, new Point(0,n-1), new Point(n-1, n-1)),
            };
        } else {
            throw new IllegalArgumentException();
        }
    }

}
