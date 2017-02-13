package org.cxb.generics;

import java.util.List;

interface SuperPower {
}

interface XRayVision extends SuperPower {
	void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
	void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
	void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
	POWER power;

	SuperHero(POWER power) {
		this.power = power;
	}

	POWER getPower() {
		return power;
	}
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {
	SuperSleuth(POWER power) {
		super(power);
	}

	void see() {
		power.seeThroughWalls();
	}
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {
	CanineHero(POWER power) {
		super(power);
	}

	void hear() {
		power.hearSubtleNoises();
	}

	void smell() {
		power.trackBySmell();
	}
}

class SuperHearSmell implements SuperHearing, SuperSmell {

	@Override
	public void trackBySmell() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hearSubtleNoises() {
		// TODO Auto-generated method stub

	}

}

class DogBoy extends CanineHero<SuperHearSmell> {
	DogBoy() {
		super(new SuperHearSmell());
	}
}

public class EpicBattle {
	static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
		hero.getPower().hearSubtleNoises();
		hero.getPower().trackBySmell();
	}

	public static void main(String[] args) {
		DogBoy db = new DogBoy();
		superFind(db);
//		List<? extends SuperHearing>
		}
}
