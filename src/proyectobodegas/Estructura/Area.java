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
    private Nodo_Area Nodo_area_inicial, Nodo_area_final, Nodo_area_actual;  
    private boolean lista_inicializada;
    private int Size;
    
    /**
     * Lista de Bodegas.
     */
    
    public Area(){
        Size = 0;
        Nodo_area_inicial = null;
        Nodo_area_final = null;
        Nodo_area_actual = null;
        lista_inicializada = false;
    }
    
    /**
     * Devuelve el ultimo elemento agregado a la lista.
     * @return Devuelve un objecto del tipo Nodo_Area.
     */
    
    public Nodo_Area ultimaAgregada(){
        return Nodo_area_final;
    }
    
    /**
     * Devuelve el elemento actual de la lista.
     * @return Devuelve un objecto del tipo Nodo_Area.
     */
    
    public Nodo_Area areaActual(){
        return Nodo_area_actual;
    }
    
    /**
     * Mueve el cursor a la siguiente Area.
     * @return Devuelve TRUE si el puntero pudo avanzar a la siguiente Area y FALSE si ya no hay mas bodegas.
    */    
    public boolean SiguienteArea(){
        if(!lista_inicializada){
            Nodo_area_actual = Nodo_area_inicial;
            lista_inicializada = true;
            return true;
        }else if(Size > 0 ){
            if(Nodo_area_actual.obtenerSiguiente()!= null){
                Nodo_area_actual = Nodo_area_actual.obtenerSiguiente();
                return true;
            }   
        }
        return false;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param nombre_bodega Nombre de la nueva Area.
     */
    
    public void agregarArea(String nombre_bodega){
        Nodo_Area Nueva_Area = new Nodo_Area(Size,nombre_bodega);
        if(Nodo_area_inicial==null){
            Nodo_area_inicial = Nueva_Area;
            Nodo_area_final = Nueva_Area;
        }else{
            Nueva_Area.definirAnterior(Nodo_area_final);
            Nodo_area_final.definirSiguiente(Nueva_Area);
            Nodo_area_final = Nueva_Area;
        }
        Size++;
    }
    
    /**
     * Elimina el elemento actual de la lista.
     */
    
    public void eliminarAreaActual(){
        Nodo_area_actual.obtenerAnterior().definirSiguiente(Nodo_area_actual.obtenerSiguiente());
        if(Nodo_area_actual.obtenerSiguiente() != null){
            Nodo_area_actual.obtenerSiguiente().definirAnterior(Nodo_area_actual.obtenerAnterior());
        }        
    }
    
    /**
     * Eliminar la Area en el indice proporcionado.
     * @param indice 
     */
    
    public void eliminarEnIndice(int indice){
        if(irAIndice(indice)){
            eliminarAreaActual();
        }
    }
    
    /**
     * Recorre la lista hasta el indice indicado y coloca el Nodo_Actual en el elemento Nodo_Area correspondiente.
     * @param indice Indice numero al que se desea mover la lista.
     * @return Devuelve TRUE si se encontro el indice de lo contrario devuelve FALSE.
     */
    
    public boolean irAIndice(int indice){
        Nodo_area_actual = Nodo_area_inicial;
        while(SiguienteArea()){
            if(Nodo_area_actual.obtenerIndice()==indice){
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
                Nodo_area_actual = Temporal;
                return true;
            }
        }
        
        while(Temporal.obtenerSiguiente()!= null){
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_area_actual = Temporal;
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
