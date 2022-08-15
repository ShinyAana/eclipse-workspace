package learn;
public class MatRotateAC
{
  // Takes Matrix and Size of Matrix and performs Anti - Clockwise Rotation by 90 degrees.    
  static void leftRotate(int matrix[][],int n)
  {
      
      //At first we perform transpose of the matrix
      //by swapping elements of every i'th row with j'th column
      for(int i=0;i<n;i++)
      {
          for(int j=i;j<n;j++)
          {
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
          }
      }
      
      // Then we reverse the elements of each column.
      for(int i=0;i<n;i++)
      {
        // Logic to reverse each column
        int low = 0;
        int high = n-1;
        
        while(low < high)
        {
            int temp = matrix[low][i];
            matrix[low][i] = matrix[high][i];
            matrix[high][i] = temp;
            
            low++;
            high--;
        }
      }
      
      System.out.println("The Left Rotated Matrix is: ");
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              System.out.print(matrix[i][j]+" ");
          }
          System.out.println();
      }
  }
    
  public static void main(String args[])
  {
      int n=3;
      // Creating a 3 X 3 matrix.
      int matrix[][] = new int[][]{ {1,2,3}, {4,5,6} , {7,8,9} };
      
      System.out.println("The Original Matrix is: ");
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              System.out.print(matrix[i][j]+" ");
          }
          System.out.println();
      }
      
      leftRotate(matrix,n);
  }
  
}

