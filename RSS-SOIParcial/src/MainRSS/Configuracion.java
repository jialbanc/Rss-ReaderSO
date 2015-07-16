/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainRSS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author vanessa
 */
public class Configuracion extends JPanel{
    ImageIcon imagen;
    String nombre;
    public Configuracion(String nombre){
        this.nombre= nombre;
    
    }
    public void piant (Graphics g){
        Dimension tamalio = getSize();
        imagen = new ImageIcon(getClass().getResource(nombre));
        g.drawImage(imagen.getImage(), 0, 0, tamalio.width,tamalio.height, null);
        setOpaque(false);
        super.paint(g);
    }
}
