package com.brianyarr.battleships;

public class GridImpl implements Grid {

    private final int n;
    private final Point p1;
    private final Point p2;

    public GridImpl(int n, final Point p1, final Point p2) {
        this.n = n;
        if (p1.compareTo(p2) < 0) {
            this.p1 = p1;
            this.p2 = p2;
        } else {
            this.p2 = p1;
            this.p1 = p2;
        }
    }

    @Override
    public boolean isHit(int x, int y) {
        return x >= p1.x && x <= p2.x && y >= p1.y && y <= p2.y;
    }


}
