import java.util.*;
//import java.io.*;

class matrix
{
    public void Accept(int m, int n, int mat[][], Scanner sc)
    {
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                mat[i][j] = sc.nextInt();
            }
        }
    }

    public void Display(int m, int n, int mat[][])
    {
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(mat[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    public static int[][] Addition(int m1, int m2, int n1, int n2, int mat1[][], int mat2[][], int sum[][])
    {
        if(m1==m2 && n1==n2)
        {
            for(int i=0; i<m1; i++)
            {
                for(int j=0; j<n1; j++)
                {
                    sum[i][j] = mat1[i][j] + mat2[i][j];
                }
            }
        }
        else
        {
            System.out.println("Addition of matrices cannot be done because of order mismatch");
        }
        return sum;
    }
}

public class Matrix_Addition
{
    public static void main(String[] args) //throws IOException
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        matrix mat = new matrix();

        System.out.print("Enter the order of matrix 1: ");
        // int m1 = Integer.parseInt(br.readLine());
        // int n1 = Integer.parseInt(br.readLine());
        int m1 = sc.nextInt();
        int n1 = sc.nextInt();

        int mat1[][] = new int[m1][n1];

        System.out.print("\nEnter the elements of matrix 1: ");
        //mat.Accept(m1, n1, mat1, br);
        mat.Accept(m1, n1, mat1, sc);
        
        System.out.print("\nEnter the order of matrix 2: ");
        // int m2 = Integer.parseInt(br.readLine());
        // int n2 = Integer.parseInt(br.readLine());
        int m2 = sc.nextInt();
        int n2 = sc.nextInt();

        int mat2[][] = new int[m2][n2];

        System.out.print("\nEnter the elements of matrix 2: ");
        //mat.Accept(m2, n2, mat2, br);
        mat.Accept(m2, n2, mat2, sc);

        System.out.println("\nThe elements of matrix 1 are: ");
        mat.Display(m1, n1, mat1);

        System.out.println("\nThe elements of matrix 2 are: ");
        mat.Display(m2, n2, mat2);

        System.out.println("\nAddition of two matrices: ");
        int sum[][] = new int[m1][n1];
        sum = matrix.Addition(m1, m2, n1, n2, mat1, mat2, sum);
        mat.Display(m1, n1, sum);
        // for(int i=0; i<m1; i++)
        // {
        //     for(int j=0; j<n1; j++)
        //     {
        //         if(sum[i][j] != 0)
        //         {
        //             mat.Display(m1, n1, sum);
        //         }
        //     }
        // }
    }
}
