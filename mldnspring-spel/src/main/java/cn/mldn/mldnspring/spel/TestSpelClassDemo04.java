package cn.mldn.mldnspring.spel;

import java.util.Date;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
 
public class TestSpelClassDemo04 {
	public static void main(String[] args) throws Exception {
		String str = "new java.util.Date()"; 
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);
		EvaluationContext context = new StandardEvaluationContext(exp);
		Date num = exp.getValue(context,Date.class);
		System.out.println(num); 
	} 
}
