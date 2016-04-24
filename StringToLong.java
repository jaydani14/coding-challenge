/**
 * Question 1) ​Given a string, write a routine (in Java) that converts the string to a long, without using the built
 * in functions that would do this. Describe what (if any) limitations the code has. For example:
 * 
 * @param s input string that needs to be converted to long value
 * @return long value of the input string
 * @throws IllegalArgumentException
 */
long stringToLong(String s) throws IllegalArgumentException
{
    if (s == null || s.isEmpty())
    {
        throw new IllegalArgumentException("Conversion failed: Input string cannot be null or empty");
    }

    // Trim spaces from the front
    while(s.charAt(0) == ' ')
    {
        s = s.substring(1);
    }

    long result = 0;
    boolean isNegative = false;
    if (s.charAt(0) == '-')
    {
        isNegative = true;
        s = s.substring(1);
    }

    for (int i = 0; i < s.length(); i++)
    {
        int currentValue = s.charAt(i) - '0';     // '0' is the offset for all the other integer ascii values.
        if(currentValue >= 0 && currentValue <= 9)
        {
            result = 10 * result + currentValue;    
        }
        else if (s.charAt(i) == ' ')
        {
            // Trim spaces from the rear
            for (int j = s.charAt(i); j < s.length(); j++)
            {
                // Throw exception if there are spaces in between numbers
                if (s.charAt(j) != ' ')
                {
                    throw new IllegalArgumentException("Conversion failed. Invalid input string: " + s);  
                }
            }
        }
        else
        {
            throw new IllegalArgumentException("Conversion failed. Invalid input string: " + s);  
        }
    }

    return isNegative ? (-1 * result) : result;
}

void test()
{
    long i = stringToLong("123");         //success
    long j = stringToLong("-123");        //success
    long k = stringToLong("   123");      //success
    long l = stringToLong("123   ");      //success
    long m = stringToLong("   123   ");   //success
    long n = stringToLong(null);          //failure  Conversion failed: Input string cannot be null or empty
    long o = stringToLong("");            //failure  Conversion failed: Input string cannot be null or empty
    long p = stringToLong("a123");        //failure  Conversion failed. Invalid input string: a123
    long q = stringToLong("1 2 3");       //failure  Conversion failed. Invalid input string: 1 2 3
    long r = stringToLong("1.2.3");       //failure  Conversion failed. Invalid input string: 1.2.3

    // The decimal functionality is not supported by this program. Ideally, the below test should have been a success.
    long s = stringToLong("12.3");      //failure  Conversion failed: Invalid input string: 100.5
}