package computergraphics.datastructures;

import computergraphics.math.Vector3;

//TODO statische methoden schreiben damit gitternetze erzeugt werden können
public class TriangleMeshFactory {
    
    /** 
     * Erzeugt ein Dreiecksnetz, das eine gitterstruktur repräsentieren soll.
     * Das gitter stellt immer eine quadratische fläche dar, welche sich im 
     * einheitswürfel befindet. Dieses Gitternetz liegt auf der von den achsen
     * x und z aufgespannten Ebene.
     * @param aufloesung Anzahl der gitterzellen in x-richtung (z-richtung hat
     * genausoviele) 
     * @return ein dreiecksnetz mit 2*(aufloesung*aufloesung) dreiecken und
     * (aufloesung+1)^2 vertices  
     */
    public static ITriangleMesh makeLattice(int aufloesung) {
        TriangleMesh gitter = new TriangleMesh();
        
        // Abstand zwischen den Vertices im Einheitswürfel
        double abstand = (1.0 / (double)aufloesung ); 
        
        makeVerticesForLattice(gitter,abstand);
        
        //TODO Dreiecke erzeugen lassen
        
        return gitter;
    }
    
    // Vertices berechnen. Abstand abhängig von der gewählten Auflösung
    private static void makeVerticesForLattice(ITriangleMesh gitter,double abstand) {
           for(double x = 0; Double.compare(x, (1.0 + abstand)) != 0; x += abstand){
               for (double z = 0; Double.compare(z, (1.0 + abstand)) != 0; z += abstand){
                   gitter.addVertex(new Vertex(new Vector3(x, 0, z)));
               }
           }        
    }

}
