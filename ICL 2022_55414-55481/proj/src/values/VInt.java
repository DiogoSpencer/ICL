package values;
public class VInt implements IValue {
    
    int v;

    public VInt(int v0) { this.v = v0; }
    public VInt() {}

    public int getVal() { return v; }
    public void print() { System.out.println(v); }
}
