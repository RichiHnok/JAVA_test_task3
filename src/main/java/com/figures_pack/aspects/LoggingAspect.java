package com.figures_pack.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	@Before("execution(* Main.sayHello(..))")
	public void logBefore() {
		System.out.println("Метод sayHello() будет вызван");
	}
}
