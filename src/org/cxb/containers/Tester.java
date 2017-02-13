package org.cxb.containers;

import java.util.List;

public class Tester<C>{
	//统一打印字段的长度
	public static int fieldWidth = 8;
	//默认的测试参数
	public static TestParam[] defaultParam = TestParam.array(
			10 , 5000 , 100 , 5000 , 1000 , 5000 , 10000 , 500);
	protected C container;
	protected C initialize(int size){
		return container;
	}
	private static String StringField(){
		return "%" + fieldWidth + "s";
	}
	private static String numberField(){
		return "%" + fieldWidth + "d";
	}
	private String headLine = "";
	private int sizeWidth = 5;
	private String sizeField = "%" + sizeWidth + "s";
	private List<Test<C>> tests;
	private TestParam[] paramList = defaultParam;
	public void setHeadLine(String newHead){
		headLine = newHead;
	}
	public Tester(C container , List<Test<C>> tests){
		this.container = container;
		this.tests = tests;
		if (container != null)
			headLine = container.getClass().getSimpleName();
	}
	public Tester(C container , List<Test<C>> tests , 
			TestParam[] params){
		this(container, tests);
		paramList = params;
	}
	
	public static <C> void run(C container , List<Test<C>> tests){
		new Tester<C>(container , tests).timedTest();
	}
	public static <C> void run(C container , List<Test<C>> tests ,
			TestParam[] paramList){
		new Tester<C>(container , tests , paramList).timedTest();
	}
	private void displayHeader(){
		int width = tests.size() * fieldWidth + sizeWidth;
		int dashLength = width - headLine.length() - 1;
		StringBuilder result = new StringBuilder();
		for (int i = 0 ; i < dashLength / 2 ; i++)
			result.append("-");
		result.append(" ");
		result.append(headLine);
		result.append(" ");
		for (int i = 0 ; i < dashLength / 2 ; i++)
			result.append("-");
		System.out.println(result.toString());
		System.out.format(sizeField , "size");
		for (Test test : tests)
			System.out.format(StringField()	, test.name);
		System.out.println();
	}
	
	public void timedTest(){
		displayHeader();
		for (TestParam param : paramList){
			System.out.format(sizeField , param.size);
			for (Test<C> test : tests){
				C testContainer = initialize(param.size);
				long start = System.nanoTime();
				int reps = test.test(testContainer , param);
				long durringTimes = System.nanoTime() - start;
				long repsTime = durringTimes / reps;
				System.out.format(numberField() , repsTime);
			}
			System.out.println();
		}
	}
	
}
