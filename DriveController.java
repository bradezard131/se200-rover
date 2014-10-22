/** DriveController.java
 *
 * Author: Bradley Ezard
 * Info: Controller for the motor of a mars rover.
 */

import java.util.Observer;

public class DriveController extends Driver {
    //-- Class Driver --//
    public static void main(String[] args) {
	Driver d = new DriveController();

	((DriveController)d).moveFinished();
	((DriveController)d).mechanicalError();

	d.drive(10);
	d.turn(180);
	try { Thread.sleep(5000); } catch(Exception e) {}

	String buf = ((DriveController)d).msgs.remove();
	while(buf != null) {
	    System.out.println(buf);
	    buf = ((DriveController)d).msgs.remove();
	}
    }

    //--Instance Fields--//
    private Messagebox<String> msgs;
    
    //-- Constructor --//
    public DriveController() {
	this.msgs = new Messagebox<String>();
    }

    //-- Instance Methods --//
    public void moveFinished() {
	msgs.add("Move successful");
    }	

    public void mechanicalError() {
	msgs.add("Move failed");
    }

    public void addObserver(Observer o) {
	msgs.addObserver(o);
    }
}
