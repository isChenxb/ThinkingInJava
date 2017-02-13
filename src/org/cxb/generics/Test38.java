package org.cxb.generics;

class BasicCoffee{
	private String type;
	public BasicCoffee(){}
	public BasicCoffee(String type){ this.type = type; } 
	public void set(String type){ this.type = type; }
	public String get(){ return type; }
}

class CoffeeDecorator extends BasicCoffee{
	protected BasicCoffee coffee;
	public CoffeeDecorator(BasicCoffee coffee){
		super();
		this.coffee = coffee;
	}
	public void set(String type){
		coffee.set(type);
	}
	public String get(){
		return coffee.get();
	}
}

class SteamMilk extends CoffeeDecorator{
	public SteamMilk(BasicCoffee coffee){
		super(coffee);
		set(get() + " &SteamMilk");
	}
}

class Foam extends CoffeeDecorator{
	public Foam(BasicCoffee coffee){
		super(coffee);
		set(get() + " &Foam");
	}
}



public class Test38 {

}
