public interface IMatrix {
    void setMatrixElement(double number, int row, int column) throws Exception;
    double getMatrixElement(int row, int column);
    String getMatrixRow(int row);
    String getMatrixColumn(int column);
    int[] getMatrixSize();
}
