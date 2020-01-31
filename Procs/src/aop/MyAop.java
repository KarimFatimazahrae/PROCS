package aop;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAop {
	public void log() {
		System.out.println("*******************Hello! I'm your AOP Class****************************");
	}
	
	public void log2(ProceedingJoinPoint pjp)throws Throwable {
		
		if(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)<12){
			pjp.proceed();
		}
		else 
			{
			System.out.println("************ I'm your Aspect PJP**************");
			}
	}

}