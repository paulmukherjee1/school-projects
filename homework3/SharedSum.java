import java.util.concurrent.locks.ReentrantLock;
/**
 * Class: SharedSum
 * 
 * @author Paul Mukherjee
 * @version 1.0
 * ITEC 3150 October 15th 2021
 * 
 * This class is used to keep the sums shared between threads
 * and eventually print out the total sum, with the sum
 * being protected by a ReentrantLock 
 * 
 * Purpose: Methods and attributes needed to keep a running total of the sum
 */
public class SharedSum {
        // variable for the total sum
        private long sum;
        
        // ReentrantLock to protect access to above variable
        private ReentrantLock lock;
        
       
        /**
         * Method:sharedSum()
         * 
         * This method initializes the sum to 0 and creates a ReentrantLock
         * 
         * 
         */
        public SharedSum() {
            
                sum = 0;
                
                lock = new ReentrantLock();
        }

        
        /**
         * Method:addSum()
         * 
         * This method keeps a running total of the sum and is also protected by a ReentrantLock
         * 
         * @param value
         */
        public  void addSum(long value) {
            
                //locking sum variable
                
                lock.lock();
                
                //adding value to sum
                
                sum += value;
                
                //unlocking sum variable
                
                lock.unlock();
        }

        /**
         * Method:getSum()
         * 
         * This method returns the sum
         *
         */
        
        public long getSum() {
            
                return sum;
        }
}