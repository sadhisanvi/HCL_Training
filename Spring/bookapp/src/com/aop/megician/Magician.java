package com.aop.megician;

import org.springframework.stereotype.Service;

@Service("m")
public class Magician {
	
	
	// the magic of aop is that there is no trace of audiance code inside magician
	//later we want to do tx, log4j ... but i want there should not be any trance of tx or logging
	
	//service = BL + CCC(AOP)

	public void doMagic() {
		System.out.println("abraka dabra");
	}

}
