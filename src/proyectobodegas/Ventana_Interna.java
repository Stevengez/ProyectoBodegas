/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package proyectobodegas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import proyectobodegas.Estructura.Area;
import proyectobodegas.Estructura.Bodega;
import proyectobodegas.Estructura.Constantes;
import proyectobodegas.Estructura.Nivel;

/**
 *
 * @author propietario
 */
public class Ventana_Interna extends JInternalFrame implements ActionListener {

    private DefaultTableModel modelo_tabla_bodegas;
    private JTable tabla_bodegas;
    private String nombre_superior;
    private JPanel contenedor;
    private int Tipo;
    private Dimension ventanaSize;
    private ProyectoBodegas Contexto;
    private Object lista_bodegas;
    private JInternalFrame frame_superior;

    public Ventana_Interna(JInternalFrame frame_superior, Object lista_bodegas, String nombre_superior, int Tipo, ProyectoBodegas Contexto) {
        this.Contexto = Contexto;
        this.Tipo = Tipo;
        this.nombre_superior = nombre_superior;
        this.lista_bodegas = lista_bodegas;
        this.frame_superior = frame_superior;

        setMaximumSize(new Dimension(1300, 700));
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        add(crearContenedor());
        pack();
        setMinimumSize(new Dimension(getWidth(), 100));
        setVisible(true);
    }

    private JScrollPane crearContenedor() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;

        contenedor = new JPanel();
        contenedor.setLayout(new GridBagLayout());

        JPanel agregar_bodega = new JPanel();
        agregar_bodega.setLayout(new GridBagLayout());
        agregar_bodega.setOpaque(true);
        agregar_bodega.setBackground(Color.WHITE);

        JLabel label_agregar = new JLabel("Nombre :");
        JTextField nueva_bodega_textfield = new JTextField();
        JButton boton_buscar = new JButton("Agregar");
        JButton boton_agregar = new JButton("Buscar");
        c.gridx = 0;
        agregar_bodega.add(label_agregar, c);
        c.gridx = 1;
        c.ipadx = 150;
        agregar_bodega.add(nueva_bodega_textfield, c);
        c.ipadx = 0;
        c.gridx = 2;
        agregar_bodega.add(boton_buscar, c);
        c.gridx = 3;
        agregar_bodega.add(boton_agregar, c);

        c.gridx = 0;
        c.gridwidth = 3;
        c.insets = new Insets(10, 20, 10, 20);

        contenedor.add(agregar_bodega, c);

        llenarDatos();
        contenedor.setVisible(true);
        JScrollPane scrollpane = new JScrollPane(contenedor);
        return scrollpane;
    }

    private void llenarDatos() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        int y = 0;
        c.gridy = y;
        //c.gridwidth = 3;

        JPanel Contenedor_Lista = new JPanel(new GridBagLayout());
        Contenedor_Lista.setOpaque(true);
        Contenedor_Lista.setBackground(Color.WHITE);

        switch (Tipo) {
            case Constantes.ORIGEN_BODEGA:
                Bodega Lista = (Bodega) lista_bodegas;
                Lista.reiniciarLista();
                super.setTitle("Listado de Bodegas");
                while (Lista.SiguienteBodega()) {
                    agregarFila(Tipo, c, y, Lista.bodegaActual().obtenerIdentificador(), Lista.bodegaActual().obtenerIndice(), Contenedor_Lista);
                    y++;
                }

                break;
            case Constantes.ORIGEN_NIVEL:
                super.setTitle(nombre_superior + " - Listado de Niveles");
                Nivel Lista_Niveles = (Nivel) lista_bodegas;
                Lista_Niveles.reiniciarLista();
                while (Lista_Niveles.SiguienteNivel()) {
                    agregarFila(Tipo, c, y, Lista_Niveles.nivelActual().obtenerIdentificador(), Lista_Niveles.nivelActual().obtenerIndice(), Contenedor_Lista);
                    y++;
                }
                break;
            case Constantes.ORIGEN_AREA:
                super.setTitle(nombre_superior + " - Listado de Areas");
                Area Lista_Areas = (Area) lista_bodegas;
                Lista_Areas.reiniciarLista();
                while (Lista_Areas.SiguienteArea()) {
                    agregarFila(Tipo, c, y, Lista_Areas.areaActual().obtenerIdentificador(), Lista_Areas.areaActual().obtenerIndice(), Contenedor_Lista);
                    y++;
                }
                break;
            default:

                break;
        }

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        contenedor.add(Contenedor_Lista, c);

    }

    private void agregarFila(int Tipo, GridBagConstraints c, int y, String nombre, int ID, JPanel Contenedor_Lista) {
        c.gridx = 0;
        c.gridy = y;
        c.insets = new Insets(5, 5, 5, 5);

        JLabel Nombre = new JLabel();

        Nombre.setText(nombre);
        Nombre.setHorizontalAlignment(SwingConstants.CENTER);

        Boton Ver = new Boton("Abrir");
        Ver.setID(ID);
        Ver.setOrigen(Tipo);
        Ver.setAction(Constantes.ACCION_ABRIR);
        Ver.addActionListener(this);

        Boton Editar = new Boton("Editar");
        Boton Eliminar = new Boton("Eliminar");

        Contenedor_Lista.add(Nombre, c);
        c.gridx = 1;
        Contenedor_Lista.add(Ver, c);
        c.gridx = 2;
        Contenedor_Lista.add(Editar, c);
        c.gridx = 3;
        Contenedor_Lista.add(Eliminar, c);
    }

    public void actionPerformed(ActionEvent e) {
        Boton boton = (Boton) e.getSource();
        switch (boton.getOrigen()) {
            case Constantes.ORIGEN_BODEGA:
                switch (boton.getAccion()) {
                    case Constantes.ACCION_ABRIR:
                        System.out.println("Elegiste abrir la bodega: " + boton.getID());
                        Bodega Lista_Bodegas = (Bodega) lista_bodegas;
                        Lista_Bodegas.irAIndice(boton.getID());
                        try {
                            super.setIcon(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(Ventana_Interna.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Ventana_Interna niveles = new Ventana_Interna(this, Lista_Bodegas.bodegaActual().Niveles(), Lista_Bodegas.bodegaActual().obtenerIdentificador(), Constantes.ORIGEN_NIVEL, Contexto);
                        Contexto.agregarVentana(niveles);
                        Contexto.activarVentana(niveles);
                        break;
                }
                break;
            case Constantes.ORIGEN_NIVEL:
                switch (boton.getAccion()) {
                    case Constantes.ACCION_ABRIR:
                        System.out.println("Elegiste abrir el nivel: " + boton.getID());
                        Nivel Lista_Niveles = (Nivel) lista_bodegas;
                        Lista_Niveles.irAIndice(boton.getID());
                        try {
                            super.setIcon(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(Ventana_Interna.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Ventana_Interna areas = new Ventana_Interna(this, Lista_Niveles.nivelActual().Areas(), nombre_superior + " \\ " + Lista_Niveles.nivelActual().obtenerIdentificador(), Constantes.ORIGEN_AREA, Contexto);
                        areas.requestFocus();
                        //areas.setLocation(this.getLocation().x + this.getWidth(), 0);
                        Contexto.agregarVentana(areas);
                        Contexto.activarVentana(areas);
                        break;
                }
                break;
        }
    }

    @Override
    public void doDefaultCloseAction() {
        System.out.println("Cerraste el fram.");
        try {
            frame_superior.setIcon(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Ventana_Interna.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.doDefaultCloseAction(); //To change body of generated methods, choose Tools | Templates.
    }

}
