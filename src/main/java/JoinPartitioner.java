import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class JoinPartitioner extends Partitioner<JoinWritableComparable, Text> {
    @Override
    public int getPartition(JoinWritableComparable key, Text value, int numReduceTasks) {
        return key.getAirportID() % numReduceTasks;
    }
}
