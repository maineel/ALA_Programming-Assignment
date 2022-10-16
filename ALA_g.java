import java.util.*;
class ALA_g
{
    public static void main(String args[])
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
        int rank=rank(arr,row1,column1);
        System.out.println();
        System.out.println();
        System.out.println("Rank of the matrix is: "+rank);
    }
    public static int rank(double[][] arr,int r,int c)
    {
        int rank=0,x=0;
        for(int i=0;i<c;i++)
        {
            if(i==0)
            {
                for(int j=0;j<r;j++)
                {
                    if(arr[j][i]!=0)
                    {
                        x=j;
                        rank++;
                        break;
                    }
                }
            }
            else
            {
                for(int j=x+1;j<r;j++)
                {
                    if(arr[j][i]!=0)
                    {
                        x=j;
                        rank++;
                        break;
                    }
                }
            }      
        }
        return rank;
    }
    static void print(double[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

/* Test Case:1
4 4
1 0 -1 -2
0 1 2 3 
0 0 0 0
0 0 0 0
*/

/* Test Case:2
5 5
1 0 0 0 -1
0 1 0 0 0
0 0 1 0 2
0 0 0 1 0
0 0 0 0 0
*/
