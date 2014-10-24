package computergraphics.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TriangleMeshTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCalculateAllVertices() {
        /* "Die Auflösung soll als Parameter in ihrer Lösung einstellbar sein.
         * Bei einer Auflösung von 8x8 ergeben sich also 64 Zellen und damit 
         * 128 Dreiecke." (Und auch 9*9 = 81 Vertices)  
         */
        int expectedVertices = 81;
        
        TriangleMesh mesh = new TriangleMesh();
        
        double aufloesung = 8.0;     
        // zB: 8*8 = 91 Vertices = 64 Zellen = 128 Dreiecke
        double abstand = (1.0 / aufloesung );    
        // Abstand zwischen den Vertices im Einheitswürfel
        
        mesh.calculateAllVertices(abstand);
        
        assertEquals(expectedVertices,mesh.getNumberOfVertices());
    }

}
