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
public class Nodo_Seccion {
    
    private Nodo_Seccion Nodo_seccion_siguiente, Nodo_seccion_anterior;
    private Productos Lista_Productos;
    private String identificador;
    private int indice;
    
    public Nodo_Seccion(int indice, String identificador){
        Nodo_seccion_siguiente = null;
        Nodo_seccion_anterior = null;
        Lista_Productos = new Productos();
        this.indice = indice;
        this.identificador = identificador;
    }
    
    /**
     * Obtiene un elemento de la lista Seccion (Nodo_Seccion).
     * @return Devuelve el Nodo_Seccion siguiente o NULL si no hay mas nodos. 
     */
    
    public Nodo_Seccion obtenerSiguiente(){
        return Nodo_seccion_siguiente;
    }
    
    /**
     * Obtiene un elemento de la lista Seccion (Nodo_Seccion).
     * @return Devuelve el Nodo_Seccion anterior o NULL si no hay mas nodos.
     */
    
    public Nodo_Seccion obtenerAnterior(){
        return Nodo_seccion_anterior;
    }
    
    public void definirSiguiente(Nodo_Seccion siguiente){
        Nodo_seccion_siguiente = siguiente;
    }
    
    public void definirAnterior(Nodo_Seccion anterior){
        Nodo_seccion_anterior = anterior;
    }
    
    public int obtenerIndice(){
        return indice;
    }
    
    public String obtenerIdentificador(){
        return identificador;
    }
    
    public Productos Productos(){
        return Lista_Productos;
    }
}
