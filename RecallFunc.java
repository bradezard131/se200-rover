/** RecallFunc.java
 *
 * Author: Bradley Ezard
 * Info:
 */

public class RecallFunc extends Function {
    //-- Instance Fields --//
    private int id;

    //-- Constructor --//
    public RecallFunc(int id) {
	this.id = id;
    }

    //-- Instance Methods --//
    public void call(Tools target) {
	target.getTaskManager().run(id);
    }
}