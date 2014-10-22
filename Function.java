/** Function.java
 *
 * Author: Bradley Ezard
 * Info:
 */

public abstract class Function implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    //-- Constructor --//
    public Function() {}

    //-- Instance Methods --//
    public abstract void call(Tools target);

}
