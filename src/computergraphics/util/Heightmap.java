package computergraphics.util;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import computergraphics.datastructures.ITriangleMesh;
import computergraphics.datastructures.Triangle;
import computergraphics.datastructures.Vertex;
import computergraphics.math.MathHelpers;
import computergraphics.math.Vector3;

public class Heightmap {
    private final static float MAX_COLOR_VALUE = 255.0f;
    
    /** Erstellt ein komplettes Höhenfeld mit farben.
     * 
     * @return 
     */
    public static ITriangleMesh create(ITriangleMesh lattice,int resolution,
            double maxHeightValue,String heightmapPath,String colorPath) {
    	
    	try {
    	    applyHeightValues(lattice,resolution,maxHeightValue,heightmapPath);
			applyColorValues(lattice,resolution, colorPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return lattice; // TODO richtig???
    }
    
    /** Setzt auf einer als dreiecksnetz dargestellten gitterstruktur die aus 
     * einer datei ausgelesenen y-werte für ein höhenfeld.   
     * @param lattice Das dreiecksnetz dessen y-werte verändert werden sollen
     * @param maxHeightValue Der y-wert, den die Farbe Weiß aus dem Bild mit den
     * höhendaten darstellen soll. Dies ist auch der maximale y-wert 
     * @throws IOException 
     */
    private static void applyHeightValues(ITriangleMesh lattice,int resolution,
            double maxHeightValue,String heightmapPath) throws IOException {
        BufferedImage image = ImageIO.read(new File(heightmapPath));
        
        /* Einfach stichprobenweise farbwerte aus dem bild des höhenfeldes ziehen.
         * Die anzahl der stichproben ist gleich die anzahl der vertices unseres
         * Dreiecksnetzes. wir starten einfach mit den pixeln unten links,dort 
         * wo in unserem Dreiecksnetz der vertex mit dem index 0 ist. 
         */
        
        /* 
         * Ein bild ist so aufgebaut
         * (0,0)-------------------(width-1,0)
         *   |                          |
         *   |                          |
         *   |                          |
         *   |                          |
         *   |                          |
         *   |                          |
         *  (0,height-1)-------(width-1,height-1)   
         */
        
        //pixel unten rechts bestimmen 
        final int startX = 0, startY = image.getHeight()-1;
        final int endX = image.getWidth()-1;
        
        int vertexIndex = 0; 
        
        final int stepX = image.getWidth() / resolution;
        final int stepY = image.getHeight() / resolution;
        
        for(int x = startX; x <= endX; x += stepX) {
            for(int y = startY; y >= 0;y -= stepY) {
                // 1. höhenwert aus bild extrahieren 
                Color color = new Color(image.getRGB(x,y));
                /* Sie können einfach einen der drei Farbkanäle z.B rot 
                 * aus dem bild verwenden und davon ausgehen, dass die anderen
                 * beiden den gleichen Wert haben. */
                float height = color.getRed()/MAX_COLOR_VALUE;
                
                // 2. y-wert setzen 
                lattice.getVertex(vertexIndex)
                .getPosition().set(MathHelpers.INDEX_1, height);
                vertexIndex++;
            }
        }
        
    }
    
    /** Setzt Farbwerte für jeden Vertex in einem als Dreiecksnetz dargestellten
     * Gitterstruktur.
     * 
     * @param lattice Das Dreiecksnetz, dessen Vertices gefärbt werden sollen
     * @param colorImagePath Pfad zur der Bilddatei mit Farbinformationen
     * @throws IOException 
     */
    private static void applyColorValues(ITriangleMesh lattice, int resolution, String colorImagePath) throws IOException{
    	// bild einlesen
    	BufferedImage bild = ImageIO.read(new File(colorImagePath));
    	
    	final int startX = 0, startY = bild.getHeight()-1;
        final int endX = bild.getWidth()-1;
        
        final int stepX = bild.getWidth() / resolution;
        final int stepY = bild.getHeight() / resolution;
    	
    	int zuFaerbendesDreieck = 0;
    	
    	// farbwerte pro pixel auslesen
    	for(int x = startX; x <= endX; x += stepX){
    		for (int y = startY; y >= 0; y -= stepY){
    			// Farbwerts des Pixels
    			Color farbWert = new Color(bild.getRGB(x,y));
    			// Farbwert aufsplitten in RGB
    			double rot = farbWert.getRed() / MAX_COLOR_VALUE;
    			float gruen = farbWert.getGreen() / MAX_COLOR_VALUE;
    			float blau = farbWert.getBlue() / MAX_COLOR_VALUE;
    			// Vector mit RGB Informationen erstellen
    			System.out.println("rot" + rot);
    			Vector3 farbVector = new Vector3(rot, gruen, blau);
    			// Vertex dem Farbvektor hinzufügen
    			Triangle tri = lattice.getTriangle(zuFaerbendesDreieck);
    			
    			Vertex vertexA = lattice.getVertex(tri.getA());
                Vertex vertexB = lattice.getVertex(tri.getB());
                Vertex vertexC = lattice.getVertex(tri.getC());
                
                vertexA.setColor(farbVector);
                vertexB.setColor(farbVector);
                vertexC.setColor(farbVector);
                
    			zuFaerbendesDreieck++;
    		}
    	}
    }

}
