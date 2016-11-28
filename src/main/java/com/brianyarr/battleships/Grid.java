package com.brianyarr.battleships;

public interface Grid {

    boolean isHit(int x, int y);

    default boolean isHit(Point p) {
        return isHit(p.x, p.y);
    }

}
