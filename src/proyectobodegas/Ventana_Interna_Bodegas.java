/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package proyectobodegas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import proyectobodegas.Estructura.Bodega;

/**
 *
 * @author propietario
 */
public class Ventana_Interna_Bodegas extends JInternalFrame {
    private DefaultTableModel modelo_tabla_bodegas;
    private JTable tabla_bodegas;
    private JPanel contenedor;
    private int y;
    private Dimension ventanaSize;
    
    public Ventana_Interna_Bodegas(Bodega lista_bodegas){
        setTitle("Listado de Bodegas");
        y = 0;
        
        
        add(crearContenedor(lista_bodegas));
        pack();
        //setMinimumSize(this.getSize());
        setMaximumSize(new Dimension(1300,700));
        
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setVisible(true);
    }
    
    public JScrollPane crearContenedor(Bodega lista_bodegas){
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = y;
        
        
        contenedor = new JPanel();
        contenedor.setLayout(new GridBagLayout());
        
        
        JPanel agregar_bodega = new JPanel();
        agregar_bodega.setLayout(new GridBagLayout());
        
        
        JLabel label_agregar = new JLabel("Agregar Bodega");
        JTextField nueva_bodega_textfield = new JTextField();
        JButton boton_agregar = new JButton("Agregar");
        c.gridx = 0;
        agregar_bodega.add(label_agregar,c);
        c.gridx = 1;
        c.ipadx = 150;
        agregar_bodega.add(nueva_bodega_textfield,c);
        c.ipadx = 0;
        c.gridx = 2;
        agregar_bodega.add(boton_agregar,c);
       
        c.gridx = 0;
        c.gridwidth = 3;
        c.insets = new Insets(10,20,10,20);
        
        contenedor.add(agregar_bodega,c);
        y++;
        llenarDatos(lista_bodegas);
        contenedor.setVisible(true);
        JScrollPane scrollpane = new JScrollPane(contenedor);
        return scrollpane;
    }
    
    public void llenarDatos(Bodega lista_bodegas){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = y;
        c.gridwidth = 3;
        
        while(lista_bodegas.SiguienteBodega()){
            c.gridx = 0;
            c.gridy = y;
            
            JPanel nueva_fila = new JPanel(new GridBagLayout());
            nueva_fila.setOpaque(true);
            nueva_fila.setBackground(Color.WHITE);
                        
            JLabel Nombre = new JLabel();
            Nombre.setBackground(Color.WHITE);
            Nombre.setOpaque(true);
            Nombre.setText(lista_bodegas.bodegaActual().obtenerIdentificador());
            
            JButton Editar = new JButton("Editar");
            Editar.setBounds(0, 0, 80, 10);
            
            nueva_fila.add(Nombre);
            nueva_fila.add(Editar);
            
            contenedor.add(nueva_fila,c);
            y++;
        }
    }
}
