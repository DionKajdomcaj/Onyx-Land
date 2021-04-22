import Buildings.Buildings;

import java.util.ArrayList;

public class Matrix {
    ArrayList<ArrayList<Buildings>> stateMatrix;

    public Matrix() {
        fillMatrix();
    }

    private void fillMatrix() {
        for (int i = 0; i < 20; i++) {
            ArrayList<Buildings> row = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                row.add(null);
            }
            stateMatrix.add(row);
        }
    }
    private void addToTheGrid(Buildings b) {

    }


}
