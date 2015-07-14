/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainRSS;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author vanessa
 */
public class noticiasFeed extends JPanel{
    private JLabel lblTitulo;
    private JLabel lblDescripcion;
    private JTextArea lbdescription;
    
    public noticiasFeed(){
        this.lblTitulo = new JLabel();
        //this.lblDescripcion = new JLabel();
        this.lbdescription = new JTextArea();
        this.setLayout(new GridLayout(2,1));
       
        
        
    }
    
    public void cargarPanel(String titulo,String desc){
        
        lblTitulo.setText(titulo);
//        lblTitulo.resize(lblTitulo.preferredSize());
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 11));
//        lblDescripcion.resize(lblTitulo.preferredSize());
        lbdescription.setText(desc);
        lbdescription.setLineWrap(true);
        lbdescription.setWrapStyleWord(true);
        lbdescription.setEditable(false);
        lbdescription.setFont(new Font("Serif", Font.BOLD, 11));
        this.add(lblTitulo);
        this.add(lbdescription);
    }
}
