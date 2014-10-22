/** Rover.java
 *
 * Author: Bradley Ezard
 * Info:
 */

public class Rover {
    //-- Class Driver --//
    public static void main(String[] args) {
	Rover r = new Rover();
	
	//if(args.length > 1 && args[1].equals("-test"))
	    r.test();
	    //else
	    //r.start();
    }

    //-- Constructor --//
    public Rover() {}

    //-- Instance Methods --//

    public void start() { start(false); }
    public void test() { start(true); }

    private void start(boolean test) {
	// Setup Tools
	Messagebox<FuncList> inbox = new Messagebox<FuncList>();
	Comm comm = new Antenna(inbox);
	Driver dc = new DriveController(comm);
	Camera cam = new RoverCamera(comm);
	SoilAnalyser sa = new RoverSoilAnalyser(comm);
	Tools tools = new Tools(sa, dc, cam, comm);
	
	// Setup TaskManager
	Dispatcher dis = new Dispatcher(tools);
	TaskManager tm = new TaskManager(dis);
	tools.setTaskManager(tm);
	
	// Link Components
	inbox.addObserver(tm);

	if(test == true) {
	    comm.receive(genTest(1));
	    comm.receive(genTest(0));
	}
    }

    private String genTest(int id) {
	FuncList fl = null;
	if(id == 0) {
	    fl = new FuncList(0);
	    Function[] funcs = {
		new DriveFunc(10),
		new TurnFunc(120),
		new DriveFunc(20),
		new PhotoFunc(),
		new TurnFunc(180),
		new PhotoFunc(),
		new AnalyseFunc()
	    };
	    for(Function f : funcs) fl.add(f);
	}

	if(id == 1) {
	    fl = new FuncList(1);
	    Function[] funcs = {
		new TurnFunc(360),
		new DriveFunc(100),
		new PhotoFunc(),
		new PhotoFunc(),
		new RecallFunc(0),
		new PhotoFunc(),
		new AnalyseFunc(),
		new DriveFunc(32),
		new AnalyseFunc(),
		new RecallFunc(0),
		new RecallFunc(0)
	    };
	    for(Function f : funcs) fl.add(f);
	}
	
	try {
	    return Encoder.serialize(fl);
	} catch (java.io.IOException ioe) {
	    return "COULDN'T ENCODE LIST";
	}
    }
}
