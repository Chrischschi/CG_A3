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
        
        makeVerticesForLattice(gitter,aufloesung);
        makeTrianglesForLattice(gitter,aufloesung); 
        
        return gitter;
    }
    
    private static void makeTrianglesForLattice(TriangleMesh gitter, int aufloesung) {
        
        /*Das problem wird so gelöst, dass zwei iterationen durchgeführt werden,
        In der einen richtung werden so genannte "helle" dreiecke eingefügt,
        In die andere richtung "dunkle". Für ein helles dreieck gilt, dass
        seine knoten folgende indizes in der vertexList haben: 
        a = (index von 0 ausgehend); b = a + 1 , c = b + aufloesung */ 
        
        /*Wir dürfen keine hellen dreiecke am rechten rand des gitters erzeugen
        daher "- aufloesung + 1 "  */
        
        int letzterVertexIndex = (gitter.getNumberOfVertices()-1) - (aufloesung+1);
        for(int i = 0, faktor = 0; i <= letzterVertexIndex; i++) {
            if (i == (faktor+1)* aufloesung + faktor) { 
                //Überspringen und faktor erhöhen
                faktor++;
            } else {
                //Die drei indizes des vertex bestimmen
                int a = i, b = a + 1, c = b + aufloesung;
                Triangle t = new Triangle(a,b,c);
                gitter.addTriangle(t);
            }
        }
        
        /*Für ein dunkles dreieck gilt, dass
        seine knoten folgende indizes in der vertexList haben: 
        a = (von letzten index ausgehend); b = a - 1 , c = b - aufloesung */
        
        /*Wir dürfen keine dunklen dreiecke am linken rand des gitters erzeugen
        daher "- aufloesung + 1 "  */

        /*faktor muss hier bei aufloesung - 1 beginnen, damit die richtige 
         * anzahl von dreiecken erzeugt wird. */
        for(int i = gitter.getNumberOfVertices() - 1, faktor = aufloesung - 1;
                i >= aufloesung + 1; i--) {
            if (i == (faktor+1)* aufloesung + faktor + 1) { 
                //Überspringen und faktor verringern.
                faktor--;
        	//Die drei indizes des vertex bestimmen
            } else {
            	int a = i, b = a - 1, c = b - aufloesung;
            	Triangle t = new Triangle(a,b,c);
            	gitter.addTriangle(t);
            }
        }
        
    }

    // Vertices berechnen. Abstand abhängig von der gewählten Auflösung
    private static void makeVerticesForLattice(ITriangleMesh gitter,int aufloesung) {
        // Abstand zwischen den Vertices im Einheitswürfel
        double abstand = (1.0 / (double)aufloesung ); 
        
           for(int x = 0; x <= aufloesung; x++){
               for (int z = aufloesung; z >= 0; z--){
                   gitter.addVertex(new Vertex(new Vector3(x*abstand, 0, z*abstand)));
               }
           }        
    }

}
