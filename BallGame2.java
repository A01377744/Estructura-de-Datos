
package T03_Bags;

public class BallGame2 {

    private ResizableArrayBag<Integer> bag;
    
    public BallGame2(int n) {
        bag = new ResizableArrayBag<> (1);
        bag.add(n);
    }
    //Mientras la bolsa no esté vacia se segirá la función
    //divideBall e imprimirá los items acutales en la bolsa
    public void startGame(){
        while(bag.isEmpty() == false){
            System.out.println("Bolsa: " + bag);
            divideBall(bag.remove());   
        }
        System.out.println("La bolsa está vacia!");
    }
    //Cuando se extrae una pelota se recive la pelote y con
    //base en su número se divide en más pelotas y se
    //determina su número
    public void divideBall(int n){
        //Añade n bolas con el número n/2 e imprime la 
        //bola retirada
        System.out.println("Retirado: " + n);
        for(int i=0; i<n; i++){
            bag.add(n/2);
        }
        System.out.println("");
    }
}
