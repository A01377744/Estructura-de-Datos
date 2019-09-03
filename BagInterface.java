package bags;

/**
 *
 * @author Alejandro Torices Oliva A01377744, Alexys Martin Coate Reyes A01746998 
 * & Daniel Trejo Gonzalez A01372747
 */
public interface BagInterface<T> {
    
    int getCurrentSize();
    
    boolean isFull();
    
    boolean isEmpty();
    
    boolean add(T newEntry);
    
    void clear();
    
    T remove();
    
    boolean remove(T entry);
    
    void removeEvery(T entry);
    
    int getFrequencyOf(T entry);
    
    boolean contains(T entry);
    
    T[] toArray();
    
}