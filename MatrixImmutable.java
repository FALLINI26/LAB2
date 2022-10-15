import java.util.Arrays;

public class MatrixImmutable implements IMatrix{
    private final double[][] qwerty;

    public MatrixImmutable(){
        qwerty = new double[0][0];
    }

    public MatrixImmutable(int a, int b){
        qwerty = new double[a][b];
    }

    public MatrixImmutable(Matrix another){
        qwerty = new double[another.getMatrixSize()[0]][another.getMatrixSize()[1]];
        for (int i=0;i<qwerty.length;i++)
            for (int j=0; j<qwerty[0].length; j++) {
                qwerty[i][j] = another.getMatrixElement(i,j);
            }
    }

    public MatrixImmutable(MatrixImmutable another){
        qwerty = another.qwerty.clone();
    }


    @Override
    public void setMatrixElement(double number, int row, int column) throws Exception {
        throw new Exception("Immutable matrix can`t change");
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
        if (!(o instanceof MatrixImmutable)) return false;
        MatrixImmutable that = (MatrixImmutable) o;
        return Arrays.deepEquals(qwerty, that.qwerty);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(qwerty);
    }

    public MatrixImmutable add(MatrixImmutable another) throws Exception {
        MatrixImmutable newMatrix = new MatrixImmutable(this);
        if(!Arrays.equals(getMatrixSize(), another.getMatrixSize())) throw new Exception("Different sizes");
        for (int a=0;a<qwerty.length;a++)
            for (int b=0;b<qwerty[0].length;b++)
                newMatrix.qwerty[a][b]+=another.qwerty[a][b];
        return newMatrix;
    }

    public MatrixImmutable multiply(double num){
        MatrixImmutable newMatrix = new MatrixImmutable(this);
        for (int a=0;a<qwerty.length;a++)
            for (int b=0;b<qwerty[0].length;b++)
                newMatrix.qwerty[a][b]*=num;
        return newMatrix;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int a=0;a<qwerty.length;a++)
            stringBuilder.append(getMatrixRow(a)).append("\n");
        return String.valueOf(stringBuilder);
    }
}
