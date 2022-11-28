/**
 * Class: Main
 * @author Paul Mukherjee
 * @version 1.0
 * ITEC 3150 October 15th 2021
 * 
 * This class is used for starting all 10 threads and displaying the final 
 * shared sum for all arrays ran by each thread.
 * 
 * Purpose: Methods and attributes needed to display the shared sum of all 10 
 * threads. 
 */
public class Main {
        public static void main(String[] args)  {
                InitializedArray array = new InitializedArray();
                
                // creating a SharedSum

                SharedSum sum = new SharedSum();
                
                // creating an array of 10 threadSum objects
                
                ThreadSum threads[] = new ThreadSum[10];
                
                // looping and initializing each thread
                
                for (int i = 0; i < threads.length; i++) {
                        threads[i] = new ThreadSum(array, sum, i * 1000000, (i + 1) * 1000000);
                }
                
                // starting threads
                
                for (int i = 0; i < threads.length; i++) {
                        threads[i].start();
                }
                
                // joining threads to wait until all threads finish running
                
                try {
                for (int i = 0; i < threads.length; i++) {
                        threads[i].join();
                }
                }
                catch (InterruptedException e) 
                {  
                }
                
                // display shared sum for all threads
                
                System.out.println("Final sum of Arrays = " + sum.getSum());

        }
}