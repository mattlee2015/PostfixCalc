import java.util.ArrayList;

public class Calculator{
	
	
	private StacksHw<String> stackMeth = new StacksHw<String>();
	private ArrayList<String> postfix;
	private double newVal;
	private String nv;
	
	public Calculator(){
		
	}
	
	
	private boolean operator(String c){
		
		if(c=="+"){
			return c == "+";
			
		}else if(c=="-"){
			return c=="-";
			
		}else if (c=="*"){
			return c=="*";
			
		}else if(c=="/"){
			return c=="/";
			
		}else if(c=="^"){
			return c=="^";
			
		}else if(c=="("){
			return c=="(";
			
		}else if(c==")"){
			return c==")";
		
			
			
		}else if(c=="<"){
			return c=="<";
		}else if(c==">"){
			return c==">";
		}else if(c=="&"){
			return c=="&";
		}else if(c=="|"){
			return c=="|";
		}else if(c=="!"){
			return c=="!";
		}else if(c=="="){
			return c=="=";
		}
			
		
		
		return false;
		
	}

	
	private int precedence(String op){
		 
		
		if(op=="!" ){
			 return 8;
		
		 }else if(op =="^"){
			 
			 return 5;
		 
		 }else if(op =="*" || op == "/"){
			 
			 return 4;
		 }else if(op =="+" || op == "-"){
			 
			 return 3;
			 
		 }else if(op=="="){
			 return 1;
			 
		 }else if(op=="<" || op==">"){
			 
			 return 2;
		 }else if(op=="&"){
			 
			 return 1;
		 }else if(op=="|"){
			 
			 return 0;
		 }
		
		 
		 return -1;
	 }
	
	
	
	public ArrayList<String> conversionInfixToPostfix(ArrayList<String> infix){
		
		String s;
		postfix = new ArrayList<String>(infix.size());
		
		
		for(int i=0; i<infix.size();i++){
			
			s = infix.get(i);
		
			
			//if you aren't an operator I want you to go into the postfix arraylist
			if(!operator(s)){
				
				
				postfix.add(s);
				
				
			}else{
				
			
				
				if(s==")"){
					
					
					
					//while the stack isnt empty and the peek doesnt have (, because we dont want to enqueue (
					while(!stackMeth.stackIsEmpty() && stackMeth.peek() !="("){
						//enqueue the operators
						postfix.add((stackMeth.pop()));
						
					}
					
					//get rid of the open parenthesis from the stack
					stackMeth.pop();
					
					
					//there is nothing in the stack and we are adding our first operator
				}else if(stackMeth.stackIsEmpty()){
				
					stackMeth.push(s);
					
					
					
				}else{
					
					
					
					//if the current operator is of lower precedence than the "peeked" one then we enqueue in the stack
					//then we insert the current operator into the stack
					
					if(!stackMeth.stackIsEmpty() && !(precedence(s)<precedence(stackMeth.peek()))){
						
						
						stackMeth.push(s);
						
						
					//if the operator is of higher precedence or equal to the peek of the stack then just insert the operator into stack 	
					}else{
						
						while(!stackMeth.stackIsEmpty() && precedence(s)<precedence(stackMeth.peek())){
							
							
							
							if(s!="("){
								postfix.add(stackMeth.pop());
							}
							
							
							stackMeth.push(s);
							
						}
						
						
						
					}
					
				}
				
				
			}
	
			
		}//end of for loop 
		
		
			//once it has gone through the whole array and the stack is not empty
			//it will enqueue the remaining operators in the stack
		while(!stackMeth.stackIsEmpty()){
			
				postfix.add((stackMeth.pop()));
		}
		
		
		
		return postfix;
		
		
	}//end of infix to postfix method
	 

	
	public void printPostfix(ArrayList<String> x){
		
		System.out.print("Our postfix expression looks like: ");
		for(int i=0; i<x.size();i++){
			
			System.out.print(x.get(i)+" ");
		}
		
		System.out.println();
		
	}
	
	
	
