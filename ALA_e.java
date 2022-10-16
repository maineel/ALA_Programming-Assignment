import java.util.Scanner;
public class ALA_e
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int r,c;
        System.out.println("Enter number of rows: ");
        r = sc.nextInt();
        System.out.println("Enter number of cols: ");
        c = sc.nextInt();
        double[][] arr = new double[r][c];
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j<c; j++)
            {
                System.out.printf("Enter number: ");
                arr[i][j] = sc.nextInt();
            }
        }
        print(arr);
        System.out.println();
        System.out.println();
        double norm=norm_of_matrix(arr,r,c);
        System.out.println("Norm of matrix: "+norm);
    }
    static double norm_of_matrix(double matrix[][],int row,int column)
    {
        int norm = 0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                norm+=((matrix[i][j])*(matrix[i][j]));  // Square each and every element of the matrix and add them
            }
        }
        double ans = Math.sqrt(norm);  // Stores square root of the sum of all square of the elements of the matrix
        return ans;
    }
    
    static void print(double[][] arr){
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = 0; j < arr[i].length; j++) 
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}



/* Test Case:1
3 4
1 3 4 1
2 4 8 1
4 6 2 3
*/

/* Test Case:2
4 4
1 2 3 4
5 6 7 8
1 2 3 4
5 6 7 8
*/
