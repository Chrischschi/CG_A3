package computergraphics.util;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.org.mozilla.javascript.internal.ast.LetNode;
import computergraphics.datastructures.ITriangleMesh;
import computergraphics.datastructures.Vertex;

public class Heightmap {
    
    /** Erstellt ein komplettes Höhenfeld mit farben.
     * 
     * @return 
     */
    public static ITriangleMesh create(ITriangleMesh lattice, String colorPath) {
        //TODO hier applyHeightValues(ITriangleMesh) aufrufen
    	//TODO hier applyColorValues(ITriangleMesh lattice) aufrufen
    	
    	try {
			applyColorValues(lattice, colorPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return lattice; // TODO Implementieren und parameter bestimmen
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
    	BufferedImage bild = ImageIO.read(new File(colorImagePath));
    	
    	System.out.println(lattice.getNumberOfVertices());
    	
    	for(int i = 0; i <= 4; i++){
    		for (int j = 0; j <= 4; j++){
    			Vertex vert = lattice.getVertex(i);
    			
    		}
    	}
    }

}
