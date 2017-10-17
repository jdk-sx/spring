package cn.mldn.mldnspring.spel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelCollectionDemo07 {
	public static void main(String[] args) throws Exception {
		Map<String,String> all = new HashMap<String,String>() ;
		all.put("mldn", "www.mldn.cn") ;
		all.put("mldnjava", "www.mldnjava.cn") ;
		String str = "#allData['mldn']='欢迎访问mldn'";	// 表示集合中的数据
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);	// 设置了一个自定义的根变量
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("allData", all); // 将自定义的集合设置进来
		System.out.println(exp.getValue(context));
	} 
} 
