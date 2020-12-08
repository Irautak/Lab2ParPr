import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class JoinReducer extends Reducer<JoinWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(JoinWritableComparable key, Iterable<Text> vals, Context context) throws IOException
}
