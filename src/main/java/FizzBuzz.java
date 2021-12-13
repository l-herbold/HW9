public class FizzBuzz {

    public String convertNumber(int number) {
        String result = "";
        if(number % 5 == 0)
            result += "Fizz";
        if(number % 7 == 0)
            result += "Buzz";
        return result;
    }
}