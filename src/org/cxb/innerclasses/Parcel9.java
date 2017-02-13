package org.cxb.innerclasses;

interface Destination2{
	String readLabel();
}

public class Parcel9 {
  // Argument must be final to use inside
  // anonymous inner class:
  public Destination2 destination(String dest) {
    return new Destination2() {
      public String readLabel() {
    	  return dest; 
    	  }
    };
  }
  public static void main(String[] args) {
    Parcel9 p = new Parcel9();
    String s = "hhaa";
    Destination2 d = p.destination(s);
  }
} ///:~
