import java.util.ArrayList;

public class MyOwnTesting {

	public static void main(String[] args) {
		
		Calculator wow = new Calculator();
		
		ArrayList<String> mine = new ArrayList<String>();
		
		mine.add("(");
		mine.add("2");
		mine.add("^");
		mine.add("3");
		mine.add("*");
		mine.add("(");
		mine.add("1");
		mine.add("+");
		mine.add("1");
		mine.add(")");
		mine.add("/");
		mine.add("2");
		mine.add(")");
		mine.add("^");
		mine.add("2");
		mine.add("<");
		mine.add("(");
		mine.add("10");
		mine.add("^");
		mine.add("2");
		mine.add(")");
		//64 < 100 should come out as 1.0 since this is a valid statement
		
		ArrayList<String> postFunc = wow.conversionInfixToPostfix(mine);
		wow.printPostfix(postFunc);
		System.out.println("Your value is: "+wow.postfixEval(postFunc));
	
		
		
	}

}
