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
public class Productos {
    private Nodo_Producto Nodo_producto_inicial, Nodo_producto_final, Nodo_producto_actual;  
    private boolean lista_inicializada;
    private int Size;
    
    /**
     * Lista de Bodegas.
     */
    
    public Productos(){
        Size = 0;
        Nodo_producto_inicial = null;
        Nodo_producto_final = null;
        Nodo_producto_actual = null;
        lista_inicializada = false;
    }
    
    /**
     * Devuelve el ultimo elemento agregado a la lista.
     * @return Devuelve un objecto del tipo Nodo_Area.
     */
    
    public Nodo_Producto ultimoAgregado(){
        return Nodo_producto_final;
    }
    
    /**
     * Devuelve el elemento actual de la lista.
     * @return Devuelve un objecto del tipo Nodo_Producto.
     */
    
    public Nodo_Producto productoActual(){
        return Nodo_producto_actual;
    }
    
    /**
     * Mueve el cursor a la siguiente Productos.
     * @return Devuelve TRUE si el puntero pudo avanzar a la siguiente Productos y FALSE si ya no hay mas bodegas.
    */
    public boolean SiguienteProducto(){
        if(!lista_inicializada){
            Nodo_producto_actual = Nodo_producto_inicial;
            lista_inicializada = true;
        }
        if(Size > 0 ){
            if(Nodo_producto_actual.obtenerSiguiente()!= null){
                Nodo_producto_actual = Nodo_producto_actual.obtenerSiguiente();
                return true;
            }   
        }
        return false;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param nombre_producto Nombre de la nueva Productos.
     */
    
    public void agregarProducto(String nombre_producto){
        Nodo_Producto Nuevo_Producto = new Nodo_Producto(Size,nombre_producto);
        if(Nodo_producto_inicial==null){
            Nodo_producto_inicial = Nuevo_Producto;
            Nodo_producto_final = Nuevo_Producto;
        }else{
            Nuevo_Producto.definirAnterior(Nodo_producto_final);
            Nodo_producto_final.definirSiguiente(Nuevo_Producto);
            Nodo_producto_final = Nuevo_Producto;
        }
        Size++;
    }
    
    /**
     * Elimina el elemento actual de la lista.
     */
    
    public void eliminarProductoActual(){
        Nodo_producto_actual.obtenerAnterior().definirSiguiente(Nodo_producto_actual.obtenerSiguiente());
        if(Nodo_producto_actual.obtenerSiguiente() != null){
            Nodo_producto_actual.obtenerSiguiente().definirAnterior(Nodo_producto_actual.obtenerAnterior());
        }        
    }
    
    /**
     * Eliminar la Productos en el indice proporcionado.
     * @param indice 
     */
    
    public void eliminarEnIndice(int indice){
        if(irAIndice(indice)){
            eliminarProductoActual();
        }
    }
    
    /**
     * Recorre la lista hasta el indice indicado y coloca el Nodo_Actual en el elemento Nodo_Producto correspondiente.
     * @param indice Indice numero al que se desea mover la lista.
     * @return Devuelve TRUE si se encontro el indice de lo contrario devuelve FALSE.
     */
    
    public boolean irAIndice(int indice){
        Nodo_producto_actual = Nodo_producto_inicial;
        while(SiguienteProducto()){
            if(Nodo_producto_actual.obtenerIndice()==indice){
                return true;
            }
        }
        return false;
    }
        
    /**
     * Recorre la lista hasta encontrar una Productos con el nombre proporcionado y la coloca en el elemento actual.
     * @param identificador Nombre de la Productos
     * @return Devuelve TRUE si existe una Productos con ese identificador o FALSE de lo contrario.
     */
    
    public boolean irAIdentificador(String identificador){
        Nodo_Producto Temporal = Nodo_producto_inicial;
        if(Size==0){
            return false;
        }else{
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_producto_actual = Temporal;
                return true;
            }
        }
        
        while(Temporal.obtenerSiguiente()!= null){
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_producto_actual = Temporal;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Busca del indice indicado sin mover el Nodo_Producto Actual.
     * @param identificador Indice numerico que se desea buscar.
     * @return Devuelve TRUE si el indice existe de lo contrario devuelve FALSE.
     */
    
    public boolean buscarPorIdentificador(String identificador){
        Nodo_Producto Temporal = Nodo_producto_inicial;
        if(Size==0){
            return false;
        }else{
            if(Temporal.obtenerIdentificador().equals(identificador)){
                return true;
            }
        }
        
        while(Temporal.obtenerSiguiente()!= null){
            if(Temporal.obtenerIdentificador().equals(identificador)){
                return true;
            }
        }
        return false;
    }
    
}
