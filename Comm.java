/** Comm.java
 * 
 * Author: Bradley Ezard
 * Info: Mock of the 'provided' class for the Software Engineering 200
 *       assignment run in 2014 by Dave Cooper.
 *       Prints the message to the terminal.
 */

public abstract class Comm {
    public Comm() {}

    public void send(String message) {
	System.out.println("Sent: " + message);
    }

    protected abstract void receive(String message);
}