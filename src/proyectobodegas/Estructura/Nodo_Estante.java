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
public class Nodo_Estante {
    
    private Nodo_Estante Nodo_estante_siguiente, Nodo_estante_anterior;
    private Seccion Lista_Secciones;
    private String identificador;
    private int indice;
    
    public Nodo_Estante(int indice, String identificador){
        Nodo_estante_siguiente = null;
        Nodo_estante_anterior = null;
        Lista_Secciones = new Seccion();
        
        this.indice = indice;
        this.identificador = identificador;
    }
    
    
    /**
     * Obtiene un elemento de la lista Estante (Nodo_Estante).
     * @return Devuelve el Nodo_Estante siguiente o NULL si no hay mas nodos. 
     */
    
    public Nodo_Estante obtenerSiguiente(){
        return Nodo_estante_siguiente;
    }
    
    /**
     * Obtiene un elemento de la lista Estante (Nodo_Estante).
     * @return Devuelve el Nodo_Estante anterior o NULL si no hay mas nodos.
     */
    
    public Nodo_Estante obtenerAnterior(){
        return Nodo_estante_anterior;
    }
    
    public void definirSiguiente(Nodo_Estante siguiente){
        Nodo_estante_siguiente = siguiente;
    }
    
    public void definirAnterior(Nodo_Estante anterior){
        Nodo_estante_anterior = anterior;
    }
    
    public int obtenerIndice(){
        return indice;
    }
    
    public String obtenerIdentificador(){
        return identificador;
    }
    
    public Seccion Secciones(){
        return Lista_Secciones;
    }
    
}
