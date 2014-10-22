/** Dispatcher.java
 *
 * Author: Bradley Ezard
 * Info:
 */

import java.util.*;
import java.io.*;

public class Dispatcher {
    //-- Class Driver --//
    public static void main(String[] args) {
	Comm c = new Antenna(new Messagebox<FuncList>());
	Dispatcher d = new Dispatcher(new Tools(new RoverSoilAnalyser(c),
						new DriveController(c),
						new RoverCamera(c),
						c));

	d.dispatch((new DriveFunc(10)));
	d.dispatch((new TurnFunc(120)));
	d.dispatch((new PhotoFunc()));
	d.dispatch((new AnalyseFunc()));
	d.dispatch((new RecallFunc(1)));
    }
    
    //-- Instance Fields --//
    private Tools t;

    //-- Constructor --//
    public Dispatcher(Tools t) {
	if(t == null)
	    throw new NullPointerException();

	this.t = t;
    }

    //-- Instance Methods --//
    public void dispatch(Function f) {
	f.call(this.t);
    }

    public void send(LinkedList<String> messages) {
	try { 
	    t.getComm().send(Encoder.serialize(messages));
	} catch (IOException e) {
	    t.getComm().send("Couldn't Serialize List");
	}
    }
}
