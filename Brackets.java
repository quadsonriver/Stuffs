import java.util.Scanner;
import java.util.Stack;

public class Brackets {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		String line;
		String pushBrackets = "[({";
		
		
		
		for(int y = 0; y<test; y++)
		{
			line = in.next();
			String answer = null;
			
			Stack<Character> s = new Stack<Character>();
			
			for(char bracket : line.toCharArray())
			{
				if(pushBrackets.indexOf(bracket) >= 0)
					s.push(bracket);
				
				else if(bracket == ']' && (s.isEmpty() || s.pop() != '['))
				{
					answer = "NO";
					break;
				}
				else if(bracket == ')' && (s.isEmpty() || s.pop() != '('))
				{
					answer = "NO";
					break;
				}
				else if(bracket == '}' && (s.isEmpty() || s.pop() != '{'))
				{
					answer = "NO";
					break;
				}
			}
			if(s.isEmpty() && answer == null)
				answer = "YES";
			else
				answer = "NO";
			
			System.out.println(answer);
		}
	}

}
