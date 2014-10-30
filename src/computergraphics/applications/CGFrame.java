/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package computergraphics.applications;

import computergraphics.datastructures.ITriangleMesh;
import computergraphics.datastructures.TriangleMesh;
import computergraphics.datastructures.TriangleMeshFactory;
import computergraphics.framework.AbstractCGFrame;
import computergraphics.math.Vector3;
import computergraphics.scenegraph.ColorNode;
import computergraphics.scenegraph.TranslationNode;
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
	private static final int DEFAULT_RESOLUTION = 800; //8x8

	/**
	 * Constructor.
	 */
	public CGFrame(int timerInverval) {
		super(timerInverval);
		ITriangleMesh lattice = TriangleMeshFactory.makeLattice(DEFAULT_RESOLUTION);
		//String colorPath = "img/Color8x8.png";
		String colorPath = "img/color.png";
		String heightmapPath = "img/heightField.png";
		//String heightmapPath = "img/Color8x8.png";
		
		((TriangleMesh)lattice).calculateAllNormals();
		
		lattice = Heightmap.create(lattice,DEFAULT_RESOLUTION, MAX_HEIGHT,
		        heightmapPath, colorPath);
		
		
		
		//TriangleMeshNode latticeNode = new TriangleMeshNode(lattice);
		
		TriangleMeshNode heightmap = new TriangleMeshNode(lattice); 
		
		TranslationNode translationNode = 
		        new TranslationNode(new Vector3(-0.5,0,-0.5));
		
		// Colornode erstellen für farbliche Darstellung
		ColorNode colorNode = new ColorNode(new Vector3(0, 0, 0));
		
		getRoot().addChild(translationNode);
		translationNode.addChild(colorNode);
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
