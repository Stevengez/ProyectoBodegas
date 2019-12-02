/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobodegas.Estructura;

/**
 *
 * @author propietario
 */
public class Nodo_Bodega {
    Nodo_Bodega Nodo_bodega_siguiente, Nodo_bodega_anterior;
    String Nombre_bodega;
    
    public Nodo_Bodega(String nombre_bodega){
        Nodo_bodega_siguiente = null;
        Nodo_bodega_anterior = null;
        
        Nombre_bodega = nombre_bodega;
        
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
    
}
