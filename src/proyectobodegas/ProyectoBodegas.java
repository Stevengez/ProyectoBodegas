/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobodegas;

import javax.swing.JFrame;
import proyectobodegas.Estructura.Bodega;

/**
 *
 * @author propietario
 */
public class ProyectoBodegas extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bodega Lista_Bodegas = new Bodega();
        //Pruebas iniciales de la estructura.
        Lista_Bodegas.agregarBodega("Primera");
        Lista_Bodegas.ultimaAgregada().Niveles().agregarNivel("Primer Nivel");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");
        
        Lista_Bodegas.ultimaAgregada().Niveles().agregarNivel("Segundo Nivel");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");
        
        Lista_Bodegas.ultimaAgregada().Niveles().agregarNivel("Tercer Nivel");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");       
        
        Lista_Bodegas.agregarBodega("Segunda");
        Lista_Bodegas.ultimaAgregada().Niveles().agregarNivel("Primer Nivel");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");
        
        Lista_Bodegas.ultimaAgregada().Niveles().agregarNivel("Segundo Nivel");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");
        
        Lista_Bodegas.ultimaAgregada().Niveles().agregarNivel("Tercer Nivel");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");    
        
        Lista_Bodegas.agregarBodega("Tercera");
        Lista_Bodegas.ultimaAgregada().Niveles().agregarNivel("Primer Nivel");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");
        
        Lista_Bodegas.ultimaAgregada().Niveles().agregarNivel("Segundo Nivel");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");
        
        Lista_Bodegas.ultimaAgregada().Niveles().agregarNivel("Tercer Nivel");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().agregarArea("Area 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 1");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().agregarEstante("Estante 2");
        Lista_Bodegas.ultimaAgregada().Niveles().ultimoAgregado().Areas().ultimaAgregada().Estantes().ultimoAgregado().Secciones().agregarSeccion("Seccion 1");       
        
        while(Lista_Bodegas.SiguienteBodega()){
            System.out.println("Estoy en la bodega: "+Lista_Bodegas.bodegaActual().obtenerIdentificador());
            while(Lista_Bodegas.bodegaActual().Niveles().SiguienteNivel()){
                System.out.println("     Estoy en el nivel: "+Lista_Bodegas.bodegaActual().Niveles().nivelActual().obtenerIdentificador());
                while(Lista_Bodegas.bodegaActual().Niveles().nivelActual().Areas().SiguienteArea()){
                    System.out.println("          Estoy en el area: "+Lista_Bodegas.bodegaActual().Niveles().nivelActual().Areas().areaActual().obtenerIdentificador());
                    while(Lista_Bodegas
                            .bodegaActual()
                            .Niveles()
                            .nivelActual()
                            .Areas()
                            .areaActual()
                            .Estantes()
                            .SiguienteEstante()){
                        System.out.println("               Estoy en el estante: "+Lista_Bodegas.bodegaActual().Niveles().nivelActual().Areas().areaActual().Estantes().estanteActual().obtenerIdentificador());
                    }
                }
            }
        }
        
    }
    
    public void IniciarVentana(){
        
    }
    
}
