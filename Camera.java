/** Camera.java
 * 
 * Author: Bradley Ezard
 * Info: Mock of the 'provided' class for the Software Engineering 200
 *       assignment run in 2014 by Dave Cooper.
 *       Prints the attempted task to terminal then spawns a thread which
 *       waits (to simulate the completion of the task) then calls the finished
 *       method.
 */


public abstract class Camera {
    //-- Internal Class --//
    private class PhotoThread extends Thread {
	private Camera c;

	public PhotoThread(Camera c) {
	    this.c = c;
	}

	@Override
        public void run() {
	    try { Thread.sleep(1000); } catch(InterruptedException ie) {}
	    c.photoReady("Photo taken".toCharArray());
	}
    }

    //-- Camera Class --//
    public Camera() {}

    public void takePhoto() {
	System.out.println("Taking Photo");
	(new PhotoThread(this)).start();
    }

    protected abstract void photoReady(char[] photoData);
}