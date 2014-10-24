package computergraphics.datastructures;

import static org.junit.Assert.*;
import static computergraphics.datastructures.TriangleMeshFactory.*;

import org.junit.Before;
import org.junit.Test;

public class TriangleMeshFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testMakeLattice() {
        /* "Die Auflösung soll als Parameter in ihrer Lösung einstellbar sein.
         * Bei einer Auflösung von 8x8 ergeben sich also 64 Zellen und damit 
         * 128 Dreiecke." (Und auch 9*9 = 81 Vertices)  
         */
        int expectedTriangles = 128;
        int expectedVertices = 81;
        ITriangleMesh mesh = makeLattice(8);
        assertEquals(expectedVertices, mesh.getNumberOfVertices());
        assertEquals(expectedTriangles, mesh.getNumberOfTriangles());
    }

}
