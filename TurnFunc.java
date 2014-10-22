/** TurnFunc.java
 * 
 * Author: Bradley Ezard
 * Info: 
 */

public class TurnFunc extends Function {
    //-- Instance Fields --//
    private double degrees;

    //-- Constructor --//
    public TurnFunc(double degrees) {
	this.degrees = degrees;
    }

    //-- Instance Methods --//
    public void call(Tools target) {
	target.getDriver().turn(degrees);
    }
}