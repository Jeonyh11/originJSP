package kr.or.ddit.servlet.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Factorial {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Factorial.class);
	
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		int result = factorial.calculate(0);
		
		if(result == 1) {
			logger.debug("success");
		}else {
			logger.debug("fail");
		}

	}

	

	public int calculate(int i) {
		int fac = 1;
		for(int j = 1; j <=i; j++) {
			fac = fac * j;
		}
		return fac;
	}
	

}
