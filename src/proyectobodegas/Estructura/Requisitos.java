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
    private int Size;
    
    public Requisitos(){
        Nodo_requisito_inicial = null;
        Nodo_requisito_final = null;
        Nodo_requisito_actual = null;
        Size = 0;
    }
    
    public Nodo_Requisito requisitoActual(){
        return Nodo_requisito_actual;
    }
    
    public boolean siguienteRequisito(){
        if(Nodo_requisito_actual.obtenerSiguiente() != null){
            Nodo_requisito_actual = Nodo_requisito_actual.obtenerSiguiente();
            return true;
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
        }else{
            Nodo_requisito_final.definirSiguiente(Nuevo_requisito);
            Nuevo_requisito.definirAnterior(Nodo_requisito_final);
            Nodo_requisito_final = Nuevo_requisito;
        }
        Size++;
    }
    
    /**
     * Elimina el elemento actual de la lista.
     */
    
    public void eliminarRequisitoActual(){
        Nodo_requisito_actual.obtenerAnterior().definirSiguiente(Nodo_requisito_actual.obtenerSiguiente());
        if(Nodo_requisito_actual.obtenerSiguiente()!=null){
            Nodo_requisito_actual.obtenerSiguiente().definirAnterior(Nodo_requisito_actual.obtenerAnterior());
        }
    }
    
}
