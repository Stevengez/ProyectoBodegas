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
public class Nodo_Producto {
    
    private Nodo_Producto Nodo_producto_siguiente, Nodo_producto_anterior;
    
    public Nodo_Producto(){
        Nodo_producto_siguiente = null;
        Nodo_producto_anterior = null;
    }
    
    /**
     * Devuelve un elemento del tipo Nodo_Producto.
     * @return Devuelve un objecto Nodo_Producto correspondiente al siguiente nodo o NULL si no hay mas.
     */
    
    public Nodo_Producto obtenerSiguiente(){
        return Nodo_producto_siguiente;
    }
    
    /**
     * Devuelve un elemento del tipo Nodo_Producto.
     * @return Devuelve un objecto Nodo_Producto correspondiente al nodo anterior o NULL si no hay mas.
     */
    
    public Nodo_Producto obtenerAnterior(){
        return Nodo_producto_anterior;
    }
    
}
