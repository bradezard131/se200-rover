/** AnalyseFunc.java
 *
 * Author: Bradley Ezard
 * Info:
 */

public class AnalyseFunc extends Function {
    //-- Constructor --//
    public AnalyseFunc() {}

    //-- Instance Methods --//
    public void call(Tools target) {
	target.getSoilAnalyser().analyse();
    }
}