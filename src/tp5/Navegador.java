/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5;

/**
 *
 * @author Flanoy
 */
public class Navegador {
    private PilaInt adelante;
    private PilaInt atras;
    private int actual;
    
    private Navegador(){
        this.actual=0;
        this.adelante=PilaInt.crearPilaVacia();
        this.atras=PilaInt.crearPilaVacia();
    }
    public static Navegador crearNavegador(){
        return new Navegador();
    }
    
    public void navegar(int URL){
        if(URL!=this.actual){
            this.atras.push(this.actual);
            this.actual=URL;
            this.adelante=PilaInt.crearPilaVacia();
        }
    }
    
    public int atras(){
        this.adelante.push(this.actual);
        this.actual=this.atras.top();
        this.atras.pop();
        return this.actual;
    }
    
    public int adelante(){
        if(this.adelante.cantidad==0){
            return this.actual;
        }else{
            this.atras.push(this.actual);
            this.actual=this.adelante.top();
            this.adelante.pop();
            return this.actual;
        }
    }
    public static void main(String[] args) {
        
    }
}
