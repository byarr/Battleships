package com.brianyarr.battleships;

public class Result {

    public Point p1;
    public Point p2;

    public Result() {

    }

    public Result(Point p1, Point p2) {
        if (p1.compareTo(p2) < 0) {
            this.p1 = p1;
            this.p2 = p2;
        } else {
            this.p1 = p2;
            this.p2 = p1;
        }
    }

    public void addPoint(Point p) {
        if (p1 == null || p.compareTo(p1) < -1) {
            p1 = p;
        }
        if (p2 == null || p.compareTo(p2) > 1) {
            p2 = p;
        }
    }

    public void addResult(Result result) {
        addPoint(result.p1);
        addPoint(result.p2);
    }

    public int getSize() {
        if (p1 == null || p2 == null) {
            return 0;
        }
        return Math.max(p2.x - p1.x, p2.y - p1.y) + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (p1 != null ? !p1.equals(result.p1) : result.p1 != null) return false;
        return p2 != null ? p2.equals(result.p2) : result.p2 == null;

    }

    @Override
    public int hashCode() {
        int result = p1 != null ? p1.hashCode() : 0;
        result = 31 * result + (p2 != null ? p2.hashCode() : 0);
        return result;
    }
}

