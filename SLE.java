import java.util.*;
public class SLE
{
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
                arr[i][j]=sc.nextDouble();
            }
        }
        System.out.println("Enter rank of matrix:");
        int rank=sc.nextInt();
        ALA_SLE(arr,r,c,rank);
    }
    public static void ALA_SLE(double[][] arr,int m,int n,int rank)
    {
        if(rank<m)
        {
            System.out.println("Infnite solutions");
        }
        else
        {
            int t=0;
            for (int i = 0; i < m; i++) {
                int check=0;
                for (int j = 0; j <n-1 ; j++) {
                    if(arr[i][j]!=0){
                        check=1;
                        break;
                    }
                }
                if(check==1 && arr[i][n-1]==0){
                    t=1;
                    break;
                }
            }
            if(t!=1)
            {
                for(int i=0;i<m;i++)
                {
                    System.out.println("Value of x"+i+" is: "+arr[i][n-1]);
                }
            }
            else {
                System.out.println("NO SOLUTION");
            }
        }
    }
}