	public String postfixEval(ArrayList<String> x){
		
		String s;
		
		
		for(int i=0; i<x.size();i++){
			
			s= x.get(i);
			
			
			//if a number then push into stack
			if(!operator(s)){
				
				stackMeth.push(s);
			
				
				//when its an operator 
			}else{
				
				if(s!="!"){

					String first;
					String sec;
					first = stackMeth.pop();
					sec = stackMeth.pop();
				
					double firstVal;
					double secVal;
					
					
					firstVal = Double.parseDouble(first);
					secVal = Double.parseDouble(sec);
				
					
					
					
					
					
					if(s=="+"){
						newVal = secVal+firstVal;
					}else if(s=="-"){
						newVal = secVal-firstVal;
					}else if(s=="*"){
						newVal = secVal*firstVal;
					}else if(s =="/"){
						newVal = secVal/firstVal;
					}else if(s=="^"){
						newVal = Math.pow(secVal, firstVal);
					
					
					}else if(s=="<"){
						if(secVal<firstVal){
							newVal = 1;
						}else{
							newVal=0;
						}
					}else if(s==">"){
						if(secVal>firstVal){
							newVal = 1;
						}else{
							newVal = 0;
						}
						
					//this part doesn't work for me	
					}else if(s==("=")){
						
						if(secVal==firstVal){
						
							newVal = 1;
						}else{
							
							newVal = 0;
						}
					}else if(s=="&"){
						if(secVal==1&&firstVal==1){
							newVal = 1;
						}else{
							newVal = 0;
						}
					}else if(s=="|"){
						if(secVal==1||firstVal==1){
							newVal=1;
						}else{
							newVal=0;
						}
						
						
					}	
						
			}else{//in the case the operator is !
					
				String bottom;
				bottom = stackMeth.pop();
				double botVal;
				
				botVal = Double.parseDouble(bottom);
				
				if(botVal==0){
					
					newVal=1;
				}else{
					
					newVal=0;
				}
				
			}
			
			
					
					
					
		
				
				
					nv = Double.toString(newVal);
				
					stackMeth.push(nv);
				
			}//end of huge else method for when operator
			
			
		}//end of for loop
		
		
		return nv;
		
	}
	
	
	
	
	
