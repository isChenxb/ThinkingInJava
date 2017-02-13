package org.cxb.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pet{}
class Dog extends Pet{}
class Cat extends Pet{}

public class CheckedList {
	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyDogs){
		probablyDogs.add(new Cat());
	}
	
	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1); // Quietly accepts a Cat
		List<Dog> sogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
//		oldStyleMethod(sogs2);
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
		pets.add(new Pet());
		pets.add(new Cat());
		pets.add(new Dog());
	}
}
