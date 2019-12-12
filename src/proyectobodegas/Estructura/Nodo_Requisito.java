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
public class Nodo_Requisito {
    
    private Nodo_Requisito Nodo_requisito_siguiente, Nodo_requisito_anterior;
    private String identificador, descripcion;
    private int indice;
    
    public Nodo_Requisito(int index, String identificador, String descripcion){
        Nodo_requisito_siguiente = null;
        Nodo_requisito_anterior = null;
        
        this.indice = indice;
        this.identificador = identificador;
        this.descripcion = descripcion;
    }
    
    public Nodo_Requisito obtenerSiguiente(){
        return Nodo_requisito_siguiente;
    }
    
    public Nodo_Requisito obtenerAnterior(){
        return Nodo_requisito_anterior;
    }
    
    public String obtenerIdentificador(){
        return identificador;
    }
    
    public String obtenerDescripcion(){
        return descripcion;
    }
    
    public int obtenerIndice(){
        return indice;
    }
    
    public void definirSiguiente(Nodo_Requisito siguiente){
        Nodo_requisito_siguiente = siguiente;
    }
    
    public void definirAnterior(Nodo_Requisito anterior){
        Nodo_requisito_anterior = anterior;
    }
    
    public void definirIdentificador(String identificador){
        this.identificador = identificador;
    }
    
    public void definirDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void definirIndice(int indice){
        this.indice = indice;
    }
}