	public static void main(String[] args){
		
		Calculator test = new Calculator();
		
		ArrayList<String> func1 = new ArrayList<String>();
		func1.add("1");
		func1.add("+");
		func1.add("1");
		
		ArrayList<String> func2 = new ArrayList<String>();
		func2.add("5.2");
		func2.add("+");
		func2.add("1");
		
		ArrayList<String> func3 = new ArrayList<String>();
		func3.add("5.2");
		func3.add("+");
		func3.add("1.0");
		
		ArrayList<String> func4 = new ArrayList<String>();
		func4.add("1");
		func4.add("-");
		func4.add("1");
		
		
		ArrayList<String> func5 = new ArrayList<String>();
		func5.add("5.2");
		func5.add("-");
		func5.add("1");
		
		ArrayList<String> func6 = new ArrayList<String>();
		func6.add("1.0");
		func6.add("-");
		func6.add("5.2");
		
		ArrayList<String> func7 = new ArrayList<String>();
		func7.add("3.0");
		func7.add("*");
		func7.add("4");
		
		ArrayList<String> func8 = new ArrayList<String>();
		func8.add("4");
		func8.add("/");
		func8.add("0.25");
		
		ArrayList<String> func9 = new ArrayList<String>();
		func9.add("1");
		func9.add("-");
		func9.add("(");
		func9.add("4");
		func9.add("+");
		func9.add("5");
		func9.add(")");
		
		ArrayList<String> func10 = new ArrayList<String>();
		func10.add("1");
		func10.add("-");
		func10.add("(");
		func10.add("1");
		func10.add("-");
		func10.add("(");
		func10.add("4");
		func10.add("+");
		func10.add("5");
		func10.add(")");
		func10.add(")");
		
		ArrayList<String> func11 = new ArrayList<String>();
		func11.add("0");
		func11.add("<");
		func11.add("55");
		
		ArrayList<String> func12 = new ArrayList<String>();
		func12.add("3.2");
		func12.add("<");
		func12.add("2.3");
		
		
		ArrayList<String> func13 = new ArrayList<String>();
		func13.add("0");
		func13.add(">");
		func13.add("55");
		
		
		ArrayList<String> func14 = new ArrayList<String>();
		func14.add("3.2");
		func14.add(">");
		func14.add("2.3");
		
		ArrayList<String> func15 = new ArrayList<String>();
		func15.add("5");
		func15.add("=");
		func15.add("5.0");
		
		ArrayList<String> func16 = new ArrayList<String>();
		func16.add("1");
		func16.add("=");
		func16.add("1");
		
		
		ArrayList<String> func17 = new ArrayList<String>();
		func17.add("1");
		func17.add("=");
		func17.add("0");
		
		ArrayList<String> func18 = new ArrayList<String>();
		func18.add("1");
		func18.add("&");
		func18.add("1");
		
		
		ArrayList<String> func19 = new ArrayList<String>();
		func19.add("1");
		func19.add("&");
		func19.add("0");
		
		ArrayList<String> func20 = new ArrayList<String>();
		func20.add("1");
		func20.add("|");
		func20.add("0");
		
		ArrayList<String> func21 = new ArrayList<String>();
		func21.add("0");
		func21.add("|");
		func21.add("0");
		
		ArrayList<String> func22 = new ArrayList<String>();
		func22.add("!");
		func22.add("0");
		
		ArrayList<String> func23 = new ArrayList<String>();
		func23.add("!");
		func23.add("1");
		
		ArrayList<String> func24 = new ArrayList<String>();
		func24.add("!");
		func24.add("(");
		func24.add("3");
		func24.add("*");
		func24.add("(");
		func24.add("1");
		func24.add("+");
		func24.add("6");
		func24.add(")");
		func24.add("=");
		func24.add("63");
		func24.add("/");
		func24.add("3");
		func24.add(")");
		
		
		ArrayList<String> func25 = new ArrayList<String>();
		func25.add("(");
		func25.add("1");
		func25.add("<");
		func25.add("3");
		func25.add(")");
		func25.add("&");
		func25.add("(");
		func25.add("2");
		func25.add(">");
		func25.add("4");
		func25.add(")");
		func25.add("|");
		func25.add("1");
	
		
		
		
		
		ArrayList<String> postFunc1 = test.conversionInfixToPostfix(func1);
		test.printPostfix(postFunc1);
		System.out.println("Your value is: "+test.postfixEval(postFunc1));
		System.out.println();
		
		ArrayList<String> postFunc2 = test.conversionInfixToPostfix(func2);
		test.printPostfix(postFunc2);
		System.out.println("Your value is: "+test.postfixEval(postFunc2));
		System.out.println();
		
		ArrayList<String> postFunc3 = test.conversionInfixToPostfix(func3);
		test.printPostfix(postFunc3);
		System.out.println("Your value is: "+test.postfixEval(postFunc3));
		System.out.println();
		
		
		ArrayList<String> postFunc4 = test.conversionInfixToPostfix(func4);
		test.printPostfix(postFunc4);
		System.out.println("Your value is: "+test.postfixEval(postFunc4));
		System.out.println();
		
		ArrayList<String> postFunc5 = test.conversionInfixToPostfix(func5);
		test.printPostfix(postFunc5);
		System.out.println("Your value is: "+test.postfixEval(postFunc5));
		System.out.println();
		
		ArrayList<String> postFunc6 = test.conversionInfixToPostfix(func6);
		test.printPostfix(postFunc6);
		System.out.println("Your value is: "+test.postfixEval(postFunc6));
		System.out.println();
		
		
		ArrayList<String> postFunc7 = test.conversionInfixToPostfix(func7);
		test.printPostfix(postFunc7);
		System.out.println("Your value is: "+test.postfixEval(postFunc7));
		System.out.println();
		
		ArrayList<String> postFunc8 = test.conversionInfixToPostfix(func8);
		test.printPostfix(postFunc8);
		System.out.println("Your value is: "+test.postfixEval(postFunc8));
		System.out.println();
		
		ArrayList<String> postFunc9 = test.conversionInfixToPostfix(func9);
		test.printPostfix(postFunc9);
		System.out.println("Your value is: "+test.postfixEval(postFunc9));
		System.out.println();
		
		
		ArrayList<String> postFunc10 = test.conversionInfixToPostfix(func10);
		test.printPostfix(postFunc10);
		System.out.println("Your value is: "+test.postfixEval(postFunc10));
		System.out.println();
		
		ArrayList<String> postFunc11 = test.conversionInfixToPostfix(func11);
		test.printPostfix(postFunc11);
		System.out.println("Your value is: "+test.postfixEval(postFunc11));
		System.out.println();
		
		
		ArrayList<String> postFunc12 = test.conversionInfixToPostfix(func12);
		test.printPostfix(postFunc12);
		System.out.println("Your value is: "+test.postfixEval(postFunc12));
		System.out.println();
		
		ArrayList<String> postFunc13 = test.conversionInfixToPostfix(func13);
		test.printPostfix(postFunc13);
		System.out.println("Your value is: "+test.postfixEval(postFunc13));
		System.out.println();
		
		ArrayList<String> postFunc14 = test.conversionInfixToPostfix(func14);
		test.printPostfix(postFunc14);
		System.out.println("Your value is: "+test.postfixEval(postFunc14));
		System.out.println();
		
		ArrayList<String> postFunc15 = test.conversionInfixToPostfix(func15);
		test.printPostfix(postFunc15);
		System.out.println("Your value is: "+test.postfixEval(postFunc15));
		System.out.println();
		
		
		ArrayList<String> postFunc16 = test.conversionInfixToPostfix(func16);
		test.printPostfix(postFunc16);
		System.out.println("Your value is: "+test.postfixEval(postFunc16));
		System.out.println();
		
		ArrayList<String> postFunc17 = test.conversionInfixToPostfix(func17);
		test.printPostfix(postFunc17);
		System.out.println("Your value is: "+test.postfixEval(postFunc17));
		System.out.println();
		
		ArrayList<String> postFunc18 = test.conversionInfixToPostfix(func18);
		test.printPostfix(postFunc18);
		System.out.println("Your value is: "+test.postfixEval(postFunc18));
		System.out.println();
		
		ArrayList<String> postFunc19 = test.conversionInfixToPostfix(func19);
		test.printPostfix(postFunc19);
		System.out.println("Your value is: "+test.postfixEval(postFunc19));
		System.out.println();
		
		ArrayList<String> postFunc20 = test.conversionInfixToPostfix(func20);
		test.printPostfix(postFunc20);
		System.out.println("Your value is: "+test.postfixEval(postFunc20));
		System.out.println();
		
		ArrayList<String> postFunc21 = test.conversionInfixToPostfix(func21);
		test.printPostfix(postFunc21);
		System.out.println("Your value is: "+test.postfixEval(postFunc21));
		System.out.println();
		
		
		ArrayList<String> postFunc22 = test.conversionInfixToPostfix(func22);
		test.printPostfix(postFunc22);
		System.out.println("Your value is: "+test.postfixEval(postFunc22));
		System.out.println();
		
		
		ArrayList<String> postFunc23 = test.conversionInfixToPostfix(func23);
		test.printPostfix(postFunc23);
		System.out.println("Your value is: "+test.postfixEval(postFunc23));
		System.out.println();
		
		ArrayList<String> postFunc24 = test.conversionInfixToPostfix(func24);
		test.printPostfix(postFunc24);
		System.out.println("Your value is: "+test.postfixEval(postFunc24));
		System.out.println();
		
		ArrayList<String> postFunc25 = test.conversionInfixToPostfix(func25);
		test.printPostfix(postFunc25);
		System.out.println("Your value is: "+test.postfixEval(postFunc25));
		System.out.println();
		
	}
	
}
