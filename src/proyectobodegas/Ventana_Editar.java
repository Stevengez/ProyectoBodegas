/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package proyectobodegas;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyectobodegas.Estructura.Bodega;
import proyectobodegas.Estructura.Constantes;

/**
 *
 * @author propietario
 */
public class Ventana_Editar extends JInternalFrame {
    private String Identificador;
    private int ID, Tipo;
    private Object Lista;
    private JPanel Contenedor_Superior;
    private boolean origen;

    public Ventana_Editar(String Identificador, int ID, int Tipo, Object Lista, JPanel Contenedor_Superior, boolean origen) {
        this.Identificador = Identificador;
        this.ID = ID;
        this.Tipo = Tipo;
        this.Lista = Lista;
        this.Contenedor_Superior = Contenedor_Superior;
        this.origen = origen;
    }
    
    public Ventana_Editar(){
        Identificador = "E";
        Contenedor_Superior = new JPanel();
        Contenedor_Superior.setLayout(new GridBagLayout());
        setTitle("Editar Contenido");
        setName("Editar");
        add(Contenedor_Superior);
        setMaximumSize(new Dimension(1300, 700));
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
    }
    
    public void configurarEditor(int Tipo, int ID, Object Lista){
        this.Tipo = Tipo;
        this.ID = ID;
        this.Lista = Lista;
        agregarComponentes(Tipo);
        origen = true;
    }
    
    public void agregarComponentes(int Tipo){
        JPanel Contenedor = new JPanel();
        Contenedor.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(15, 15, 15, 15);
        switch(Tipo){
            case Constantes.ORIGEN_BODEGA:
                Bodega lista_bodegas = (Bodega) Lista;
                JLabel nombre = new JLabel("Nombre de la Bodega: ");
                lista_bodegas.irAIndice(ID);
                JTextField nombre_bodega = new JTextField(lista_bodegas.bodegaActual().obtenerIdentificador());
                Contenedor.add(nombre,c);
                c.gridx = 50;
                c.ipadx = 50;
                Contenedor.add(nombre_bodega,c);
                add(Contenedor);
                break;
        }
        pack();
        setMinimumSize(new Dimension(getWidth(), 100));
        setVisible(true);
    }
    
}
