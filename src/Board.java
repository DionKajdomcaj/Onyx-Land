import javax.swing.*;

public class Board {
    protected Field[][] fields;
    private final int size = 50;
    public Board(){
        fields = new Field[size][size];
        for(int i=0;i<=size;i++){
            for(int j=0;j<=size;j++){
                fields[i][j]=new Field();
            }
        }
    }



}
