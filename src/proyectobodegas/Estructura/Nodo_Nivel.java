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
public class Nodo_Nivel {
    
    private Nodo_Nivel Nodo_nivel_siguiente, Nodo_nivel_anterior;
    private Area Lista_Areas;
    private String identificador;
    
    private int indice;
    
    public Nodo_Nivel(int indice, String identificador){
        Nodo_nivel_siguiente = null;
        Nodo_nivel_anterior = null;
        Lista_Areas = new Area();
        
        this.indice = indice;
        this.identificador = identificador;
    }
    
    
    /**
     * Obtiene un elemento de la lista Nivel (Nodo_Nivel).
     * @return Devuelve el Nodo_Nivel siguiente o NULL si no hay mas nodos. 
     */
    
    public Nodo_Nivel obtenerSiguiente(){
        return Nodo_nivel_siguiente;
    }
    
    /**
     * Obtiene un elemento de la lista Nivel (Nodo_Nivel).
     * @return Devuelve el Nodo_Nivel anterior o NULL si no hay mas nodos.
     */
    
    public Nodo_Nivel obtenerAnterior(){
        return Nodo_nivel_anterior;
    }
    
    public void definirSiguiente(Nodo_Nivel siguiente){
        Nodo_nivel_siguiente = siguiente;
    }
    
    public void definirAnterior(Nodo_Nivel anterior){
        Nodo_nivel_anterior = anterior;
    }
    
    public int obtenerIndice(){
        return indice;
    }
    
    public String obtenerIdentificador(){
        return identificador;
    }
    
    public Area Areas(){
        return Lista_Areas;
    }
}
