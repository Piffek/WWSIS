
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ArrayStack stack = new ArrayStack(5);
//        stack.push(4);
//        stack.push(2);
//
//        stack.pop();
//        System.out.println(stack.size());
//        System.out.println(stack.isEmpty());

        ListStack lists = new ListStack();
        lists.push(1);
        lists.push(2);
        lists.push(3);
        lists.push(4);
        lists.push(5);
        lists.push(6);


        lists.print();
        System.out.println("size " + lists.size());

        System.out.println("-----");

        lists.pop();
        lists.pop();
        lists.pop();
        System.out.println("size " + lists.size());
        lists.print();
    }
}