import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Job job = Job.getInstance();
        job.setJarByClass(Main.class);
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AirportMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setReducerClass(JoinReducer.class);
        job.setPartitionerClass(JoinPartitioner.class);
        job.setGroupingComparatorClass(JoinComparator.class);
        job.setMapOutputKeyClass(JoinWritableComparable.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setNumReduceTasks(4);
        job.waitForCompletion(true);

    }
}
