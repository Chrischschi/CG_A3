/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package computergraphics.applications;


import com.jogamp.opengl.math.VectorUtil;
import com.sun.media.sound.AuFileWriter;

import computergraphics.datastructures.ITriangleMesh;
import computergraphics.datastructures.Triangle;
import computergraphics.datastructures.TriangleMesh;
import computergraphics.datastructures.Vertex;
import computergraphics.framework.AbstractCGFrame;
import computergraphics.math.Vector3;
import computergraphics.scenegraph.ColorNode;
import computergraphics.scenegraph.TriangleMeshNode;

/**
 * Application for the first exercise.
 * 
 * @author Philipp Jenke
 * 
 */
public class CGFrame extends AbstractCGFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4257130065274995543L;

	/**
	 * Constructor.
	 */
	public CGFrame(int timerInverval) {
		super(timerInverval);
		ColorNode colorNode = new ColorNode(new Vector3(0.25, 0.25, 0.75));
		TriangleMeshNode concavePolygon = new TriangleMeshNode(createMesh());
		getRoot().addChild(colorNode);
		colorNode.addChild(concavePolygon);
	}
	
	/**
	 * Creates a Triangle Mesh. 
	 * This method is a surrogate for user code, so consider it as 
	 * Throw-Away code. 
	 * @return
	 */
	private static ITriangleMesh createMesh() {
		// TODO in methode auslagern zum gitter erstellen
	   TriangleMesh mesh = new TriangleMesh();
	   
	   double aufloesung = 2.0;		// zB: 8*8 = 91 Vertices = 64 Zellen = 128 Dreiecke
	   double abstand = (1.0 / aufloesung );	// Abstand zwischen den Vertices im Einheitswürfel
	   
	   // Vertices berechenen
	   for(double x = 0; Double.compare(x, (1.0 + abstand)) != 0; x += abstand){
		   for (double z = 0; Double.compare(z, (1.0 + abstand)) != 0; z += abstand){
			   mesh.addVertex(new Vertex(new Vector3(x, 0, z)));
		   }
	   }
	   
	   // Dreiecke berechenen
	   // TODO Dreiecke automatisch generieren lassen
	   
	   // erstmal nur gucken, ob die Vertices stimmen
	   // ACHTUNG: Indices beginnen bei 0
	   Triangle tri1 = new Triangle(0,1,3);
	   Triangle tri2 = new Triangle(1,2,4);
	   Triangle tri3 = new Triangle(3,4,6);
	   Triangle tri4 = new Triangle(4,5,7);
	   Triangle tri5 = new Triangle(1,3,4);
	   Triangle tri6 = new Triangle(2,4,5);
	   Triangle tri7 = new Triangle(4,6,7);
	   Triangle tri8 = new Triangle(5,7,8);
	   
	   mesh.addTriangle(tri1);
	   mesh.addTriangle(tri2);
	   mesh.addTriangle(tri3);
	   mesh.addTriangle(tri4);
	   mesh.addTriangle(tri5);
	   mesh.addTriangle(tri6);
	   mesh.addTriangle(tri7);
	   mesh.addTriangle(tri8);
	   
	   // Ausgabe anzahl der Knoten (testzwecke)
	   System.out.println("number of vertices = " + mesh.getNumberOfVertices());
	   
	   // Ausgabe aller Knoten (testzwecke)
	   for (int v = 0; v < mesh.getNumberOfVertices(); v++){
		   System.out.println(mesh.getVertex(v));
	   }	   
	   return mesh;
    }

    /*
	 * (nicht-Javadoc)
	 * 
	 * @see computergrafik.framework.ComputergrafikFrame#timerTick()
	 */
	@Override
	protected void timerTick() {
		// System.out.println("Tick");
	}

	/**
	 * Program entry point.
	 */
	public static void main(String[] args) {
		new CGFrame(1000);
	}
}
