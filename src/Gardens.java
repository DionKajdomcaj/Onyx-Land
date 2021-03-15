public abstract class Gardens {
    protected int price;
    protected int moodImprovement;
    private final int size=1;
    public Point position;
    public Gardens(int price,int moodImprovement,Point pos){
        this.price=price;
        this.moodImprovement=moodImprovement;

        this.position=new Point(pos);

    }



}
