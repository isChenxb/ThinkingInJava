package org.cxb.containers;

import java.util.ArrayList;

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

public class CollectionDataGeneration {
	public static void main(String[] args) {
		System.out.println(new ArrayList<String>(
				CollectionData.list(new RandomGenerator.String(), 10)));
		System.out.println(new ArrayList<Integer>(
				CollectionData.list(new RandomGenerator.Integer(), 10)));
	}
}
