package com.aop.megician;

public class MagicianProxy extends Magician{
	
//	private Audiance audiance = new Audiance();
	
	@Override
	public void doMagic() {
//		audiance.clapping();
		System.out.println("abraka dabra");
	}

}
