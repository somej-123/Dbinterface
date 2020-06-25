package org.edu.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
* ...474p.
* ...@Component : 스프링의 빈으로 인식하기 위한 설정.
* ...@Aspect : AOP기능을 하는 클래스 선언에 추가함.
*/
@Component
@Aspect
public class SampleAdvice {

private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
		
/*
 * ...474p.@Before : @Before가 붙은 메서드를 target메서드보다 먼저 실행시킴.
 * ...execution~구문 : Pointcut을 지정하며 AspectJ언어 문법을 사용함.
 * ...'org.edu.service.BoardService~'로 시작하는 모든 클래스의 '*'(모든)메서드를 지정함.
 * ...설정이 올바르게 되면 메서드 앞에 화살표 아이콘이 적용됨.
 * log내용은 /main/resources/log4j.xml 에 Root Logger 확인
 * ...특정 컨트롤러를 호출할때 전달되는 파라미터를 확인하기 위해
 * ...JoinPoint 타입을 사용함.
 */
@Before("execution(* org.edu.service.SampleService*.*(..))")
public void startLog(JoinPoint jp) {//전송값을 잡아낼 장소를 지정 jp = joinpoint

  logger.debug("----------------------------");
  logger.debug("S.debugLog.----------------------------");
  logger.debug(Arrays.toString(jp.getArgs()));  
  logger.debug("E.debugLog.----------------------------");
}  
/*
 * ...Around타입의 기능은 파라미터로 ProceedingJoinPoint(클래스) 타입을 사용함.
 * ...ProceedingJoinPoint는 JoinPoint의 모든 메서드를 가지면서도, 직접 target객체의
 * ...메서드를 실행할 수 있는 기능이 추가됨.
 * ...ProceedingJoinPoint.proceed()는 특이하게도 Exception보다 상위의 Throwable을 처리하므로
 * ...메서드의 선언에 Throwable을 사용하고 있고, 시간을 체크하는 기능을 작성할 수 있음.
 * ...@Around를 이용하는 경우 반드시 메서드의 리턴타입은 Object로 선언해야 함.
 * ...@Around는 메서드를 직접 호출하고, 결과를 반환해야만 정상적인 처리가 됨. 
 */
@Around("execution(* org.edu.service.SampleService*.*(..))")//...495p.주석.트랜잭션.
public Object timeLog(ProceedingJoinPoint pjp)throws Throwable{
	    
  logger.debug("S.debugLog.=============================================");
  long startTime = System.currentTimeMillis();
  logger.debug(Arrays.toString(pjp.getArgs()));
  
  Object result = pjp.proceed();
  
  long endTime = System.currentTimeMillis();
  logger.debug( pjp.getSignature().getName()+ " : " + (endTime - startTime) );
  logger.debug("E.debugLog.=============================================");
  
  return result;
} 
}