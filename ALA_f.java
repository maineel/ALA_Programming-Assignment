import java.util.*;
public class ALA_f {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of rows: ");
        int row1=sc.nextInt();             
        System.out.println("Enter no. of columns: ");
        int column1=sc.nextInt();           
        double[][] arr = new double[row1][column1];
        for(int i=0;i<row1;i++)  // Iterating Rows
        {
            for(int j=0;j<column1;j++)  // Iterating Columns
            {
                System.out.printf("Enter number: ");
                arr[i][j]=sc.nextInt();
            }
        }
        print(arr);
        rowreducedEchelon(arr);
        System.out.println();
        System.out.println();
        System.out.println("Reduced row echloen form: ");
        print(arr);
    }
    static void print(double[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static double[][] rowreducedEchelon(double[][] M){
        try {
            double[][] mtx = M;
            int rows = mtx.length;
            int columns = mtx[0].length;
            int lead = 0;
            for(int r = 0; r < rows; r++){
                if(columns <= lead){
                    return null;
                }
                int i = r;
                while (mtx[i][lead] == 0){
                    i++;
                    if(rows == i){
                        i++;
                        if(rows == i){
                            i = r;
                            lead++;
                            if(columns == lead){
                                return null;
                            }
                        }
                    }
                }
                double[] temp = mtx[i];
                mtx[i] = mtx[r];
                mtx[r] = temp;

                double val = mtx[r][lead];
                for (int j = 0; j < columns; j++) {
                    mtx[r][j] /= val; //this for loop makes the pivot element 1.0.
                }
                for (int j = 0; j < rows; j++) {
                    if(j == r){
                        continue;
                    }else{
                        val = mtx[j][lead];
                        for (int k = 0; k < columns; k++) {
                            mtx[j][k] -= val * mtx[r][k]; // this for loop makes all element except pivot element 0;
                        }
                    }
                }
                lead++;
            }
            return mtx;
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
}


/* Test Case:1
4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
*/

/* Test Case:2
5 5
1 0 2 0 3
0 4 0 5 0
6 0 7 0 8
0 9 0 10 0
11 0 12 0 13
*/
