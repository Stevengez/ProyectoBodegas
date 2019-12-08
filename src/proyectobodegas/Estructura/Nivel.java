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
public class Nivel {
    
    private Nodo_Nivel Nodo_nivel_inicial, Nodo_nivel_final, Nodo_nivel_actual;
    private boolean lista_inicializada;
    private int Size;
    
    /**
     * Lista de Bodegas.
     */
    
    public Nivel(){
        Nodo_nivel_inicial = null;
        Nodo_nivel_final = null;
        Nodo_nivel_actual = null;
        lista_inicializada = false;
        Size = 0;
    }
    
    /**
     * Devuelve el ultimo elemento agregado a la lista.
     * @return Devuelve un objecto del tipo Nodo_Area.
     */
    
    public Nodo_Nivel ultimoAgregado(){
        return Nodo_nivel_final;
    }
    
    /**
     * Devuelve el elemento actual de la lista.
     * @return Devuelve un objecto del tipo Nodo_Nivel.
     */
    
    public Nodo_Nivel nivelActual(){
        return Nodo_nivel_actual;
    }
    
    /**
     * Mueve el cursor a la siguient nivel.
     * @return Devuelve TRUE si el puntero pudo avanzar a la siguient nivel y FALSE si ya no hay mas bodegas.
    */    
    public boolean SiguienteNivel(){
        if(!lista_inicializada){
            Nodo_nivel_actual = Nodo_nivel_inicial;
            lista_inicializada = true;
            if(Size>0){
                return true;
            }
        }
        if(Size > 1 ){
            if(Nodo_nivel_actual.obtenerSiguiente()!= null){
                Nodo_nivel_actual = Nodo_nivel_actual.obtenerSiguiente();
                return true;
            }   
        }
        return false;
    }
    
    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param nombre_nivel Nombre de la nuev nivel.
     */
    
    public void agregarNivel(String nombre_nivel){
        Nodo_Nivel Nuevo_nivel = new Nodo_Nivel(Size,nombre_nivel);
        if(Nodo_nivel_inicial==null){
            Nodo_nivel_inicial = Nuevo_nivel;
            Nodo_nivel_final = Nuevo_nivel;
        }else{
            Nuevo_nivel.definirAnterior(Nodo_nivel_final);
            Nodo_nivel_final.definirSiguiente(Nuevo_nivel);
            Nodo_nivel_final = Nuevo_nivel;
        }
        Size++;
    }
    
    /**
     * Elimina el elemento actual de la lista.
     */
    
    public void eliminarNivelActual(){
        Nodo_nivel_actual.obtenerAnterior().definirSiguiente(Nodo_nivel_actual.obtenerSiguiente());
        if(Nodo_nivel_actual.obtenerSiguiente() != null){
            Nodo_nivel_actual.obtenerSiguiente().definirAnterior(Nodo_nivel_actual.obtenerAnterior());
        }        
    }
    
    /**
     * Eliminar l nivel en el indice proporcionado.
     * @param indice 
     */
    
    public void eliminarEnIndice(int indice){
        if(irAIndice(indice)){
            eliminarNivelActual();
        }
    }
    
    /**
     * Recorre la lista hasta el indice indicado y coloca el Nodo_Actual en el elemento Nodo_Nivel correspondiente.
     * @param indice Indice numero al que se desea mover la lista.
     * @return Devuelve TRUE si se encontro el indice de lo contrario devuelve FALSE.
     */
    
    public boolean irAIndice(int indice){
        Nodo_nivel_actual = Nodo_nivel_inicial;
        if(indice == 0 ){
            return true;
        }
        while(SiguienteNivel()){
            if(Nodo_nivel_actual.obtenerIndice()==indice){
                return true;
            }
        }
        return false;
    }
        
    /**
     * Recorre la lista hasta encontrar un nivel con el nombre proporcionado y la coloca en el elemento actual.
     * @param identificador Nombre del nivel
     * @return Devuelve TRUE si existe un nivel con ese identificador o FALSE de lo contrario.
     */
    
    public boolean irAIdentificador(String identificador){
        Nodo_Nivel Temporal = Nodo_nivel_inicial;
        if(Size==0){
            return false;
        }else{
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_nivel_actual = Temporal;
                return true;
            }
        }
        
        while(Temporal.obtenerSiguiente()!= null){
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_nivel_actual = Temporal;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Busca del indice indicado sin mover el Nodo_Nivel Actual.
     * @param identificador Indice numerico que se desea buscar.
     * @return Devuelve TRUE si el indice existe de lo contrario devuelve FALSE.
     */
    
    public boolean buscarPorIdentificador(String identificador){
        Nodo_Nivel Temporal = Nodo_nivel_inicial;
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
    
    /**
     * Reinicia la lista para poder recorrerla desde el inicio
     */
    public void reiniciarLista(){
        lista_inicializada = false;
    }
}
