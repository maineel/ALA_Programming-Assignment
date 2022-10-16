import java.util.*;
import java.util.*;
class ALA_b
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of rows: ");
        int row1=sc.nextInt();              // Input for number of Rows of first matrix
        System.out.println("Enter no. of columns: ");
        int column1=sc.nextInt();           // Input for number of Columns of first matrix
        System.out.println("Enter no. of rows: ");
        int row2=sc.nextInt();              // Input for number of Rows of second matrix
        System.out.println("Enter no. of columns: ");
        int column2=sc.nextInt();           // Input for number of Columns of second matrix
        int[][] matrix1=new int[row1][column1];
        int[][] matrix2=new int[row2][column2];     

        for(int i=0;i<row1;i++)  // Iterating Rows
        {
            for(int j=0;j<column1;j++)  // Iterating Columns
            {
                System.out.printf("Enter number: ");
                matrix1[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<row2;i++)  // Iterating Rows
        {
            for(int j=0;j<column2;j++)  // Iterating Columns
            {
                System.out.printf("Enter number: ");
                matrix2[i][j]=sc.nextInt();
            }
        }

        System.out.println();
        System.out.println();

        Arrays.toString(matrix1);

        System.out.println();
        System.out.println();

        Arrays.toString(matrix2);

        Multiply(matrix1,matrix2,row1,column1,row2,column2);   // Calling multiply function
    }

    public static void Multiply(int matrix1[][],int matrix2[][],int m,int n,int p,int q)
    {
        int matrix3[][];
        if(n!=p)   // If number of columns of first matrix is not equal to number of rows of second matrix multiplication is not possible
        {
            System.out.println("Multiplication not possible");
        }
        else
        {
            matrix3 = new int[m][q];
            for(int i=0;i<m;i++)  // Iterating rows
            {
                for(int j=0;j<q;j++) // Iterating columns
                {
                    matrix3[i][j] = 0; // Initialising the value if ith and jth element of new matrix
                    for(int e=0;e<n;e++)
                    {
                            matrix3[i][j]=matrix3[i][j]+(matrix1[i][e]*matrix2[e][j]);  // Multiplying row of first matrix with column of second matrix
                    }
                    System.out.print(matrix3[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}

/* Test case 1 :

Matrix 1 : 

7 14 15 6 
4 8 12 3
14 21 6 9
13 7 6 4

Matrix 2 :

5 7 14 2
8 16 4 9
13 6 8 4
6 3 2 4

*/

/* Test case 2 :

Matrix 1 :

7 14 15 6 
4 8 12 3
14 21 6 9

Matrix 2:

5 7 14
8 16 4
13 6 8
16 3 2

*/
