public class Path {
    private int price;
    private final int size=1;
    public Point position;
    public Path(int price,Point pos){
        this.price=price;
        this.position = new Point(pos);
    }
}
