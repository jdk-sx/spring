package cn.mldn.mldnspring.spel;

import java.util.HashSet;
import java.util.Set;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelCollectionDemo04 {
	public static void main(String[] args) throws Exception {
		Set<String> all = new HashSet<String>() ;
		all.add("hello") ;
		all.add("world") ; 
		all.add("mldn") ;
		String str = "#allData[1]";	// 表示集合中的数据
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);	// 设置了一个自定义的根变量
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("allData", all); // 将自定义的集合设置进来
		System.out.println(exp.getValue(context));
	} 
} 
