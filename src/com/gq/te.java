package com.gq;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/** 
* @className:te.java
* @classDescription:
* @author:gengqiao
* @createTime:2016-7-25
*/
public class te {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] str={"103","104","105","106","107","108"};
		List list =Arrays.asList(str);
    System.out.println(list.contains("100"));
	}
}
