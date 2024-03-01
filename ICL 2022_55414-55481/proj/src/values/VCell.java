package values;

public class VCell implements IValue {

    IValue v;

    public VCell(IValue v) {

        this.v = v;
    }

    public IValue get() { return v; }

    public void set(IValue v) { this.v = v; }

    @Override
    public void print() {

        v.print();
    }
    
}
