/** SoilAnalyser.java
 * 
 * Author: Bradley Ezard
 * Info: Mock of the 'provided' class for the Software Engineering 200
 *       assignment run in 2014 by Dave Cooper.
 *       Prints the attempted task to terminal then spawns a thread which
 *       waits (to simulate the completion of the task) then calls the finished
 *       method.
 */

public abstract class SoilAnalyser {
    //-- Internal Class --//
    private class AnalyseThread extends Thread {
	private SoilAnalyser sa;

	public AnalyseThread(SoilAnalyser sa) {
	    this.sa = sa;
	}

	@Override
	public void run() {
	    try { Thread.sleep(5000); } catch(InterruptedException ie) {}
	    sa.analysisReady("Analysis Complete");
	}
    }

    //-- SoilAnalyser class --//
    public SoilAnalyser() {}

    public void analyse() {
	System.out.println("Analysing Soil");
	(new AnalyseThread(this)).start();
    }

    protected abstract void analysisReady(String analysis);
}