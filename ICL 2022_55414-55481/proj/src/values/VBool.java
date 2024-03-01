package values;

public class VBool implements IValue {
    
    boolean val;

    public VBool(boolean val) { this.val = val; }
    public VBool() {}

    public boolean getVal() { return val; }

    public void print() { System.out.println(val); }
}
