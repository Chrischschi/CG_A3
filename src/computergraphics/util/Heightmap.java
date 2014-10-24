package computergraphics.util;

import computergraphics.datastructures.ITriangleMesh;

public class Heightmap {
    
    /** Erstellt ein komplettes Höhenfeld mit farben.
     * 
     * @return 
     */
    public static ITriangleMesh create() {
        //TODO hier applyHeightValues(ITriangleMesh) aufrufen
        return null; // TODO Implementieren und parameter bestimmen
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

}
