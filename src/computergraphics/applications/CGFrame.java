/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package computergraphics.applications;


import computergraphics.datastructures.ITriangleMesh;
import computergraphics.datastructures.Triangle;
import computergraphics.datastructures.TriangleMesh;
import computergraphics.datastructures.Vertex;
import computergraphics.framework.AbstractCGFrame;
import computergraphics.math.Vector3;
import computergraphics.scenegraph.ColorNode;
import computergraphics.scenegraph.SingleTriangleNode;
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
	   TriangleMesh mesh = new TriangleMesh();
       //5 Vertices
	   int _1 = mesh.addVertex(new Vertex(new Vector3(1,2,0)));
	   int _2 = mesh.addVertex(new Vertex(new Vector3(2,1,0)));
	   int _3 = mesh.addVertex(new Vertex(new Vector3(1,0,0)));
	   int _4 = mesh.addVertex(new Vertex(new Vector3(0,1,0)));
	   int _5 = mesh.addVertex(new Vertex(new Vector3(1,1,0)));
	   
	   //3 Triangles
	   Triangle alpha = new Triangle(_1,_2,_5);
	   Triangle beta = new Triangle(_2,_3,_5);
	   Triangle gamma = new Triangle(_3,_4,_5);
	   
	   mesh.addTriangle(alpha); mesh.addTriangle(beta); mesh.addTriangle(gamma);
	   
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
