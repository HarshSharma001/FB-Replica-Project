package Data_Processing_Units;
import java.util.*;

public class VerificationCodeGenerator 
{

	private int leftLimit = 97; // to indicate letter 'a'
	private int rightLimit = 122; // to indicate letter 'z'
	private int targetStringLength = 6;
	
	Random random = new Random(); //Random class and it's instance// 
	
	String generatedString = null;
	private int number;
	
	public void generateVerificationCode() 
	{
	
	number = 1 + random.nextInt(1000);

generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()
				.concat("" + number);

		System.out.println(generatedString);
	}
}
