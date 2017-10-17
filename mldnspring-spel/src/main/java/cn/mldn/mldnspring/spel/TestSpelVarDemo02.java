package cn.mldn.mldnspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelVarDemo02 {
	public static void main(String[] args) throws Exception {
		String str = "#root";	// 定义了两个变量 
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);	// 设置了一个自定义的根变量
		// 为这个根变量直接执行赋值处理操作
		EvaluationContext context = new StandardEvaluationContext("Hello World");
		System.out.println(exp.getValue(context)); 
	} 
} 
