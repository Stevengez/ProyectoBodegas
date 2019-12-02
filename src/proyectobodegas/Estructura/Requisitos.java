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
    
}
