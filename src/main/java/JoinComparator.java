import org.apache.hadoop.io.WritableComparator;

public class JoinComparator extends WritableComparator {
    protected JoinComparator(){
        super(JoinWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparator a, WritableComparator b) {
        JoinWritableComparable that = (JoinWritableComparable)a;
        JoinWritableComparable other = (JoinWritableComparable)b;
        return that.compareTo(other);
    }
}
