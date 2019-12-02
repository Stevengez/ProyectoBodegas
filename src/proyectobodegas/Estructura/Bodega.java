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
public class Bodega {
    
    Nodo_Bodega Nodo_bodega_inicial, Nodo_bodega_final, Nodo_bodega_actual;  
    int Size;
    
    /**
     * Lista de Bodegas.
     */
    
    public Bodega(){
        Size = 0;
        Nodo_bodega_inicial = null;
        Nodo_bodega_final = null;
        Nodo_bodega_actual = null;
    }
    
    /**
     * Devuelve el elemento actual de la lista.
     * @return Devuelve un objecto del tipo Nodo_Bodega.
     */
    
    public Nodo_Bodega bodegaActual(){
        return Nodo_bodega_actual;
    }
    
    /**
     * Mueve el cursor a la siguiente bodega.
     * @return Devuelve TRUE si el puntero pudo avanzar a la siguiente bodega y FALSE si ya no hay mas bodegas.
    */
    public boolean SiguienteBodega(){
        if(Nodo_bodega_actual.obtenerSiguiente()!= null){
            Nodo_bodega_actual = Nodo_bodega_actual.obtenerSiguiente();
            return true;
        }
        return false;
    }
    
    /**
     * Agrega una bodega al final de la lista.
     */
    
    public void agregarBodega(){
        
    }
    
    public void eliminarBodega(){
        
    }
    
}
