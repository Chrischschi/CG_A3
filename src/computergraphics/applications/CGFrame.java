/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package computergraphics.applications;

import java.io.IOException;

import computergraphics.datastructures.ITriangleMesh;
import computergraphics.datastructures.TriangleMesh;
import computergraphics.datastructures.TriangleMeshFactory;
import computergraphics.framework.AbstractCGFrame;
import computergraphics.math.Vector3;
import computergraphics.scenegraph.ColorNode;
import computergraphics.scenegraph.TranslationNode;
import computergraphics.scenegraph.TriangleMeshNode;
import computergraphics.util.HeightfieldNEW;
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
	 * @throws IOException 
	 */
	public CGFrame(int timerInverval) throws IOException {
		super(timerInverval);
		//String colorPath = "img/Color8x8.png";
		String colorPath = "img/color.png";
		String heightmapPath = "img/heightField.png";
		//String heightmapPath = "img/Color8x8.png";
		
		
		ITriangleMesh heightfield = HeightfieldNEW.makeField(DEFAULT_RESOLUTION,
		        heightmapPath, colorPath,MAX_HEIGHT);
		
		
		
		//TriangleMeshNode latticeNode = new TriangleMeshNode(lattice);
		
		TriangleMeshNode heightfieldNode = new TriangleMeshNode(heightfield); 
		
		TranslationNode translationNode = 
		        new TranslationNode(new Vector3(-0.5,0,-0.5));
		
		// Colornode erstellen für farbliche Darstellung
		ColorNode colorNode = new ColorNode(new Vector3(0, 0, 0));
		
		getRoot().addChild(translationNode);
		translationNode.addChild(colorNode);
		colorNode.addChild(heightfieldNode);
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
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new CGFrame(1000);
	}
}
