package cn.mldn.mldnspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelClassDemo01 {
	public static void main(String[] args) throws Exception {
		String str = "T(java.util.Date)"; 
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);
		EvaluationContext context = new StandardEvaluationContext(exp);
		Class<?> cls = exp.getValue(context,Class.class);
		System.out.println(cls.newInstance());
	} 
}
