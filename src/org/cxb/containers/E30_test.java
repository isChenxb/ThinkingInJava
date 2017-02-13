package org.cxb.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import net.mindview.util.CollectionData;
import net.mindview.util.CountingIntegerList;
import net.mindview.util.RandomGenerator;

public class E30_test {
	public static void main(String[] args) {
		Test<List<Integer>> test = new Test<List<Integer>>("Collections.sort()"){
			@Override
			int test(List<Integer> container, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0 ; i < loops ; i++){
					container.clear();
					container.addAll(CollectionData.list(new RandomGenerator.Integer(), size));
					Collections.sort(container);
				}
				return loops;
			}
		};
		List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
		tests.add(test);
		Tester.run(new ArrayList<Integer>(), tests);
		Tester.run(new LinkedList<Integer>(), tests);
	}
}
