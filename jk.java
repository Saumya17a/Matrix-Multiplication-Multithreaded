class Product extends Thread 
{
    int[][] A;
    int[][] B;
    int[][] result_matrix;
    int row;
    int column;
    int dimension;

    public Product(int[][] A,int[][] B,int[][] result_matrix,int row, int column,int dimension)
    {
        this.A = A;    
        this.B = B;
        this.result_matrix = result_matrix;
        this.row = row;    
        this.column = column; 
        this.dimension = dimension;     
    }


    // The fragment below is responsible calculate the result of A*B
    public void run()
    {
        for(int i = 0; i < dimension; i++)
        {
            result_matrix[row][column] += A[row][i] * B[i][column];        
        }      
        System.out.println("I am a thread for "+ row + "," + column);        
    }          
}