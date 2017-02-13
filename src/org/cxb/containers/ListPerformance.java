package org.cxb.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

import net.mindview.util.CollectionData;
import net.mindview.util.CountingGenerator;
import net.mindview.util.CountingIntegerList;
import net.mindview.util.Generated;

public class ListPerformance {
	static Random rand = new Random();
	static int reps = 1000;
	static List<Test<List<String>>> tests = 
			new ArrayList<Test<List<String>>>();
	static List<Test<LinkedList<String>>> qTests = 
			new ArrayList<Test<LinkedList<String>>>();
	static{
		tests.add(new Test<List<String>>("add"){
			@Override
			int test(List<String> container, TestParam tp) {
				int loops = tp.loops;
				int listSize = tp.size;
				for (int i = 0 ; i  < loops ; i++){
					container.clear();
					for (int j = 0 ; j < listSize ; j++)
						container.add(j+"");
				}
				return loops * listSize;
			}
		});
		tests.add(new Test<List<String>>("get"){
			@Override
			int test(List<String> container, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = tp.size;
				for (int i = 0 ; i < loops ; i++)
					container.get(rand.nextInt(listSize));
				return loops;
			}
		});
		tests.add(new Test<List<String>>("set"){
			int test(List<String> container, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = tp.size;
				for (int i = 0 ; i < loops ; i++)
					container.set(rand.nextInt(listSize), "hha");
				return loops;
			}
		});
		tests.add(new Test<List<String>>("iteradd"){
			int test(List<String> container , TestParam tp){
				final int LOOPS = 1000000;
				int half = container.size() / 2;
				ListIterator<String> it = container.listIterator(half);
				for (int i = 0 ; i < LOOPS ; i++)
					it.add("haha");
				return LOOPS;
			}
		});
		tests.add(new Test<List<String>>("insert"){
			@Override
			int test(List<String> container, TestParam tp) {
				int loops = tp.loops;
				for (int i = 0 ; i < loops ; i++)
					container.add(5 , "haha");
				return loops;
			}
		});
		tests.add(new Test<List<String>>("remove"){
			@Override
			int test(List<String> container, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0 ; i < loops ; i++){
					container.clear();
					container.addAll(new CollectionData<String>(new CountingGenerator.String(), size));
					while(container.size() > 5)
						container.remove(5);
				}
				return loops * size;
			}
		});
		//Tests for queue behavior:
		qTests.add(new Test<LinkedList<String>>("addFirst"){
			@Override
			int test(LinkedList<String> container, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0 ; i < loops ; i++){
					container.clear();
					for (int j = 0 ; j < size ; j++)
						container.addFirst("haha");
				}
				return loops * size;
			}
		});
		qTests.add(new Test<LinkedList<String>>("addLast"){
			@Override
			int test(LinkedList<String> container, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0 ; i < loops ; i++){
					container.clear();
					for (int j = 0 ; j < size ; j++)
						container.addLast("haha");
				}
				return loops * size;
			}
		});
		qTests.add(new Test<LinkedList<String>>("rmFirst"){
			@Override
			int test(LinkedList<String> container, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0 ; i < loops ; i++){
					container.clear();
					container.addAll(new CollectionData<String>(new CountingGenerator.String() , size));
					while(container.size() > 0)
						container.removeFirst();
				}
				return loops * size;
			}
		});
		qTests.add(new Test<LinkedList<String>>("rmLast"){
			@Override
			int test(LinkedList<String> container, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0 ; i < loops ; i++){
					container.clear();
					container.addAll(new CollectionData<String>(new CountingGenerator.String() , size));
					while(container.size() > 0)
						container.removeLast();
				}
				return loops * size;
			}
		});
	}
	static class ListTester extends Tester<List<String>>{
		public ListTester(List<String> container ,
				List<Test<List<String>>> tests){
			super(container , tests);
		}
		@Override
		protected List<String> initialize(int size) {
			container.clear();
			container.addAll(new CollectionData<String>(new CountingGenerator.String() , size));
			return container;
		}
		//Convenience method:
		public static void run(List<String> list , 
				List<Test<List<String>>> tests){
			new ListTester(list , tests).timedTest();
		}
	}
	public static void main(String[] args) {
		if (args.length > 0)
			Tester.defaultParam = TestParam.array(args);
		//Can only do these two tests on an array:
		Tester<List<String>> arrayTest = 
				new Tester<List<String>>(null , tests.subList(1, 3)){
			@Override
			protected List<String> initialize(int size) {
				String[] ia = Generated.array(String.class, new CountingGenerator.String(), size);
				return Arrays.asList(ia);
			}
		};
		arrayTest.timedTest();
		Tester.defaultParam = TestParam.array(
				10 , 5000 , 100 , 5000 , 1000 , 1000 , 10000 , 200);
		if (args.length > 0)
			Tester.defaultParam = TestParam.array(args);
		ListTester.run(new ArrayList<String>(), tests);
		ListTester.run(new LinkedList<String>(), tests);
		ListTester.run(new Vector<String>(), tests);
		Tester.fieldWidth = 12;
		Tester<LinkedList<String>> qTest = 
				new Tester<LinkedList<String>>(new LinkedList<String>() , qTests);
		qTest.setHeadLine("Queue tests");
		qTest.timedTest();
	}
}
