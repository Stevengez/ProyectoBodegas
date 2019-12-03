/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobodegas.Estructura;

/**
 *
 * @author Steven Jocol
 */
public class Nodo_Bodega {
    private Nodo_Bodega Nodo_bodega_siguiente, Nodo_bodega_anterior;
    private String identificador;
    private Nivel Lista_Niveles;
    private int indice;
    
    public Nodo_Bodega(int indice, String identificador){
        Nodo_bodega_siguiente = null;
        Nodo_bodega_anterior = null;
        Lista_Niveles = new Nivel();
        
        this.indice = indice;
        this.identificador = identificador;
    }
    
    
    /**
     * Obtiene un elemento de la lista Bodega (Nodo_Bodega).
     * @return Devuelve el Nodo_Bodega siguiente o NULL si no hay mas nodos. 
     */
    
    public Nodo_Bodega obtenerSiguiente(){
        return Nodo_bodega_siguiente;
    }
    
    /**
     * Obtiene un elemento de la lista Bodega (Nodo_Bodega).
     * @return Devuelve el Nodo_Bodega anterior o NULL si no hay mas nodos.
     */
    
    public Nodo_Bodega obtenerAnterior(){
        return Nodo_bodega_anterior;
    }
    
    public void definirSiguiente(Nodo_Bodega siguiente){
        Nodo_bodega_siguiente = siguiente;
    }
    
    public void definirAnterior(Nodo_Bodega anterior){
        Nodo_bodega_anterior = anterior;
    }
    
    public int obtenerIndice(){
        return indice;
    }
    
    public String obtenerIdentificador(){
        return identificador;
    }
    
    /**
     * Devuelve una lista del tipo Nivel.
     * @return Devuelve una lista ordenada del tipo Nivel.
     */
    public Nivel Niveles(){
        return Lista_Niveles;
    }
    
}
