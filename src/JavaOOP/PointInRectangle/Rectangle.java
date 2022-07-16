package JavaOOP.PointInRectangle;

public class Rectangle {

    private int bottomLeftX;
    private int bottomLeftY;
    private int topRightX;
    private int topRightY;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
        this.topRightX = topRightX;
        this.topRightY = topRightY;
}

    public boolean contains1(Point point) {
        return (point.getX() >= getBottomLeftX() && point.getX() <= getTopRightX())
                && (point.getY() >= getBottomLeftY() && point.getY() >= getTopRightY());
    }

    public int getBottomLeftX() {
        return bottomLeftX;
    }

    public int getBottomLeftY() {
        return bottomLeftY;
    }

    public int getTopRightX() {
        return topRightX;
    }

    public int getTopRightY() {
        return topRightY;
    }
}
