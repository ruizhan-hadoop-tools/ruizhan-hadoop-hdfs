package org.apache.hadoop.fs;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.GlobExpander;
import org.apache.hadoop.fs.Path;

public class test_main {

	public static void main(String[] args) throws Exception {
		if (args.length!=1){
			System.err.println("args error!");
		}
		else{
			Path mypath = new Path(args[0]);
			Configuration conf=new Configuration();
			Path globPath = new Path(args[0]);
			
			List filePatterns = GlobExpander.expand(args[0]);
			Iterator itr = filePatterns.iterator();
			while (itr.hasNext()){
				System.err.println(itr.next().toString());
			}
			
		    FileSystem fs = globPath.getFileSystem(conf);
		    FileStatus fstatus = fs.getFileStatus(mypath);
		    System.err.println(fstatus.getPath());
		    System.err.println(fstatus.getBlockSize());
		    System.err.println(fstatus.getLen());
		    FileStatus[] stats = fs.globStatus(globPath);
		    //for (FileStatus file_stats : stats){
		    //	System.err.println(file_stats.getPath().toString());
		    //}
		    System.err.println(stats.length);
		    
		}
			
				
	}

}
