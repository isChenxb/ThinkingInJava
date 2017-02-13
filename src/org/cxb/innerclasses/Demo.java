package org.cxb.innerclasses;

interface ReturnString{
	public String returnString();
}

class Out{
	public ReturnString getDs(String i){
		String a = i;
		return new ReturnString(){
			String label = a;
			@Override
			public String returnString() {
				// TODO Auto-generated method stub
				return label;
			}
			
		};
	}
}

public class Demo {
	public static void main(String[] args) {
		ReturnString rs = new Out().getDs("hahha");
		System.out.println(rs.returnString());
	}
}
