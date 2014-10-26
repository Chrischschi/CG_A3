package computergraphics.util;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.org.mozilla.javascript.internal.ast.LetNode;
import computergraphics.datastructures.ITriangleMesh;
import computergraphics.datastructures.Triangle;
import computergraphics.datastructures.Vertex;
import computergraphics.math.Vector3;

public class Heightmap {
    
    /** Erstellt ein komplettes Höhenfeld mit farben.
     * 
     * @return 
     */
    public static ITriangleMesh create(ITriangleMesh lattice, String colorPath) {
        //TODO hier applyHeightValues(ITriangleMesh) aufrufen
    	
    	ITriangleMesh temp = lattice;
    	
    	try {
			applyColorValues(temp, colorPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return temp; // TODO richtig???
    }
    
    /** Setzt auf einer als dreiecksnetz dargestellten gitterstruktur die aus 
     * einer datei ausgelesenen y-werte für ein höhenfeld.   
     * @param lattice Das dreiecksnetz dessen y-werte verändert werden sollen
     * @param maxHeightValue Der y-wert, den die Farbe Weiß aus dem Bild mit den
     * höhendaten darstellen soll. Dies ist auch der maximale y-wert 
     */
    private static void applyHeightValues(ITriangleMesh lattice,double maxHeightValue) {
        //TODO Festlegen, wie man das Bild mit den höhen an die methode übergibt
    }
    
    /** Setzt Farbwerte für jeden Vertex in einem als Dreiecksnetz dargestellten
     * Gitterstruktur.
     * 
     * @param lattice Das Dreiecksnetz, dessen Vertices gefärbt werden sollen
     * @param colorImagePath Pfad zur der Bilddatei mit Farbinformationen
     * @throws IOException 
     */
    private static void applyColorValues(ITriangleMesh lattice, String colorImagePath) throws IOException{
    	// bild einlesen
    	BufferedImage bild = ImageIO.read(new File(colorImagePath));
    	
    	// auflösung des gitters berechenn
    	int anzahlVert = lattice.getNumberOfVertices();
    	int anzahlVertProDimesion = (int) Math.sqrt(lattice.getNumberOfVertices());
    	int auflösung = (anzahlVert / anzahlVertProDimesion) - 1;
    	
    	int zuFaerbendesDreieck = 0;
    	System.out.println("anzahl dreiecke " + lattice.getNumberOfTriangles());
    	
    	// farbwerte pro pixel auslesen
    	for(int i = 0; i <= auflösung - 1; i++){
    		for (int j = 0; j <= auflösung - 1 ; j++){
    			// Farbwerts des Pixels
    			Color farbWert = new Color(bild.getRGB(i,j));
    			// Farbwert aufsplitten in RGB
    			double rot = farbWert.getRed() / 255.0;
    			double gruen = farbWert.getGreen() / 255.0;
    			double blau = farbWert.getBlue() / 255.0;
    			// Vector mit RGB Informationen erstellen
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
    	System.out.println(zuFaerbendesDreieck);
    }

}
