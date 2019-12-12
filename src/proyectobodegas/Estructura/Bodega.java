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
    
    private Nodo_Bodega Nodo_bodega_inicial, Nodo_bodega_final, Nodo_bodega_actual;  
    private boolean lista_inicializada;
    private int Size;
    
    /**
     * Lista de Bodegas.
     */
    
    public Bodega(){
        Size = 0;
        Nodo_bodega_inicial = null;
        Nodo_bodega_final = null;
        Nodo_bodega_actual = null;
        lista_inicializada = false;
    }
    
    /**
     * Devuelve el ultimo elemento agregado a la lista.
     * @return Devuelve un objecto del tipo Nodo_Area.
     */
    
    public Nodo_Bodega ultimaAgregada(){
        return Nodo_bodega_final;
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
        if(!lista_inicializada){
            Nodo_bodega_actual = Nodo_bodega_inicial;
            lista_inicializada = true;
            if(Size>0){
                return true;
            }
        }
        
        if(Size > 1 ){
            if(Nodo_bodega_actual.obtenerSiguiente()!= null){
                Nodo_bodega_actual = Nodo_bodega_actual.obtenerSiguiente();
                return true;
            }   
        }
        return false;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param nombre_bodega Nombre de la nueva Bodega.
     */
    
    public void agregarBodega(String nombre_bodega){
        Nodo_Bodega Nueva_bodega = new Nodo_Bodega(Size,nombre_bodega);
        if(Nodo_bodega_inicial==null){
            Nodo_bodega_inicial = Nueva_bodega;
            Nodo_bodega_final = Nueva_bodega;
            Nodo_bodega_actual = Nueva_bodega;
        }else{
            Nueva_bodega.definirAnterior(Nodo_bodega_final);
            Nodo_bodega_final.definirSiguiente(Nueva_bodega);
            Nodo_bodega_final = Nueva_bodega;
        }
        Size++;
    }
    
    /**
     * Elimina el elemento actual de la lista.
     */
    
    public void eliminarBodegaActual(){
        Nodo_bodega_actual.obtenerAnterior().definirSiguiente(Nodo_bodega_actual.obtenerSiguiente());
        if(Nodo_bodega_actual.obtenerSiguiente() != null){
            Nodo_bodega_actual.obtenerSiguiente().definirAnterior(Nodo_bodega_actual.obtenerAnterior());
        }        
    }
    
    /**
     * Eliminar la bodega en el indice proporcionado.
     * @param indice 
     */
    
    public void eliminarEnIndice(int indice){
        if(irAIndice(indice)){
            eliminarBodegaActual();
        }
    }
    
    /**
     * Recorre la lista hasta el indice indicado y coloca el Nodo_Actual en el elemento Nodo_Bodega correspondiente.
     * @param indice Indice numero al que se desea mover la lista.
     * @return Devuelve TRUE si se encontro el indice de lo contrario devuelve FALSE.
     */
    
    public boolean irAIndice(int indice){
        Nodo_bodega_actual = Nodo_bodega_inicial;
        if(indice == 0 ){
            return true;
        }
        while(SiguienteBodega()){
            if(Nodo_bodega_actual.obtenerIndice()==indice){
                return true;
            }
        }
        return false;
    }
        
    /**
     * Recorre la lista hasta encontrar una bodega con el nombre proporcionado y la coloca en el elemento actual.
     * @param identificador Nombre de la bodega
     * @return Devuelve TRUE si existe una bodega con ese identificador o FALSE de lo contrario.
     */
    
    public boolean irAIdentificador(String identificador){
        Nodo_Bodega Temporal = Nodo_bodega_inicial;
        if(Size==0){
            return false;
        }else{
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_bodega_actual = Temporal;
                return true;
            }
        }
        
        while(Temporal.obtenerSiguiente()!= null){
            Temporal = Temporal.obtenerSiguiente();
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_bodega_actual = Temporal;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Busca del indice indicado sin mover el Nodo_Bodega Actual.
     * @param identificador Indice numerico que se desea buscar.
     * @return Devuelve TRUE si el indice existe de lo contrario devuelve FALSE.
     */
    
    public boolean buscarPorIdentificador(String identificador){
        Nodo_Bodega Temporal = Nodo_bodega_inicial;
        if(Size==0){
            return false;
        }else{
            if(Temporal.obtenerIdentificador().equals(identificador)){
                return true;
            }
        }
        
        while(Temporal.obtenerSiguiente()!= null){
            Temporal = Temporal.obtenerSiguiente();
            if(Temporal.obtenerIdentificador().equals(identificador)){
                return true;
            }
        }
        return false;
    }
    
    public int obtenerSize(){
        return Size;
    }
    
    /**
     * Reinicia la lista para poder recorrerla desde el inicio
     */
    public void reiniciarLista(){
        lista_inicializada = false;
    }
}
