/** Driver.java
 * 
 * Author: Bradley Ezard
 * Info: Mock of the 'provided' class for the Software Engineering 200
 *       assignment run in 2014 by Dave Cooper.
 *       Prints the attempted task to terminal then spawns a thread which
 *       waits (to simulate the completion of the task) then calls the finished
 *       method. Optional overloaded method to force a mechanical error.
 */

public abstract class Driver {
    //-- Internal Classes --//
    private class Move extends Thread {
	private double dist;
	private Driver d;
	
	public Move(Driver d, double dist) {
	    this.dist = dist;
	}
	
	@Override
	public void run() {
	    this.run(true);
	}

	public void run(boolean success) {

	    if(dist < 0)
		dist *= -1; //Make dist positive for loop

	    for(double d = 0; d < dist; d += 0.5) 
		try { Thread.sleep(100); } catch(InterruptedException ie) {}

	    if(success)
		d.moveFinished();
	    else
		d.mechanicalError();
	}
    }

    //-- Driver Class --//

    public Driver() {}

    public void drive(double distance) {
	System.out.println("Attempt to drive: " + distance + " meters");
	(new Move(this, distance)).start();
    }

    public void turn(double angle) {
	System.out.println("Attempt to turn " + angle + " degrees");
	(new Move(this, angle)).start();
    }

    protected abstract void moveFinished();
    protected abstract void mechanicalError();
}