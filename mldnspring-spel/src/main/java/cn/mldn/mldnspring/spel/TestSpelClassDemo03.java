package cn.mldn.mldnspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
 
public class TestSpelClassDemo03 {
	public static void main(String[] args) throws Exception {
		String str = "T(Integer).parseInt('12a3')"; 
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);
		EvaluationContext context = new StandardEvaluationContext(exp);
		Integer num = exp.getValue(context,Integer.class);
		System.out.println(num);
	} 
}
