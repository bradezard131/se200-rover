/** Messagebox.java
 *
 * Author: Bradley Ezard
 * Info:
 */

import java.util.*;

public class Messagebox<E> extends Observable {
    //-- Instance Fields --//
    private Queue<E> box;

    //-- Constructor --//
    public Messagebox() {
	this.box = new LinkedList<E>();
    }

    //-- Instance Methods --//
    public void add(E itm) {
	box.add(itm);
	this.setChanged();
	this.notifyObservers();
    }

    public E remove() {
	try {
	    return box.remove();
	} catch (Exception e) {
	    return null;
	}
    }
}
