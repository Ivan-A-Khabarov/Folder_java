package Lesson_09.Ex000;

public class Program {
    public static void main(String[] args){
        Foo foo1 = new Foo() {
            @Override
            public void m1() {
                System.out.println("m1");

            }

            @Override
            public void m2() {
                System.out.println("m2");

            }
        };

        foo1.m1();
    }

}
