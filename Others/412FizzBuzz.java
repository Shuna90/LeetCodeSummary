412. Fizz Buzz
/*Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
*/
	public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<String>();
        for (int i = 1; i <= n; i++){
            if (i % 3 == 0 && i % 5 == 0){
                res.add("FizzBuzz");
            }else if (i % 3 == 0){
                res.add("Fizz");
            }else if (i % 5 == 0){
                res.add("Buzz");
            }else{
                res.add(i + "");
            }
        }
        return res;
    }

//no % :

public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<String>();
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++){
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5){
                res.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            }else if (fizz == 3){
                fizz = 0;
                res.add("Fizz");
            }else if (buzz == 5){
                buzz = 0;
                res.add("Buzz");
            }else{
                res.add(String.valueOf(i));
            }
        }
        return res;
    }