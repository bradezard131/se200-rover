/** DriveFunc.java
 *
 * Author: Bradley Ezard
 * Info: 
 */

public class DriveFunc extends Function {
    //-- Instance Fields --//
    private double dist;

    //-- Constructor --//
    public DriveFunc(double dist) {
	this.dist = dist;
    }

    //-- Instance Methods --//
    public void call(Tools target) {
	target.getDriver().drive(dist);
    }

    public String toString() { return "Drive " + dist + "m\n"; }
}