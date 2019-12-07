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
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import proyectobodegas.Estructura.Bodega;

/**
 *
 * @author propietario
 */
public class Ventana_Interna extends JInternalFrame {
    private DefaultTableModel modelo_tabla_bodegas;
    private JTable tabla_bodegas;
    private JPanel contenedor;
    private String Categoria;
    private Dimension ventanaSize;
    
    public Ventana_Interna(Bodega lista_bodegas, String Categoria, ActionListener Acciones){
        this.Categoria = Categoria;
        
        setTitle("Listado de "+Categoria+"s");
        setMinimumSize(new Dimension(getWidth(),400));
        setMaximumSize(new Dimension(1300,700));
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        add(crearContenedor(lista_bodegas));
        pack();
        setVisible(true);
    }
    
    public JScrollPane crearContenedor(Bodega lista_bodegas){
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 0;
        c.gridy = 0;
        
        
        contenedor = new JPanel();
        contenedor.setLayout(new GridBagLayout());
        
        
        JPanel agregar_bodega = new JPanel();
        agregar_bodega.setLayout(new GridBagLayout());
        agregar_bodega.setOpaque(true);
        agregar_bodega.setBackground(Color.WHITE);
        
        
        JLabel label_agregar = new JLabel("Agregar "+Categoria);
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
        
        llenarDatos(lista_bodegas);
        contenedor.setVisible(true);
        JScrollPane scrollpane = new JScrollPane(contenedor);
        return scrollpane;
    }
    
    private void llenarDatos(Bodega lista_bodegas){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        int y = 0;
        c.gridy = y;
        //c.gridwidth = 3;
        
        JPanel Contendor_Lista = new JPanel(new GridBagLayout());
            Contendor_Lista.setOpaque(true);
            Contendor_Lista.setBackground(Color.WHITE);
        
        while(lista_bodegas.SiguienteBodega()){
            c.gridx = 0;
            c.gridy = y;
            c.insets = new Insets(5,5,5,5);
            
            JLabel Nombre = new JLabel();
            
            Nombre.setText(lista_bodegas.bodegaActual().obtenerIdentificador());
            Nombre.setHorizontalAlignment(SwingConstants.CENTER);
            
            JButton Ver = new JButton("Abrir");
            JButton Editar = new JButton("Editar");
            JButton Eliminar = new JButton("Eliminar");
            
            Contendor_Lista.add(Nombre,c);
            c.gridx = 1;
            Contendor_Lista.add(Ver,c);
            c.gridx = 2;
            Contendor_Lista.add(Editar,c);
            c.gridx = 3;
            Contendor_Lista.add(Eliminar,c);
            
            y++;
        }
        
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        contenedor.add(Contendor_Lista,c);
    }
}
