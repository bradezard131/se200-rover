/** Tools.java
 *
 * Author: Bradley Ezard
 * Info:
 */

import java.util.*;

public class Tools {
    //-- Instance Fields --//
    private TaskManager tm;
    private SoilAnalyser sa;
    private Driver d;
    private Camera cam;
    private Comm comm;


    //-- Constructor --//
    public Tools(TaskManager tm,
		 SoilAnalyser sa,
		 Driver d,
		 Camera cam,
		 Comm comm) {
	this.tm = tm;
	this.sa = sa;
	this.d = d;
	this.cam = cam;
	this.comm = comm;
    }

    //-- Instance Methods --//
    public TaskManager getTaskManager() { return this.tm; }
    public SoilAnalyser getSoilAnalyser() { return this.sa; }
    public Driver getDriver() { return this.d; }
    public Camera getCamera() { return this.cam; }
    public Comm getComm() { return this.comm; }
}