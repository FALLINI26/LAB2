import java.util.Arrays;
import java.util.Random;

public class Matrix implements IMatrix{
    private final double[][] qwerty;

    public Matrix(){
        qwerty = new double[0][0];
    }

    public Matrix(int a, int b){
        qwerty = new double[a][b];
    }

    public Matrix(Matrix another){
        qwerty = another.qwerty.clone();
    }


    @Override
    public void setMatrixElement(double number, int row, int column) {
        qwerty[row][column] = number;
    }

    @Override
    public double getMatrixElement(int row, int column) {
        return qwerty[row][column];
    }

    @Override
    public String getMatrixRow(int row) {
        StringBuilder rowString = new StringBuilder();
        for (double num: qwerty[row]) {
            rowString.append(num).append(", ");
        }
        rowString.delete(rowString.length()-2,rowString.length());
        return String.valueOf(rowString);
    }

    @Override
    public String getMatrixColumn(int column) {
        StringBuilder columnString = new StringBuilder();
        for (double[] num: qwerty) {
            columnString.append(num[column]).append("\n");
        }
        columnString.delete(columnString.length()-1,columnString.length());
        return String.valueOf(columnString);
    }

    @Override
    public int[] getMatrixSize() {
        return new int[]{qwerty.length,qwerty[0].length};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.deepEquals(qwerty, matrix.qwerty);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(qwerty);
    }

    public  static Matrix RandomColumn(int a){
        Matrix column = new Matrix(a,1);
        Random random = new Random();
        for (int i = 0; i<a; i++){
            column.qwerty[i][0] = (int)(random.nextDouble()*10);
        }
        return column;
    }

    public void add(Matrix another) throws Exception {
        if(!Arrays.equals(getMatrixSize(), another.getMatrixSize())) throw new Exception("Different sizes");
        for (int a=0;a<qwerty.length;a++)
            for (int b=0;b<qwerty[0].length;b++)
                qwerty[a][b]+=another.qwerty[a][b];
    }

    public void multiply(double num){
        for (int a=0;a<qwerty.length;a++)
            for (int b=0;b<qwerty[0].length;b++)
                qwerty[a][b]*=num;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int a=0;a<qwerty.length;a++)
            stringBuilder.append(getMatrixRow(a)).append("\n");
        return String.valueOf(stringBuilder);
    }
}