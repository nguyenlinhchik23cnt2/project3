package lesson01_lambda_expression;

@FunctionalInterface
interface SayHello1 {
    void sayHello();
}


public class lambdaExpression1 {
    public static void main(String[] args) {
        SayHello1 sayHello1 =()->{
            System.out.println("Xin chào, Admin !");
        };
        sayHello1.sayHello();
    }
}
