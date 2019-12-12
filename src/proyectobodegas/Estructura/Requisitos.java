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
public class Requisitos {
    private Nodo_Requisito Nodo_requisito_inicial, Nodo_requisito_final, Nodo_requisito_actual;
    private boolean lista_inicializada;
    private int Size;
    
    public Requisitos(){
        Nodo_requisito_inicial = null;
        Nodo_requisito_final = null;
        Nodo_requisito_actual = null;
        lista_inicializada = false;
        Size = 0;
    }
    
    public Nodo_Requisito requisitoActual(){
        return Nodo_requisito_actual;
    }
    
    /**
     * Devuelve el ultimo elemento agregado a la lista.
     * @return Devuelve un objecto del tipo Nodo_Area.
     */
    
    public Nodo_Requisito ultimoAgregado(){
        return Nodo_requisito_final;
    }
    
    public boolean SiguienteRequisito(){
        if(!lista_inicializada){
            Nodo_requisito_actual = Nodo_requisito_inicial;
            lista_inicializada = true;
            if(Size>0){
                return true;
            }
        }
        
        if(Size > 1 ){
            if(Nodo_requisito_actual.obtenerSiguiente()!= null){
                Nodo_requisito_actual = Nodo_requisito_actual.obtenerSiguiente();
                return true;
            }   
        }
        return false;
    }
    
    /**
     * Elimina el elemento actual de la lista.
     */
    
    public void eliminarEstanteActual(){
        Nodo_requisito_actual.obtenerAnterior().definirSiguiente(Nodo_requisito_actual.obtenerSiguiente());
        if(Nodo_requisito_actual.obtenerSiguiente() != null){
            Nodo_requisito_actual.obtenerSiguiente().definirAnterior(Nodo_requisito_actual.obtenerAnterior());
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
     * Recorre la lista hasta el indice indicado y coloca el Nodo_Actual en el elemento Nodo_Requisito correspondiente.
     * @param indice Indice numero al que se desea mover la lista.
     * @return Devuelve TRUE si se encontro el indice de lo contrario devuelve FALSE.
     */
    
    public boolean irAIndice(int indice){
        Nodo_requisito_actual = Nodo_requisito_inicial;
        if(indice == 0 ){
            return true;
        }
        while(SiguienteRequisito()){
            if(Nodo_requisito_actual.obtenerIndice()==indice){
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
        Nodo_Requisito Temporal = Nodo_requisito_inicial;
        if(Size==0){
            return false;
        }else{
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_requisito_actual = Temporal;
                return true;
            }
        }
        
        while(Temporal.obtenerSiguiente()!= null){
            Temporal = Temporal.obtenerSiguiente();
            if(Temporal.obtenerIdentificador().equals(identificador)){
                Nodo_requisito_actual = Temporal;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Agrega un nuevo Requisito al final de la lista.
     * @param identificador Nombre del requisito.
     * @param descripcion Desccripcion del requisito.
     */
    
    public void agregarRequisito(String identificador, String descripcion){
        Nodo_Requisito Nuevo_requisito = new Nodo_Requisito(Size,identificador,descripcion);
        if(Nodo_requisito_inicial==null){
            Nodo_requisito_inicial = Nuevo_requisito;
            Nodo_requisito_final = Nuevo_requisito;
            Nodo_requisito_actual = Nuevo_requisito;
        }else{
            Nuevo_requisito.definirAnterior(Nodo_requisito_final);
            Nodo_requisito_final.definirSiguiente(Nuevo_requisito);
            Nodo_requisito_final = Nuevo_requisito;
        }
        Size++;
    }
    
    /**
     * Elimina el elemento actual de la lista.
     */
    
    public void eliminarRequisitoActual(){
        if(Nodo_requisito_actual.obtenerAnterior() != null){
            Nodo_requisito_actual.obtenerAnterior().definirSiguiente(Nodo_requisito_actual.obtenerSiguiente());
        }
        if(Nodo_requisito_actual.obtenerSiguiente()!=null){
            Nodo_requisito_actual.obtenerSiguiente().definirAnterior(Nodo_requisito_actual.obtenerAnterior());
        }
        Nodo_requisito_actual = null;
        Size--;
    }
    
    /**
     * Busca del indice indicado sin mover el Nodo_Bodega Actual.
     * @param identificador Indice numerico que se desea buscar.
     * @return Devuelve TRUE si el indice existe de lo contrario devuelve FALSE.
     */
    
    public boolean buscarPorIdentificador(String identificador){
        Nodo_Requisito Temporal = Nodo_requisito_inicial;
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
