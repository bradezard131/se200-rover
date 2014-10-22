/** RoverSoilAnalyser.java
 *
 * Author: Bradley Ezard
 * Info:
 */

public class RoverSoilAnalyser extends SoilAnalyser {
    //-- Class Driver --//
    public static void main(String[] args) {
	SoilAnalyser sa = new RoverSoilAnalyser(new Antenna(new Messagebox<FuncList>()));

	sa.analyse();
    }

    //-- Instance Fields --//
    private Comm comm;

    //-- Constructor --//
    public RoverSoilAnalyser(Comm comm) {
	this.comm = comm;
    }

    //-- Instance Methods --//
    public void analysisReady(String analysis) {
	comm.send(analysis);
    }
}
