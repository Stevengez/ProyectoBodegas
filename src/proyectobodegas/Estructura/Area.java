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
public class Area {
    private Nodo_Area Nodo_area_inicial, Nodo_producto_final, Nodo_producto_actual;  
    private int Size;
    
    /**
     * Lista de Bodegas.
     */
    
    public Area(){
        Size = 0;
        Nodo_area_inicial = null;
        Nodo_producto_final = null;
        Nodo_producto_actual = null;
    }
    
    /**
     * Devuelve el elemento actual de la lista.
     * @return Devuelve un objecto del tipo Nodo_Area.
     */
    
    public Nodo_Area areaActual(){
        return Nodo_producto_actual;
    }
    
    /**
     * Mueve el cursor a la siguiente Area.
     * @return Devuelve TRUE si el puntero pudo avanzar a la siguiente Area y FALSE si ya no hay mas bodegas.
    */
    public boolean SiguienteArea(){
        if(Nodo_producto_actual.obtenerSiguiente()!= null){
            Nodo_producto_actual = Nodo_producto_actual.obtenerSiguiente();
            return true;
        }
        return false;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param nombre_bodega Nombre de la nueva Area.
     */
    
    public void agregarBodega(String nombre_bodega){
        Nodo_Area Nueva_bodega = new Nodo_Area(Size,nombre_bodega);
        if(Nodo_area_inicial==null){
            Nodo_area_inicial = Nueva_bodega;
            Nodo_producto_final = Nueva_bodega;
        }else{
            Nueva_bodega.definirAnterior(Nodo_producto_final);
            Nodo_producto_final.definirSiguiente(Nueva_bodega);
            Nodo_producto_final = Nueva_bodega;
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
     * Eliminar la Area en el indice proporcionado.
     * @param indice 
     */
    
    public void eliminarEnIndice(int indice){
        if(irAIndice(indice)){
            eliminarProductoActual();
        }
    }
    
    /**
     * Recorre la lista hasta el indice indicado y coloca el Nodo_Actual en el elemento Nodo_Area correspondiente.
     * @param indice Indice numero al que se desea mover la lista.
     * @return Devuelve TRUE si se encontro el indice de lo contrario devuelve FALSE.
     */
    
    public boolean irAIndice(int indice){
        Nodo_producto_actual = Nodo_area_inicial;
        while(SiguienteArea()){
            if(Nodo_producto_actual.obtenerIndice()==indice){
                return true;
            }
        }
        return false;
    }
        
    /**
     * Recorre la lista hasta encontrar una Area con el nombre proporcionado y la coloca en el elemento actual.
     * @param identificador Nombre de la Area
     * @return Devuelve TRUE si existe una Area con ese identificador o FALSE de lo contrario.
     */
    
    public boolean irAIdentificador(String identificador){
        Nodo_Area Temporal = Nodo_area_inicial;
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
     * Busca del indice indicado sin mover el Nodo_Area Actual.
     * @param identificador Indice numerico que se desea buscar.
     * @return Devuelve TRUE si el indice existe de lo contrario devuelve FALSE.
     */
    
    public boolean buscarPorIdentificador(String identificador){
        Nodo_Area Temporal = Nodo_area_inicial;
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
