package cn.mldn.mldnspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelDemo05 {
	public static void main(String[] args) {
		String str = "#[1.1 + 2.2]" ;	// 将之前的语句都定义在了字符串里面
		ExpressionParser parser = new SpelExpressionParser() ;	// 定义一个SpEL的语法解析器
		Expression exp = parser.parseExpression(str,new ParserContext() {
			@Override 
			public boolean isTemplate() {	// 是否使用此分割符处理模版
				return true ;
			}
			@Override
			public String getExpressionPrefix() {	// 设置分隔符的开始字符串
				return "#[";
			}
			@Override
			public String getExpressionSuffix() {	// 设置分割符的结束字符串
				return "]";
			}}) ;	// 将字符串解析为一个正常的表达式对象
		EvaluationContext context = new StandardEvaluationContext(exp) ;// 实现表达式的具体计算处理
		Object value = exp.getValue(context) ;
		System.out.println(value); 
	}
}
