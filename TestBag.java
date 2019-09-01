
package bags;

/**
 *
 * @author Alextorices
 */
public class TestBag {
    
    public static void main(String[] args) {
        BagInterface<String> myBag = new ResizableArrayBag<>(2);
        System.out.println("Empty Bag: " + myBag);
        myBag.add("manzana");
        myBag.add("piña");
        myBag.add("naranja");
        myBag.add("tuna");
        myBag.add("uva");
        System.out.println("Bolsa: " + myBag);
        System.out.println("Removiendo elemento " + myBag.remove());
        System.out.println("Removiendo elemento " + myBag.remove());
        System.out.println("Removiendo 'manzana' " + myBag.remove("manzana"));
        System.out.println("Empty Bag: " + myBag);
        System.out.println(myBag);
        
        BagInterface<Integer> otherBag = new ResizableArrayBag<>();
        otherBag.add(1);
        otherBag.add(10);
        otherBag.add(1);
        otherBag.add(11);
        System.out.println("Frecuencia de 1: " +otherBag.getFrequencyOf(1));
        System.out.println("Contiene 10? " + otherBag.contains(10));
        otherBag.clear();
        System.out.println("Empty Bag: "+otherBag);
    }
    
}
