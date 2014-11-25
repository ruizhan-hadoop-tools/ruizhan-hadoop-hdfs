package com.ruizhan.hadoop.mapred;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.ClusterStatus;
import org.apache.hadoop.mapred.JobClient;


public class clusterinfo  {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		JobClient cli = new JobClient(new InetSocketAddress("hadoop-808-01.hzfh",8021),conf);
		ClusterStatus cluster_status_1 = cli.getClusterStatus();
		System.err.println(cluster_status_1.getMaxMemory());
		System.err.println(cluster_status_1.getMapTasks());
		System.err.println(cluster_status_1.getMaxMapTasks());
	
	}


}
