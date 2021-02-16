/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial.poe.pkg2020.pkg2.validar;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ZASALAS
 */
public class EscalarImagenLabel {
      public Icon PonerLaImagen(String direccion, JLabel LabelFruta) {
        ImageIcon Icon = new ImageIcon(getClass().getResource(direccion));

        int ancho = LabelFruta.getWidth() / 3;
        int alto = LabelFruta.getHeight() / 3;

        ImageIcon Iconos = new ImageIcon(Icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return Iconos;
    }
}
