package cn.mldn.mldnspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelCollectionDemo02 {
	public static void main(String[] args) throws Exception {
		String str = "{10,20,30}[1]";	// 表示集合中的数据
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);	// 设置了一个自定义的根变量
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context));
	} 
} 
