package org.cxb.innerclasses;

class WithInner{
	class Inner{}
}

public class InheritInner extends WithInner.Inner{
	InheritInner(WithInner with){
		with.super();
	}
}
