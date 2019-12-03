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
public class Estante {
    
    private Nodo_Estante Nodo_estante_inicial, Nodo_estante_final, Nodo_estante_actual;  
    private boolean lista_inicializada;
    private int Size;
    
    /**
     * Lista de Bodegas.
     */
    
    public Estante(){
        Size = 0;
        Nodo_estante_inicial = null;
        Nodo_estante_final = null;
        Nodo_estante_actual = null;
        lista_inicializada = false;
    }
    
    /**
     * Devuelve el ultimo elemento agregado a la lista.
     * @return Devuelve un objecto del tipo Nodo_Area.
     */
    
    public Nodo_Estante ultimoAgregado(){
        return Nodo_estante_final;
    }
    
    /**
     * Devuelve el elemento actual (ultimo agregado) de la lista.
     * @return Devuelve un objecto del tipo Nodo_Estante.
     */
    
    public Nodo_Estante estanteActual(){
        return Nodo_estante_actual;
    }
    
    /**
     * Mueve el cursor a la siguiente Estante.
     * @return Devuelve TRUE si el puntero pudo avanzar a la siguiente Estante y FALSE si ya no hay mas bodegas.
    */
    public boolean SiguienteEstante(){
        if(!lista_inicializada){
            Nodo_estante_actual = Nodo_estante_inicial;
            lista_inicializada = true;
        }
        
        if(Size > 0 ){
            if(Nodo_estante_actual.obtenerSiguiente()!= null){
                Nodo_estante_actual = Nodo_estante_actual.obtenerSiguiente();
                return true;
            }   
        }
        return false;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param nombre_estante Nombre de la nueva Estante.
     */
    
    public void agregarEstante(String nombre_estante){
        Nodo_Estante Nuevo_Estante = new Nodo_Estante(Size,nombre_estante);
        if(Nodo_estante_inicial==null){
            Nodo_estante_inicial = Nuevo_Estante;
            Nodo_estante_final = Nuevo_Estante;
        }else{
            Nuevo_Estante.definirAnterior(Nodo_estante_final);
            Nodo_estante_final.definirSiguiente(Nuevo_Estante);
            Nodo_estante_final = Nuevo_Estante;
        }
        Size++;
    }
    
    /**
     * Elimina el elemento actual de la lista.
     */
    
    public void eliminarEstanteActual(){
        Nodo_estante_actual.obtenerAnterior().definirSiguiente(Nodo_estante_actual.obtenerSiguiente());
        if(Nodo_estante_actual.obtenerSiguiente() != null){
            Nodo_estante_actual.obtenerSiguiente().definirAnterior(Nodo_estante_actual.obtenerAnterior());
        }        
    }
    
    /**
     * Eliminar la Estante en el indice proporcionado.
     * @param indice 
     */
    
    public void eliminarEnIndice(int indice){
        if(irAIndice(indice)){
            eliminarEstanteActual();
        }
    }
    
    /**
     * Recorre la lista hasta el indice indicado y coloca el Nodo_Actual en el elemento Nodo_Estante correspondiente.
     * @param indice Indice numero al que se desea mover la lista.
     * @return Devuelve TRUE si se encontro el indice de lo contrario devuelve FALSE.
     */
    
    public boolean irAIndice(int indice){
        Nodo_estante_actual = Nodo_estante_inicial;
        while(SiguienteEstante()){
            if(Nodo_estante_actual.obtenerIndice()==indice){
                return true;
            }
        }
        return false;
    }
        
    /**
     * Recorre la lista hasta encontrar una Estante con el nombre proporcionado y la coloca en el elemento actual.
     * @param identificador Nombre de la Estante
     * @return Devuelve TRUE si existe una Estante con ese identificador o FALSE de lo contrario.
     */
    
    public boolean irAIdentificador(String identificador){
        Nodo_Estante Temporal = Nodo_estante_inicial;
        if(Size==0){
            return false;
        }else{
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_estante_actual = Temporal;
                return true;
            }
        }
        
        while(Temporal.obtenerSiguiente()!= null){
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_estante_actual = Temporal;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Busca del indice indicado sin mover el Nodo_Estante Actual.
     * @param identificador Indice numerico que se desea buscar.
     * @return Devuelve TRUE si el indice existe de lo contrario devuelve FALSE.
     */
    
    public boolean buscarPorIdentificador(String identificador){
        Nodo_Estante Temporal = Nodo_estante_inicial;
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
