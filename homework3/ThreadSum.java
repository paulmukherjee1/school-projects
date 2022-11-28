/**
 * 
 * Class: ThreadSum
 * 
 * @author Paul Mukherjee
 * @version 1.0
 * ITEC 3150 October 15th 2021
 * 
 * This class is used for obtaining the sum of each array ran by each thread
 * and adding it to the total shared sum.
 * 
 * Purpose: methods and attributes needed for obtaining the sum of each array.
 */
public class ThreadSum extends Thread {
        private InitializedArray array;
        
        // sum totaled by thread
        
        private long sum;
        
        // starting index of the array
        
        private int indexStart;
        
        // ending index of the array
        
        private int indexEnd;

        // shared sum
        
        private SharedSum sharedSum;

        /**
         * @param array
         * @param sharedSum
         * @param start
         * @param end
         */
        public ThreadSum(InitializedArray array, SharedSum sharedSum, int start, int end) {
                sum = 0;
                
                this.array = array;
                
                this.sharedSum = sharedSum;
                
                indexStart = start;
                
                indexEnd = end;


        }
        
        /**
         * Method: run()
         * 
         * This method is used for obtaining the sum of the array for each
         * thread, and adding it to the shared sum
         */
        @Override
        public void run() {

                // initializing sum to 0
                
                sum = 0;
                
                // adding values to sum
                
                for (int i = indexStart; i < indexEnd; i++) {
                        sum += array.getElement(i);
                }
                
                // printing sum for each thread
                
                System.out.println("Thread complete-Array Sum= "  + sum);
                
                // adding sum to sharedSum at the end.
                
                sharedSum.addSum(sum);
                
               
                
        }
        
}