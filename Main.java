import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int[] size = new int[]{2,3};
        Matrix matrix = new Matrix(size[0],size[1]);
        for(int a=0;a<size[0];a++)
            for (int b=0;b<size[1];b++)
                matrix.setMatrixElement((int)(random.nextDouble()*10),a,b);
        Matrix matrix1 = new Matrix(size[0], size[1]);
        for(int a=0;a<size[0];a++)
            for (int b=0;b<size[1];b++)
                matrix1.setMatrixElement((int)(random.nextDouble()*10),a,b);
        System.out.println(matrix);
        System.out.println(matrix1);
        matrix1.add(matrix);
        Matrix matrix2 = new Matrix(matrix);
        System.out.println(matrix1.equals(matrix) + " " + matrix.equals(matrix2));

        matrix2 = Matrix.RandomColumn(5);
        System.out.println(matrix2);

        matrix2.multiply(0);
        System.out.println(matrix2);

        MatrixImmutable matrixImmutable = new MatrixImmutable(matrix1);
        matrixImmutable = matrixImmutable.add(new MatrixImmutable(matrix));
        System.out.println(matrixImmutable);
    }
}