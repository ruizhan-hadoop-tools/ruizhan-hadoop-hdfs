package com.ruizhan.hadoop.mapred;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.mapred.ClusterStatus;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Cluster;
import org.apache.hadoop.mapreduce.ClusterMetrics;
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
		JobClient cli = new JobClient(new InetSocketAddress("10.6.252.77",8021),conf);
		//Cluster cluster = new Cluster(new InetSocketAddress("10.6.252.77",8021),conf);
		//ClusterMetrics cluster_status_0 = cluster.getClusterStatus();
		ClusterStatus cluster_status_1 = cli.getClusterStatus();
		//System.err.println(cluster_status_0.getMapSlotCapacity());
		//System.err.println(cluster_status_0.getReservedMapSlots());
		System.err.println(cluster_status_1.getMaxMemory());
		Cluster cluster = cli.getClusterHandle();
		ClusterMetrics cluster_status_0 = cluster.getClusterStatus();
		System.err.println(cluster_status_0.getMapSlotCapacity());
		System.err.println(cluster_status_0.getReservedMapSlots());		
	}


}
