import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<JoinWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(JoinWritableComparable key, Iterable<Text> vals, Context context) throws IOException, InterruptedException {
        Iterator<Text> iterator = vals.iterator();
        Text airportName = new Text("Airport name: " + iterator.next().toString());
        if (iterator.hasNext()) {
            int i =0;
            float cur;
            float min = 0.00f;
            float max = 0.00f;
            float avg = 0.00f;
            while (iterator.hasNext()) {
                cur = Float.parseFloat(iterator.next().toString());
                if (cur < min || i == 0) min = cur;
                else if (cur > max) max = cur;
                avg += cur;
                i++;
            }
            avg /= i;
            Text stats = new Text("Min: " + min +
                                    "Avg: " + avg +
                                    "Max: " + max);
            
        }
    }
}
