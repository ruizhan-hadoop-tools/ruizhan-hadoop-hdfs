package com.ruizhan.hadoop.mapred;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.ClusterStatus;
import org.apache.hadoop.mapred.JobClient;


public class clusterinfo  {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		JobClient cli = new JobClient(new InetSocketAddress("10.6.252.77",8021),conf);
		ClusterStatus cluster_status = cli.getClusterStatus();
		System.out.println("MaxMapTasks:" + new Integer(cluster_status.getMaxMapTasks()).toString());
		System.out.println("MapTasks:" + new Integer(cluster_status.getMapTasks()).toString());
		System.out.println("MaxReduceTasks:" + new Integer(cluster_status.getMaxReduceTasks()).toString());
		System.out.println("ReduceTasks:" + new Integer(cluster_status.getReduceTasks()).toString());
		System.out.println("BlacklistedTrackersNums:" + new Integer(cluster_status.getBlacklistedTrackers()).toString());
		System.out.println("BlacklistedTrackerNames:" + transFromCollection(cluster_status.getBlacklistedTrackerNames()));
		System.out.println("NumExcludedNodes:" + new Integer(cluster_status.getNumExcludedNodes()).toString());
		System.out.println("ActiveTrackerNames:" + transFromCollection(cluster_status.getActiveTrackerNames()).toString());
		System.out.println("TaskTrackers:" + new Integer(cluster_status.getTaskTrackers()).toString());

	}
	
	private static String transFromCollection(Collection<?> collect){
		String line = new String("");
		Iterator itr = collect.iterator();
		while (itr.hasNext()) {
			line.concat(itr.next().toString()+";");
		}
		return line;
	}


}
