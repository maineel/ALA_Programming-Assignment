import java.util.*;
class ALA_a
{
    static int N=4;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int r=sc.nextInt();
        System.out.println("Enter number of columns: ");
        int c=sc.nextInt();
        double arr[][]=new double[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.printf("Enter number: ");
                arr[i][j]=sc.nextDouble();
            }
        }
        print(arr);
        System.out.println();
        System.out.println();
        boolean b=inverse(arr,r,c);
    }
    static void print(double[][] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void getCofactor(double arr[][], double arr1[][], int m, int n, int p)
    {
        int i = 0, j = 0;
     
        for (int row = 0; row < p; row++)  // Iterationg row
        {
            for (int col = 0; col < p; col++)  // Iterating column
            {
                if (row != m && col != n)   // To get cofactor we neglect the row and column of the element
                {
                    arr1[i][j++] = arr[row][col];
                    if (j == p - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
     
    static int determinant(double arr[][], int n)
    {
        int y = 0; 
        if (n == 1)    // if matrix contains single element
        {
            return (int)arr[0][0];
        }
        double arr1[][] = new double[N][N]; // To store cofactors
        int sign = 1; // To store sign multiplier
        
        for (int x = 0;x < n;x++)   // Iterate for each element of first row
        {
            getCofactor(arr, arr1, 0, x, n);  // Getting Cofactor of A[0][f]
            y=y+sign * (int)arr[0][x] * determinant(arr1, n - 1);
            sign = -sign;  // terms are to be added with alternate sign
        }
     
        return y;
    }
     
    static void adjoint(double arr[][],double arr1[][])  // Function to calculate adjoint of matrix
    {
        if (N == 1)   // If matrix is 1x1 then adjoint is also 1
        {
            arr1[0][0] = 1;
            return;
        }
     
        int sign = 1;
        double arr2[][] = new double[N][N];  
     
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                getCofactor(arr, arr2, i, j, N);  // calling cofactor function
                sign = ((i + j) % 2 == 0)? 1: -1;  // Assigns the sign to the element if the value of sum of indices is even then positive else negative
     
                arr1[j][i] = (sign)*(determinant(arr2, N-1)); // We get Adjoint of a matrix by Interchanging rows and columns of the cofactor matrix 
            }
        }
    }
     
    static boolean inverse(double arr[][],int r,int c)  // This function returns false if matrix is singular
    {
        double arr1[][]=new double[r][c];
        int det = determinant(arr, N);  // Calling Determinant function
        if (det == 0)   // If determinant of a matrix is zero then inverse does not exist
        {
            System.out.print("Singular matrix, can't find its inverse");
            return false;
        }

        double arr2[][] = new double[N][N];
        adjoint(arr,arr2);  // Calling adjoint function
        
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                arr1[i][j] = arr2[i][j]/(float)det;  //  inverse(A) = (1/det(A))*adj(A)
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }
        return true;
    }
}

/* Test case 1 :

1 2 3 4 5
5 1 4 3 2
3 5 1 2 3
4 3 2 1 5
3 4 5 2 1

*/

/* Test case 2 :

1 1 1 -1
1 1 -1 1
1 -1 1 1
-1 1 1 1

/*
