package com.infy.employee.finance.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.infy.employee.finance.exception.FinanceException;
;

@Component
@Aspect
public class Aspectlogging {
	
	   private static final Log LOGGER = LogFactory.getLog(Aspectlogging.class);

	    @AfterThrowing(pointcut="execution(* com.infy.employee.service.*Impl.*(..))",throwing = "exception")
	    public void logServiceException(FinanceException exception)
	    {
		// code
	    	LOGGER.error(exception.getMessage(),exception);
	    }

}
