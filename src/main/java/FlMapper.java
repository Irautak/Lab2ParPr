import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlMapper extends Mapper<> {
    private static final int AIRPORT_ID = 14;
    private static final int DELAY_TIME = 18;
    

    private static float toFloat(String column) {
        if (!column.equals("")) {
            return Float.parseFloat(column);
        } else {
            return 0.0f;
        }
    }

    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String[] columns = value.toString().split(",");
        if (key.get() > 0) {
            float delayTime = toFloat(columns[DELAY_TIME]);
            if (delayTime > 0.0f) {
                int airportID = Integer.parseInt(columns[AIRPORT_ID]);
                JoinWritableComparable key_ = new JoinWritableComparable(airportID, 1);
                context.write(key_, new Text(columns[DELAY_TIME]));
            }
        }
    }
}
