package interfaces;


import java.util.Arrays;

import static interfaces.Integral.integrate;

/**
 * Created by delonj on 23/07/2019.
 */

public class Main {

    public static void main(String[] args) throws java.lang.Exception {
        //System.out.println(integrate(x -> 1, 0, 10));//10.0
        //System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        //System.out.println(integrate(x -> Math.sin(x) / x, 1, 5));//0.603848


//        byte[] example = {72, 101, 108, 108, 111, 33};
//        AsciiCharSequence answer = new AsciiCharSequence(example);
//        System.out.println("Последовательность - " + answer.toString());//Hello!
//        System.out.println("Размер её - " + answer.length());//6
//        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
//        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
////проверка на нарушение инкапсуляции private поля
//        System.out.println(answer.toString());//Hello!
//        example[0] = 74;
//        System.out.println(answer.toString());//Hello!

        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    /**
     * null
     * myClass#main
     * myClass#m1
     * myClass#m2
     */
    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());


    }


    /**
     * Реализуйте метод sqrt(), вычисляющий квадратный корень числа. В отличие от Math.sqrt(), это метод при передаче отрицательного параметра должен бросать исключение java.lang.IllegalArgumentException с сообщением "Expected non-negative number, got ?", где вместо вопросика будет подставлено фактически переданное в метод число.
     *
     * @param x
     * @return
     */
    public static double sqrt(double x) {
        if (x < 0)
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        return Math.sqrt(x);
    }

    /**
     * Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
     * <p>
     * Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.
     * <p>
     * Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод, откуда сообщение было залогировано.
     */


    public static String getCallerClassAndMethodName() {
        StackTraceElement[] elements = new Throwable().getStackTrace();
        if (elements.length < 3)
            return null;
        else
            return elements[2].getClassName() + "#" + elements[2].getMethodName();


//        try {
//            throw new Exception();
//        } catch (Exception t) {
//            if (t.getStackTrace().length < 3) {
//                return null;
//            } else {
//                return t.getStackTrace()[1].getClassName() + "#" + t.getStackTrace()[1].getMethodName();
//            }
//        }

    }
}
