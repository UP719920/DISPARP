import java.util.Random;
import java.lang.Math;

public class MatrixMultiplication {
   public static void main(String args[]) {
       
      for (int k=0; k<10; k++) {
          //Random randNum = new Random();
          //int random = (int)(Math.random());
          int N = 9000;
          int R = 100000;
      
          long beginTime = System.currentTimeMillis();
      
          // matrix 1
          int a[][] = new int[N][N];
      
          for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
              a[i][j] = (int)(Math.random() * R);
              //System.out.print(a[i][j] + " ");
            }
          }
      
            // matrix 2
            int b[][] = new int[N][N];
      
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    b[i][j] = (int)(Math.random() * R);
                    //System.out.print(b[i][j] + " ");
                }
            }
      
            // result matrix
            int c[][] = new int[N][N]; // 3 rows and 3 columns
            // multiply and print matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    c[i][j] = 0;
                    c[i][j] += a[i][j] * b[i][j];
                    //System.out.printf("%4d", c[i][j]);
                }
                //System.out.println();
            }
      
            long finishTime = System.currentTimeMillis();
      
            System.out.println("Time taken: " +
                             (finishTime - beginTime) + " (milliseconds)");
      }
      
      /*
      Random randNum = new Random();
      int random = (int)(Math.random());
      int N = 20;
      int R = 100;
      
      long beginTime = System.nanoTime();
      
      // matrix 1
      int a[][] = new int[N][N];
      
      for (int i=0; i<N; i++) {
          for (int j=0; j<N; j++) {
              a[i][j] = (int)(Math.random() * R);
              //System.out.print(a[i][j] + " ");
          }
      }
      
      // matrix 2
      int b[][] = new int[N][N];
      
      for (int i=0; i<N; i++) {
          for (int j=0; j<N; j++) {
              b[i][j] = (int)(Math.random() * R);
              //System.out.print(b[i][j] + " ");
          }
      }
      
      // result matrix
      int c[][] = new int[N][N]; // 3 rows and 3 columns
      // multiply and print matrix
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            c[i][j] = 0;
            c[i][j] += a[i][j] * b[i][j];
            System.out.printf("%4d", c[i][j]);
         }
         System.out.println();
      }
      
      long finishTime = System.nanoTime();
      
      System.out.println("Time taken: " +
                             (finishTime - beginTime) + " (nanoseconds)");
      */
   }
}