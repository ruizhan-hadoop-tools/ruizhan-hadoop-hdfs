package com.ruizhan.hadoop.hdfs;

import org.apache.hadoop.fs.Path;

public class test_main {

	public static void main(String[] args) {
		if (args.length!=1){
			System.err.println("args error!");
		}
		else{
			Path mypath = new Path(args[0]);
			System.err.println(mypath.toString());
		}
			
				
	}

}
