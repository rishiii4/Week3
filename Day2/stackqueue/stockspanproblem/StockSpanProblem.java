package stackqueue.stockspanproblem;

import java.util.Stack;

public class StockSpanProblem {

    public static void stocksSpan(int stocks[], int span[]){
        //Initializing stack
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        //Loop through stocks array to calculate span
        for (int i=1;i<stocks.length;i++){
            //Storing current price of stocks
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }

    }

    public static void main(String[] args) {
        //Creating array of stocks price
        int stocks[] = {100,80,60,70,60,85,100};
        //Creating span array to store the result
        int span[] = new int[stocks.length];
        stocksSpan(stocks,span);

        //Printing array
        for (int i=0;i< span.length;i++){
            System.out.print(span[i]+ " ");
        }
    }
}
