/** RoverSoilAnalyser.java
 *
 * Author: Bradley Ezard
 * Info:
 */

public class RoverSoilAnalyser extends SoilAnalyser {
    //-- Class Driver --//
    public static void main(String[] args) {
	SoilAnalyser sa = new RoverSoilAnalyser();

	sa.analyse();
	
	try { Thread.sleep(5100); } catch (Exception e) {}

	System.out.println(((RoverSoilAnalyser)sa).msgs.remove());
    }

    //-- Instance Fields --//
    private Messagebox<String> msgs;

    //-- Constructor --//
    public RoverSoilAnalyser() {
	msgs = new Messagebox<String>();
    }

    //-- Instance Methods --//
    public void analysisReady(String analysis) {
	msgs.add(analysis);
    }
}