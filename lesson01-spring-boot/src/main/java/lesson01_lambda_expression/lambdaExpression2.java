package lesson01_lambda_expression;

@FunctionalInterface
interface SayHello2 {
    void sayHello(String name);
}

public class lambdaExpression2 {
    public static void main(String[] args) {
        // Lambda sử dụng 1 tham số
        SayHello2 say1 = (name) ->{
            System.out.println("Hello " + name);
        };
        say1.sayHello("Admin");

        // Ngắn gọn
        SayHello2 say2 = name ->{
            System.out.println("Hello " + name);
        };
        say2.sayHello("Admin");

        // Ngắn gọn hơn
        SayHello2 say3 = name -> System.out.println("Hello " + name);
        say3.sayHello("Admin");
    }
}
