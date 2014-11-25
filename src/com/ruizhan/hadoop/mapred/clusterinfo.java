package com.ruizhan.hadoop.mapred;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.mapred.ClusterStatus;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class clusterinfo extends Configured implements Tool {

	public int run(String[] args) throws Exception {
		JobConf jobConf = new JobConf(getConf());
		JobClient client = new JobClient(jobConf);
	    ClusterStatus cluster = client.getClusterStatus();
	    System.err.println(cluster.getActiveTrackerNames());
		return 0;

	}
	
	public static void main(String[] args) throws Exception {
	    //int res = ToolRunner.run(new Configuration(), new Sort(), args);
	    //System.exit(res);
		Configuration conf = new Configuration();
		JobClient client = new JobClient(new InetSocketAddress("122.225.114.68",8020),conf);
		ClusterStatus cluster = client.getClusterStatus();
		System.err.println(cluster.getActiveTrackerNames());
		System.err.println(cluster.getMaxMapTasks());
	}


}