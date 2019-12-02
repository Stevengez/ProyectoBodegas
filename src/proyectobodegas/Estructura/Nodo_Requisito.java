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
public class Nodo_Requisito {
    
    private Nodo_Requisito Nodo_requisito_siguiente, Nodo_requisito_anterior;
    
    public Nodo_Requisito(){
        Nodo_requisito_siguiente = null;
        Nodo_requisito_anterior = null;
    }
    
    public Nodo_Requisito obtenerSiguiente(){
        return Nodo_requisito_siguiente;
    }
    
    public Nodo_Requisito obtenerAnterior(){
        return Nodo_requisito_anterior;
    }
    
}
