/** Tools.java
 *
 * Author: Bradley Ezard
 * Info:
 */

import java.util.*;

public class Tools {
    //-- Class Driver --//
    public static void main(String[] args) {
	Comm c = new Antenna(new Messagebox<FuncList>());
	Driver drv = new DriveController(c);
	Camera cam = new RoverCamera(c);
	SoilAnalyser sa = new RoverSoilAnalyser(c);
	
	Tools t = new Tools(sa, drv, cam, c);
	Dispatcher d = new Dispatcher(t);
	TaskManager tm = new TaskManager(d);

	System.out.println("Tools Constructed");
    }

    //-- Instance Fields --//
    private SoilAnalyser sa;
    private Driver d;
    private Camera cam;
    private Comm comm;
    private TaskManager tm;


    //-- Constructor --//
    public Tools(SoilAnalyser sa,
		 Driver d,
		 Camera cam,
		 Comm comm) {
	this.sa = sa;
	this.d = d;
	this.cam = cam;
	this.comm = comm;
    }

    //-- Instance Methods --//
    public SoilAnalyser getSoilAnalyser() { return this.sa; }
    public Driver getDriver() { return this.d; }
    public Camera getCamera() { return this.cam; }
    public Comm getComm() { return this.comm; }
    public TaskManager getTaskManager() { return this.tm; }

    public void setTaskManager(TaskManager tm) {
	this.tm = tm;
    }
}
