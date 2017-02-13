package org.cxb.generics;

class Base{}
class Derived extends Base{}

interface OrdinaryGetter{
	Base get();
}

interface DerivedGetter extends OrdinaryGetter{
	@Override
	default Derived get() {
		// TODO Auto-generated method stub
		return null;
	}
}

public class CovariantReturnTypes {
	void test(DerivedGetter d){
		Derived a = d.get();
	}
}
