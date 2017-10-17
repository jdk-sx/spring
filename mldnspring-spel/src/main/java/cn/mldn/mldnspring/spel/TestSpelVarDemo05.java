package cn.mldn.mldnspring.spel;

import java.util.Date;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelVarDemo05 {
	public static void main(String[] args) throws Exception {
		String str = "Time";	// Date类中的getTime()方法
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);	// 设置了一个自定义的根变量
		// 为这个根变量直接执行赋值处理操作
		EvaluationContext context = new StandardEvaluationContext(new Date());
		System.out.println(exp.getValue(context)); 
		System.out.println(System.currentTimeMillis());
	} 
} 
