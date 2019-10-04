
package lists;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author Alextorices
 * @param <T>
 */
public class ArrayQueue<T> implements QueueInterface<T>{
    private T[] queue;
    private int last, next, numberOfElements;
    private int size = 10;
    private boolean full;

    public ArrayQueue(){
        this.last = 0;
        this.next = 0;
        this.numberOfElements = 0;
        queue = (T[]) new Object[size];
        full = false;
    }
    
    public void enqueue(T newElement) {
        if(full == true){
            T[] newQueue = (T[]) new Object[size];
            for(int i=0; i<size; i++){
                try{
                newQueue[i]= queue[last+i];
                //ArrayIndexOutOfBoundsException
                }catch(Exception e){
                    newQueue[i]= queue[last+i-size];                  
                }
            }         
            this.size = size*2;  
            queue = Arrays.copyOf(newQueue, size); 
            
            this.last = 0;
            this.next = numberOfElements;
                       
            queue[next] = newElement;
            this.full = false;
        }else{
         queue[next]= newElement;
        }    
        next++; 
        numberOfElements++;
        if(numberOfElements==size){
            this.full = true;
        }
        if(next>size-1){
            next=0;
        }
    }

    @Override
    public T dequeue() {
        if(numberOfElements ==0){
            throw new NoSuchElementException();
        }
        T element = queue[last];
        queue[last] = null;
        last++;
        numberOfElements--;
        if(last>size-1){
            last=0;
        }       
        return element;
    }

    @Override
    public T getFront() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(queue, size));
    }
      
}
