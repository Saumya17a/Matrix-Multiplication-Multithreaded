import java.util.Scanner;

  class Assignment3 {
    public static void main(String[] args)
    {
        // The following code below take the number of rows and columns of input Matrix A and B 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Number of rows for A: ");     
        int nums_rows_A = sc.nextInt();
        System.out.print("Number of columns for A: ");
        int nums_cols_A = sc.nextInt();
        System.out.print("Number of rows for B: ");     
        int nums_rows_B = sc.nextInt();
        System.out.print("Number of columns for B: ");
        int nums_cols_B = sc.nextInt();
        System.out.println();
        //-------------------------------------------------------------------------------------------------------------------

        // The fragment below check whether #colums of A = #rows of B to verify whether we can proceed for the multiplication
        if(nums_cols_A != nums_rows_B)
        {
            System.out.println("The matrix multiplication is not possible as the #columns of A != #rows of B");
            System.exit(-9);
        }
        System.out.println("The resulting matrix will be of size " + nums_rows_A + " x " + nums_cols_B + "\n");
        //--------------------------------------------------------------------------------------------------------------------

        // The fragment below creates the two-dimensional array for A,B and resulting matrix and thread of the type Product
        Product[][] product_thread= new Product[nums_rows_A][nums_cols_B];
        int[][] A = new int[nums_rows_A][nums_cols_A];
        int[][] B = new int[nums_rows_B][nums_cols_B];
        int[][] result = new int[nums_rows_A][nums_cols_B];
        //------------------------------------------------------------------------------------------------------------------
        
        // The fragment below is to input and store the values inside the matrix
        System.out.println("Enter values for Matrix A:");
        for(int input_row_a = 0; input_row_a < nums_rows_A ; input_row_a++)
        {
            for(int input_col_a = 0; input_col_a < nums_cols_A; input_col_a++)
            {
                System.out.print(input_row_a + "," + input_col_a + " = ");
                A[input_row_a][input_col_a] = sc.nextInt();
            }
        }

        System.out.println("\nEnter values for Matrix B:");
        for(int input_row_b = 0; input_row_b < nums_rows_B; input_row_b++)
        {
            for(int input_col_b = 0; input_col_b < nums_cols_B; input_col_b++)
            {
                System.out.print( input_row_b + "," + input_col_b + " = ");
                B[input_row_b][input_col_b] = sc.nextInt();
            }        
        }
        System.out.println();
        //----------------------------------------------------------------------------------------------------------------------------

        // The following fragment starts the matrix multiplication using threads
        for(int i = 0; i < nums_rows_A; i++)
        {   
            for(int j = 0; j < nums_cols_B; j++)
            {
                product_thread[i][j]=new Product(A,B,result,i,j,nums_cols_A);
                product_thread[i][j].start();
            }
        }


        for(int i = 0; i < nums_rows_A; i++)
        {
            for(int j = 0; j < nums_cols_B; j++)
            {
                try{
                    product_thread[i][j].join();
                }
            catch(InterruptedException e){}
            }
        }        
        //--------------------------------------------------------------------------------------------------------------------------------


        // The fragment below prints out the result of A*B
        System.out.println("\nThe following is the resulting Matrix\n");
        System.out.print("[\n");
        for(int result_row = 0; result_row < nums_rows_A; result_row++)
        {
            for(int result_column = 0; result_column < nums_cols_B; result_column++)
            {
                System.out.print(result[result_row][result_column] + " ");
            }    
            System.out.println();            
        }
        System.out.print("]");
        //---------------------------------------------------------------------------------------------------------------------------------
    }      
}