/** TaskManager.java
 *
 * Author: Bradley Ezard
 * Info:
 */

import java.util.*;

public class TaskManager {
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
    public void run(int id) {
	FuncList fl = lists.get(id);
	Function f;
	
	while((f = fl.next()) != null)	    
	    d.dispatch(f);
    }

    public void runNext() {
	this.run(next++);
    }

    public void add(FuncList fl) {
	if(lists.get(fl.getID()) != null)
	    throw new IllegalArgumentException();

	lists.put(fl.getID(), fl);
    }
}