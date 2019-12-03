/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobodegas.Estructura;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven Jocol
 */
public class Nodo_Producto {
    
    private Nodo_Producto Nodo_producto_siguiente, Nodo_producto_anterior;
    private ArrayList<Integer> Requisitos;
    private String identificador;
    private int indice;
    
    public Nodo_Producto(int indice, String identificador){
        Nodo_producto_siguiente = null;
        Nodo_producto_anterior = null;
        Requisitos = new ArrayList<>();
        this.indice = indice;
        this.identificador = identificador;
    }
    
    
    /**
     * Obtiene un elemento de la lista Producto (Nodo_Producto).
     * @return Devuelve el Nodo_Producto siguiente o NULL si no hay mas nodos. 
     */
    
    public Nodo_Producto obtenerSiguiente(){
        return Nodo_producto_siguiente;
    }
    
    /**
     * Obtiene un elemento de la lista Producto (Nodo_Producto).
     * @return Devuelve el Nodo_Producto anterior o NULL si no hay mas nodos.
     */
    
    public Nodo_Producto obtenerAnterior(){
        return Nodo_producto_anterior;
    }
    
    public void definirSiguiente(Nodo_Producto siguiente){
        Nodo_producto_siguiente = siguiente;
    }
    
    public void definirAnterior(Nodo_Producto anterior){
        Nodo_producto_anterior = anterior;
    }
    
    public int obtenerIndice(){
        return indice;
    }
    
    public String obtenerIdentificador(){
        return identificador;
    }
    
    public void agregarRequisito(int indice_requisito, boolean restriccion){
        if(restriccion){
            Requisitos.add(indice_requisito*-1);
        }else{
            Requisitos.add(indice_requisito);
        }
    }
}
