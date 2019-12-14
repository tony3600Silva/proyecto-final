/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exportarexcel;

//import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
//import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author AdminOmarGuevara
 */
public class ExportarExcel {

    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        JFExportar inicio = new JFExportar();
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);

    }

     

}
