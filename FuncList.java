/** FuncList.java
 *
 * Author: Bradley Ezard
 * Info:
 */

import java.util.*;

public class FuncList implements java.io.Serializable {
    //-- Class Driver --//
    public static void main(String[] args) {
	FuncList fl = new FuncList(1);

	fl.add(new DriveFunc(1));
	fl.add(new PhotoFunc());

	System.out.println(fl.toString());

	fl.next();
	fl.next();

	System.out.println("TEST COMPLETE");
    }

    // Serialization Version
    private static final long serialVersionUID = 1L;

    //-- Instance Fields --//
    private ArrayList<Function> list;
    private int id;
    private Iterator<Function> it;

    //-- Constructor --//
    public FuncList(int id) { 
	this.setID(id);
	list = new ArrayList<Function>();
    }

    public FuncList(int id, List<Function> list) {
	this(id);
	for(Function f : list)
	    this.list.add(f);
    }

    //-- Instance Methods --//
    private void setID(int id) {
	if(id < 0)
	    throw new IllegalArgumentException();

	this.id = id;
    }

    public Function next() {
	if(this.it == null)
	    it = list.iterator();

	if(it.hasNext())
	    return it.next();
	else
	    return null;
    }

    public int getID() { return this.id; }
    
    public void add(Function f) {
	this.list.add(f);
    }

    public String toString() {
	return "ID: " + this.id + "\n" + this.list.toString();
    }
}
