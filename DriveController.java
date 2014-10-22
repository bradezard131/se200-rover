/** DriveController.java
 *
 * Author: Bradley Ezard
 * Info: Controller for the motor of a mars rover.
 */

import java.util.*;

public class DriveController extends Driver {
    //-- Class Driver --//
    public static void main(String[] args) {
	Driver d = new DriveController(new Antenna(new Messagebox<FuncList>()));

	((DriveController)d).moveFinished();
	((DriveController)d).mechanicalError();

	d.drive(10);
	d.turn(180);
    }

    //--Instance Fields--//
    private Comm comm;
    private boolean moving;
    

    //-- Constructor --//
    public DriveController(Comm comm) {
	this.comm = comm;
	moving = false;
    }

    //-- Instance Methods --//
    public void drive(double distance) {
	this.moving = true;
	super.drive(distance);
    }

    public void turn(double angle) {
	this.moving = true;
	super.turn(angle);
    }
    
    public void moveFinished() {
	comm.send("Move successful");
	this.moving = false;
    }	

    public void mechanicalError() {
	comm.send("Move failed");
	this.moving = false;
    }

    public boolean isMoving() { return this.moving; }
}
