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
public class Productos {
    private Nodo_Producto Nodo_producto_inicial, Nodo_producto_final, Nodo_producto_actual;
    private int Size;
    
    public Productos(){
        Size = 0;
        Nodo_producto_inicial = null;
        Nodo_producto_final = null;
    }
    
    /**
     * Devuelve un elemento del tipo Nodo_Producto.
     * @return Devuelve el objecto Nodo_Producto actual de la lista. 
     */
    public Nodo_Producto productoActual(){
        return Nodo_producto_actual;
    }
    
    /**
     * Mueve el cursor al siguiente producto de la lista si existe.
     * @return Devuelve TRUE si hay un producto siguiente y FALSE si no existen un siguiente.
     */
    public boolean siguienteProducto(){
        if(Nodo_producto_actual.obtenerSiguiente()!=null){
            Nodo_producto_actual = Nodo_producto_actual.obtenerSiguiente();
            return true;
        }
        return false;
    }
    
}
