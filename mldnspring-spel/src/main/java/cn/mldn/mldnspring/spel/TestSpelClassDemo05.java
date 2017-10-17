package cn.mldn.mldnspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
 
public class TestSpelClassDemo05 {
	public static void main(String[] args) throws Exception {
		String str = "'hello' instanceof T(String)"; 
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);
		EvaluationContext context = new StandardEvaluationContext(exp);
		System.out.println(exp.getValue(context)); 
	} 
}
