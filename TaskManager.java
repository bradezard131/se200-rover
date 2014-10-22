/** TaskManager.java
 *
 * Author: Bradley Ezard
 * Info:
 */

import java.util.*;

public class TaskManager implements Observer {
    //-- Class Driver --//
    public static void main(String[] args) {
	//Start taskmanager
	Comm comm = new Antenna(new Messagebox<FuncList>());
	Driver dc = new DriveController(comm);
	SoilAnalyser sa = new RoverSoilAnalyser(comm);
	Camera cam = new RoverCamera(comm);
	Tools tools = new Tools(sa, dc, cam, comm);
	Dispatcher dis = new Dispatcher(tools);
	TaskManager tm = new TaskManager(dis);
	tools.setTaskManager(tm);

	FuncList fl = new FuncList(0);
	fl.add(new DriveFunc(10));
	fl.add(new PhotoFunc());
	tm.add(fl);
	fl = new FuncList(1);
	fl.add(new TurnFunc(20));
	fl.add(new AnalyseFunc());
	tm.add(fl);

	tm.runNext();
	tm.runNext();
    }	

    //-- Instance Fields --//
    private Map<Integer, FuncList> lists;
    private int next;
    private Dispatcher d;

    //-- Constructors --//
    public TaskManager(Dispatcher d, int start) {
	if(start < 0)
	    throw new IllegalArgumentException();
	if(d == null)
	    throw new NullPointerException();

	next = start;
	this.d = d;
	lists = new HashMap<Integer, FuncList>();
    }

    public TaskManager(Dispatcher d) {
	this(d, 0);
    }

    //-- Instance Methods --//
    public void update(Observable obs, Object obj) {
	this.add(((Messagebox<FuncList>)obs).remove());
	this.runNext();
    }

    public void run(int id) {
	FuncList fl = lists.get(id);
	Function f;

	while((f = fl.next()) != null)	    
	    d.dispatch(f);
    }

    public void runNext() {
	try {
	    while(true)
		this.run(next++);
	} catch (NullPointerException npe) {
	    next--;
	}
    }

    public void add(FuncList fl) {
	if(lists.get(fl.getID()) != null)
	    throw new IllegalArgumentException();

	lists.put(fl.getID(), fl);
    }
}
