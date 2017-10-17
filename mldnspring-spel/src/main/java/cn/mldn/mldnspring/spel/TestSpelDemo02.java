package cn.mldn.mldnspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelDemo02 {
	public static void main(String[] args) {
		String str = "(\"Hello \" + \"World\").substring(6, 9)" ;	// 将之前的语句都定义在了字符串里面
		ExpressionParser parser = new SpelExpressionParser() ;	// 定义一个SpEL的语法解析器
		Expression exp = parser.parseExpression(str) ;	// 将字符串解析为一个正常的表达式对象
		EvaluationContext context = new StandardEvaluationContext(exp) ;	// 实现表达式的具体计算处理
		Object value = exp.getValue(context) ;
		System.out.println(value); 
	}
}
