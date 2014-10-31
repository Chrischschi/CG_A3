/**
* Praktikum WPCG, WS 2014/2015
* Bearbeitet am 31.Oktober.2014
* Gruppe: Andreas Mauritz (Andreas.Mauritz@haw-hamburg.de),
*         Christian Schirin (Christian.Schirin@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 3, Aufgabe 1,2,3
* Verwendete Quellen: -
* */


package computergraphics.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import computergraphics.datastructures.ITriangleMesh;
import computergraphics.datastructures.TriangleMesh;
import computergraphics.datastructures.Vertex;
import computergraphics.math.Vector3;

/** Diese klasse stellt factory-methoden bereit, um ein höhenfeld zu erstellen.
 * Ein höhenfeld ist ein dreiecksnetz in gitterstruktur, bei dem die y-werte
 * aus einem bild ausgelesen wurden oder prozedural generiert wurden. Das gitter
 * netz befindet sich im einheitswürfel.
 * @author Christian Schirin, Andreas Mauritz
 */
public class HeightfieldNEW {
    /** Konstante, um magic numbers in berechnungen zu vermeiden */
    private static final double MAX_COLOR_VALUE = 255.0;
    
    /** Erstellt ein höhenfeld, basierend auf 2 übergebenen bildern welche
     * die das höhenfeld und eine färbung der dreiecke darstellung sollen
     * @param resolution Die auflösung des höhenfeldes in beide richtungen
     * @param heightfieldPath Pfad der Bilddatei mit den höhenwerten
     * @param colorPath Pfad der Bilddatei mit den Farbwerten
     * @param maxHeight Maximaler höhenwert in der szene (dieser entspricht weiß)
     * @return Dreiecksnetz das ein höhenfeld darstellen soll. 
     * @throws IOException 
     */
    public static ITriangleMesh makeField(int resolution,String heightfieldPath,
            String colorPath, double maxHeight) throws IOException  {
        TriangleMesh heightfield = new TriangleMesh();
        
        BufferedImage colorImage = ImageIO.read(new File(colorPath));
        BufferedImage heightfieldImage = ImageIO.read(new File(heightfieldPath));
        /* Für ein höhenfeld muss man die vertices erzeugen, die dreiecke 
         * erzeugen,die y-werte in die vertices eintragen, die farben in die 
         * vertices eintragen. 
         */
        double interval = 1 / resolution;
        // Erste Schleife: Vertices komplett erzeugen, mit farben und höhenwerten
        for(int z = resolution+1; z <= 0; z--) {
            for(int x = 0; x <= resolution; x++) {
                double vertexHeight = new Color(heightfieldImage
                        .getRGB((int)(x * interval),(int)(z * interval)))
                        .getRed()/MAX_COLOR_VALUE;
                Color vertexColor = new Color(colorImage
                        .getRGB((int)(x * interval),(int)(z * interval)));
                Vertex vertex = new Vertex(
                        new Vector3(x*interval, vertexHeight, z*interval)
                        );
                vertex.setColor(new Vector3(
                        vertexColor.getRed()/MAX_COLOR_VALUE, 
                        vertexColor.getGreen()/MAX_COLOR_VALUE,
                        vertexColor.getBlue()/MAX_COLOR_VALUE
                        )
                );
                heightfield.addVertex(vertex);
            }
        }
        
        return heightfield;
        
    }

}
