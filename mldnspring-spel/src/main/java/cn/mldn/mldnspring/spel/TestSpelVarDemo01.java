package cn.mldn.mldnspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelVarDemo01 {
	public static void main(String[] args) throws Exception {
		String str = "#myvar1 + #myvar2";	// 定义了两个变量 
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);
		EvaluationContext context = new StandardEvaluationContext(exp);
		context.setVariable("myvar1", 10);
		context.setVariable("myvar2", 20);
		System.out.println(exp.getValue(context)); 
	} 
}
