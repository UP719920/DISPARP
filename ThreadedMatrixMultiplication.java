import java.util.Random;
import java.lang.Math;

public class ThreadedMatrixMultiplication extends Thread {
    
   static int N = 9000;
   static int R = 100000;
   static int P = 4; //thread number
   
   public static void main(String args[]) throws InterruptedException {
       
      for (int k=0; k<10; k++) {
          Random randNum = new Random();
          int random = (int)(Math.random());
          int matrixBlock = N/P; //size of matrix delegated to threads
      
          long beginTime = System.currentTimeMillis();
      
          
      
          for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
              a[i][j] = (int)(Math.random() * R);
              //System.out.print(a[i][j] + " ");
            }
          }
      
      
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    b[i][j] = (int)(Math.random() * R);
                    //System.out.print(b[i][j] + " ");
                }
            }
      
            
            
            
            ThreadedMatrixMultiplication [] threads = new ThreadedMatrixMultiplication [P];
            
            for (int me = 0; me < P; me++) {
                threads[me] = new ThreadedMatrixMultiplication(me);
                int begin;
                int end;
                
                begin = me * matrixBlock;
                end = me * (matrixBlock + 1);
                    
                threads[me].start();
            }
            
            for(int me = 0; me < P; me++) {
                threads[me].join();
            }
      
            long finishTime = System.currentTimeMillis();
      
            System.out.println("Time taken: " +
                             (finishTime - beginTime) + " (milliseconds)");
      }
      
   }
   
   int me;
   int begin;
   int end;
            
   public ThreadedMatrixMultiplication(int me) {
       this.me = me;
   }
   
   // matrix 1
   static int a[][] = new int[N][N];
   
   // result matrix
   static int c[][] = new int[N][N]; 
   
   // matrix 2
   static int b[][] = new int[N][N];
   
   public void run() {
        // multiply and print matrix
        for (int i = begin; i < end; i++) {
            for (int j = 0; j < N; j++) {
                c[i][j] = 0;
                c[i][j] += a[i][j] * b[i][j];
                //System.out.printf("%4d", c[i][j]);
                //System.out.print(a[i][j] + " ");
            }
        //System.out.println();
        }
   }
}