/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package computergraphics.applications;

import computergraphics.datastructures.ITriangleMesh;
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
	/* "[...] beispielsweise weiß entspricht einem y‐Wert von 0.1."*/
	private static final double MAX_HEIGHT = 0.1;

	/**
	 * Constructor.
	 */
	public CGFrame(int timerInverval) {
		super(timerInverval);
		ITriangleMesh lattice = TriangleMeshFactory.makeLattice(8);
		String colorPath = "img/Color8x8.png";
		String heightmapPath = "img/heightField.png";
		
		lattice = Heightmap.create(lattice, MAX_HEIGHT, colorPath, heightmapPath);
		
		//TriangleMeshNode latticeNode = new TriangleMeshNode(lattice);
		
		TriangleMeshNode heightmap = new TriangleMeshNode(lattice); 
		
		// Colornode erstellen für farbliche Darstellung
		ColorNode colorNode = new ColorNode(new Vector3(0, 0, 0));
		
		getRoot().addChild(colorNode);
		colorNode.addChild(heightmap);
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
