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
public class Seccion {
    private Nodo_Seccion Nodo_seccion_inicial, Nodo_seccion_final, Nodo_seccion_actual;  
    private boolean lista_inicializada;
    private int Size;
    
    /**
     * Lista de Bodegas.
     */
    
    public Seccion(){
        Size = 0;
        Nodo_seccion_inicial = null;
        Nodo_seccion_final = null;
        Nodo_seccion_actual = null;
        lista_inicializada = false;
    }
    
    /**
     * Devuelve el ultimo elemento agregado a la lista.
     * @return Devuelve un objecto del tipo Nodo_Area.
     */
    
    public Nodo_Seccion ultimaAgregada(){
        return Nodo_seccion_final;
    }
    
    /**
     * Devuelve el elemento actual de la lista.
     * @return Devuelve un objecto del tipo Nodo_Seccion.
     */
    
    public Nodo_Seccion seccionActual(){
        return Nodo_seccion_actual;
    }
    
    /**
     * Mueve el cursor a la siguiente Seccion.
     * @return Devuelve TRUE si el puntero pudo avanzar a la siguiente Seccion y FALSE si ya no hay mas bodegas.
    */    
    public boolean SiguienteSeccion(){
        if(!lista_inicializada){
            Nodo_seccion_actual = Nodo_seccion_inicial;
            lista_inicializada = true;
            return true;
        }else if(Size > 0 ){
            if(Nodo_seccion_actual.obtenerSiguiente()!= null){
                Nodo_seccion_actual = Nodo_seccion_actual.obtenerSiguiente();
                return true;
            }   
        }
        return false;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param nombre_seccion Nombre de la nueva Seccion.
     */
    
    public void agregarSeccion(String nombre_seccion){
        Nodo_Seccion Nueva_seccion = new Nodo_Seccion(Size,nombre_seccion);
        if(Nodo_seccion_inicial==null){
            Nodo_seccion_inicial = Nueva_seccion;
            Nodo_seccion_final = Nueva_seccion;
        }else{
            Nueva_seccion.definirAnterior(Nodo_seccion_final);
            Nodo_seccion_final.definirSiguiente(Nueva_seccion);
            Nodo_seccion_final = Nueva_seccion;
        }
        Size++;
    }
    
    /**
     * Elimina el elemento actual de la lista.
     */
    
    public void eliminarSeccionActual(){
        Nodo_seccion_actual.obtenerAnterior().definirSiguiente(Nodo_seccion_actual.obtenerSiguiente());
        if(Nodo_seccion_actual.obtenerSiguiente() != null){
            Nodo_seccion_actual.obtenerSiguiente().definirAnterior(Nodo_seccion_actual.obtenerAnterior());
        }        
    }
    
    /**
     * Eliminar la Seccion en el indice proporcionado.
     * @param indice 
     */
    
    public void eliminarEnIndice(int indice){
        if(irAIndice(indice)){
            eliminarSeccionActual();
        }
    }
    
    /**
     * Recorre la lista hasta el indice indicado y coloca el Nodo_Actual en el elemento Nodo_Seccion correspondiente.
     * @param indice Indice numero al que se desea mover la lista.
     * @return Devuelve TRUE si se encontro el indice de lo contrario devuelve FALSE.
     */
    
    public boolean irAIndice(int indice){
        Nodo_seccion_actual = Nodo_seccion_inicial;
        while(SiguienteSeccion()){
            if(Nodo_seccion_actual.obtenerIndice()==indice){
                return true;
            }
        }
        return false;
    }
        
    /**
     * Recorre la lista hasta encontrar una Seccion con el nombre proporcionado y la coloca en el elemento actual.
     * @param identificador Nombre de la Seccion
     * @return Devuelve TRUE si existe una Seccion con ese identificador o FALSE de lo contrario.
     */
    
    public boolean irAIdentificador(String identificador){
        Nodo_Seccion Temporal = Nodo_seccion_inicial;
        if(Size==0){
            return false;
        }else{
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_seccion_actual = Temporal;
                return true;
            }
        }
        
        while(Temporal.obtenerSiguiente()!= null){
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_seccion_actual = Temporal;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Busca del indice indicado sin mover el Nodo_Seccion Actual.
     * @param identificador Indice numerico que se desea buscar.
     * @return Devuelve TRUE si el indice existe de lo contrario devuelve FALSE.
     */
    
    public boolean buscarPorIdentificador(String identificador){
        Nodo_Seccion Temporal = Nodo_seccion_inicial;
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
