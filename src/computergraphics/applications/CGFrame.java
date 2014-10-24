/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package computergraphics.applications;

import computergraphics.datastructures.ITriangleMesh;
import computergraphics.datastructures.Triangle;
import computergraphics.datastructures.TriangleMesh;
import computergraphics.datastructures.TriangleMeshFactory;
import computergraphics.framework.AbstractCGFrame;
import computergraphics.math.Vector3;
import computergraphics.scenegraph.ColorNode;
import computergraphics.scenegraph.TriangleMeshNode;
import computergraphics.util.Heightmap;

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
		ITriangleMesh lattice = TriangleMeshFactory.makeLattice(4);
		String colorPath = "img/Color8x8.png";
		
		//TriangleMeshNode latticeNode = new TriangleMeshNode(lattice);
		
		TriangleMeshNode heightmap = new TriangleMeshNode(Heightmap.create(lattice, colorPath)); 
		getRoot().addChild(heightmap);
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
