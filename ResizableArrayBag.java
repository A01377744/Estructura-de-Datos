package bags;

import java.util.Arrays;

/**
 *
 * @author Julio Arriaga
 */
public class ResizableArrayBag<T> implements BagInterface<T> {
    
    private T[] bag, n;
    private int numberOfElements, size;
    private static final int DEFAULT_SIZE = 100;
    
    public ResizableArrayBag(int size){
        this.size = size;
        numberOfElements = 0;
        bag = (T[]) new Object[size];
    }
    
    public ResizableArrayBag(){
        this(DEFAULT_SIZE);
    }

    @Override
    public int getCurrentSize() {
        return numberOfElements;
    }

    @Override
    public boolean isFull() {
        return numberOfElements == size;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if(isFull()){
            n = Arrays.copyOf(bag, size);
            this.size = size * 2;
            bag = (T[]) new Object[size];
            for(int i = 0; i < numberOfElements; i++){
                bag[i] = n[i];
            }
        }
        bag[numberOfElements] = newEntry;
        numberOfElements++;
        return true;
    }

    @Override
    public void clear() {
        numberOfElements = 0;
    }

    @Override
    public T remove() {
        if(isEmpty()){
            return null;
        }
        numberOfElements--;
        return bag[numberOfElements];
    }

    @Override
    public boolean remove(T entry) {
        for(int i = 0; i < numberOfElements; i++){
            if(bag[i].equals(entry)){
                numberOfElements--;
                bag[i] = bag[numberOfElements];
                return true;
            }
        }
        return false;
    }

    @Override
    public int getFrequencyOf(T entry) {
        int c = 0;
        for(int i = 0; i < numberOfElements; i++){
            if(bag[i].equals(entry)){
                c++;
            }
        }
        return c;
    }

    @Override
    public boolean contains(T entry) {
        return getFrequencyOf(entry) > 0;
    }
    
    public void removeEvery(T entry){
        for(int i = 0; i < numberOfElements; i++){
            if(bag[i].equals(entry)){
                numberOfElements--;
                bag[i] = bag[numberOfElements];
            }
        }        
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(bag, numberOfElements);
    }
    
    @Override
    public String toString(){
        return Arrays.toString(toArray());
    }
    
}