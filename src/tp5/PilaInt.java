/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5;

/**
 *
 * @author Flanoy
 */
public class PilaInt {
    Nodo fondo;
    Nodo tope;
    int cantidad;
   
    private class Item{
            int i; 
            public Item(){
                this.i='n';
            }
            public  Item itemVacio(){
                return new Item();
            }
        }
    
    private class Nodo{
        private Item item;
        private Nodo enlace;
        
        public Nodo(Item unItem){
            this.item=unItem;
            this.enlace=null;
        }
        
        public Nodo(int c){
            this.item= new Item();
            this.item.i=c;
            this.enlace=null;
        }
        
        public Nodo(Item unItem,Nodo unEnlace){
            this.item=unItem;
            this.enlace=unEnlace;
        }
        public Nodo(int c,Nodo unEnlace){
            this.item= new Item();
            this.item.i=c;
            this.enlace=unEnlace;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public Nodo getEnlace() {
            return enlace;
        }

        public void setEnlace(Nodo enlace) {
            this.enlace = enlace;
        }
        
    }
    //Constructor
    private PilaInt(){
        this.tope=null;
        this.fondo=null;
        this.cantidad=0;
    }
    
    //crearPilaVacia
    public static PilaInt crearPilaVacia(){
        return new PilaInt();
    }
    
    //Push
    public PilaInt push(int c){
        if(this.cantidad==0){
            Nodo nuevoNodo= new Nodo(c, null);
            this.fondo=nuevoNodo;
            this.tope=nuevoNodo;
            this.cantidad++;
        }else{
            Nodo nuevoNodo= new Nodo(c,this.tope);
            this.tope=nuevoNodo;
            this.cantidad++;
        }
        return this;
    }
    
    //Pop
    public PilaInt pop(){
        if(this.cantidad==0){
            return this;
        }else{
            this.tope=this.tope.getEnlace();
            if(this.tope==null){
                this.fondo=null;
            }
            this.cantidad--;
        }
        return this;
    }
    
    //TOP
    public Item top(){
        return this.tope.getItem();
    }
    
    //Fondo
    public Item fondo(){
        return this.fondo.getItem();
    }
    
    //Mostrar
    public void mostrar(){
        Nodo aux=this.tope;
        while(aux!=null){
            System.out.println(aux.getItem().i);
            aux=aux.getEnlace();
        }
    }
    
    public static void main(String[] args) {
        PilaInt P=PilaInt.crearPilaVacia();
        P.push('A');
        P.push('B');
        P.push('C');
        P.push('D');
        P.mostrar();
        System.out.println("El fondo es:"+P.fondo.item.i);
        System.out.println("El tope es:"+P.tope.item.i);
        P.pop();
        P.mostrar();
        System.out.println("El fondo es:"+P.fondo.item.i);
        System.out.println("El tope es:"+P.tope.item.i);
        
    }
}
