241. Different Ways to Add Parentheses

/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]


*/

public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '-' || input.charAt(i) == '+' || input.charAt(i) == '*'){
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> list1 = diffWaysToCompute(part1);
                List<Integer> list2 = diffWaysToCompute(part2);
                for (int i1 : list1){
                    for (int i2 : list2){
                        int num = 0;
                        switch (input.charAt(i)){
                            case '-':
                                num = i1 - i2;
                                break;
                            case '+':
                                num = i1 + i2;
                                break;
                            case '*':
                                num = i1 * i2;
                                break;
                        }
                        list.add(num);
                    }
                }
            }
        }
        if (list.size() == 0){
            list.add(Integer.valueOf(input));
        }
        return list;
    }