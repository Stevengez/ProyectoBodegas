/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobodegas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import proyectobodegas.Estructura.Bodega;

/**
 *
 * @author propietario
 */
public class ProyectoBodegas extends JFrame implements ActionListener{

    private JDesktopPane Sub_Ventanas;
    private Bodega Listado_Bodegas;
    private Ventana_Interna ventanaBodega;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProyectoBodegas GUI = new ProyectoBodegas();
    }
    
    public ProyectoBodegas() {
        InicializarDatos();
        InicializarVentana();
        
    }
    
    public void InicializarVentana(){
        setTitle("Programa Bodegas");
        setSize(1300,700);
        setJMenuBar(crearMenu());
        
        Sub_Ventanas = new JDesktopPane();
        Sub_Ventanas.setDesktopManager(new DesktopManager_Modificado());
        getContentPane().add(Sub_Ventanas);
        
        Sub_Ventanas.add(ventanaBodega);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    
    public void InicializarDatos(){
        Listado_Bodegas = new Bodega();
        llenarDatosdePrueba();
        ventanaBodega= new Ventana_Interna(Listado_Bodegas, "Bodega", this);
    }
    
    public void llenarDatosdePrueba(){
        Listado_Bodegas.agregarBodega("Primera Bodega");
        Listado_Bodegas.agregarBodega("Segunda Bodega");
        Listado_Bodegas.agregarBodega("Tercera Bodega");
        Listado_Bodegas.agregarBodega("CUarta Bodega: Utencilios de Cocina");
    }
    
    public Bodega obtenerDatosdeBodega(){
        return Listado_Bodegas;
    }
    
    public JMenuBar crearMenu(){
        
        JMenuBar menu_superior = new JMenuBar();
        
        JMenu menu = new JMenu("Menu");
        
        JMenuItem primero = new JMenuItem("Inicio");
        
        menu.add(primero);
        menu_superior.add(menu);
        
        return menu_superior;
    }

    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "verNiveles":
                System.out.println("Clicaste abrir niveles: "+e.getActionCommand());
                break;
            
        }
        
    }    
    
    
}



