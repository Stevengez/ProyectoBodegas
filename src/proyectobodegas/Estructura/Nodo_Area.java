/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobodegas.Estructura;

import java.util.ArrayList;

/**
 *
 * @author Steven Jocol
 */
public class Nodo_Area {
    private Nodo_Area Nodo_area_siguiente, Nodo_area_anterior;
    private Estante Lista_Estantes;
    private ArrayList<Integer> Caracteristicas_de_area;
    private String identificador;
    private int indice;
    
    public Nodo_Area(int indice, String identificador){
        Nodo_area_siguiente = null;
        Nodo_area_anterior = null;
        Lista_Estantes = new Estante();
        Caracteristicas_de_area = new ArrayList<>();
        
        this.indice = indice;
        this.identificador = identificador;
    }
    
    /**
     * Obtiene un elemento de la lista Area (Nodo_Area).
     * @return Devuelve el Nodo_Area siguiente o NULL si no hay mas nodos. 
     */
    
    public Nodo_Area obtenerSiguiente(){
        return Nodo_area_siguiente;
    }
    
    /**
     * Obtiene un elemento de la lista Area (Nodo_Area).
     * @return Devuelve el Nodo_Area anterior o NULL si no hay mas nodos.
     */
    
    public Nodo_Area obtenerAnterior(){
        return Nodo_area_anterior;
    }
    
    public void definirSiguiente(Nodo_Area siguiente){
        Nodo_area_siguiente = siguiente;
    }
    
    public void definirAnterior(Nodo_Area anterior){
        Nodo_area_anterior = anterior;
    }
    
    public int obtenerIndice(){
        return indice;
    }
    
    public String obtenerIdentificador(){
        return identificador;
    }
    
    public Estante Estantes(){
        return Lista_Estantes;
    }
    
    public void agregarCaracteristica(int indice_caracteristica){
        Caracteristicas_de_area.add(indice_caracteristica);
    }
}
