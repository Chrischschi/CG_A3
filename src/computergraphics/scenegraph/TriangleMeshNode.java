package computergraphics.scenegraph;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import computergraphics.datastructures.ITriangleMesh;
import computergraphics.datastructures.Triangle;
import computergraphics.datastructures.Vertex;
import computergraphics.math.Vector3;

public class TriangleMeshNode extends Node {
    private ITriangleMesh triangleMesh; 
    
    /**
     * Default Constructor. 
     */
    public TriangleMeshNode(ITriangleMesh triangleMesh) {
        this.triangleMesh = triangleMesh;
    }

    @Override
    public void drawGl(GL2 gl) {
        //We need to iterate over all the Triangles
        int numberOfTriangles = triangleMesh.getNumberOfTriangles();
        
        //initialize drawing
        gl.glColor3d(1, 0, 0); //red
        gl.glBegin(GL.GL_TRIANGLES);
        
        //Draw every Triangle
        for(int indexTriangle = 0;
                indexTriangle < numberOfTriangles;
                indexTriangle++) { 
            // Get the triangle from the Mesh
            Triangle triangle = triangleMesh.getTriangle(indexTriangle); 
            // Get the 3 vertices from the triangle
            Vertex vertexA = triangleMesh.getVertex(triangle.getA());
            Vertex vertexB = triangleMesh.getVertex(triangle.getB());
            Vertex vertexC = triangleMesh.getVertex(triangle.getC());
            
            //Get the position vectors for each Vertex
            Vector3 positionA = vertexA.getPosition();
            Vector3 positionB = vertexB.getPosition();
            Vector3 positionC = vertexC.getPosition();
            
            //Draw the Vertices based on the positions
            
            //Draw vertex A
            gl.glVertex3d(positionA.get(0),positionA.get(1),positionA.get(2));
            //Draw vertex B 
            gl.glVertex3d(positionB.get(0),positionB.get(1),positionB.get(2));
            //Draw vertex C 
            gl.glVertex3d(positionC.get(0),positionC.get(1),positionC.get(2));
            
            
        }
        gl.glEnd(); //end drawing
    }

}
