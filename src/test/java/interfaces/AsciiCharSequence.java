package interfaces;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by delonj on 23/07/2019.
 */

/**
 * Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.
 * <p>
 * Класс AsciiCharSequence должен:
 * <p>
 * реализовывать интерфейс java.lang.CharSequence;
 * иметь конструктор, принимающий массив байт;
 * определять методы length(), charAt(), subSequence() и toString()
 * Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
 * <p>
 * В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
 * <p>
 * P.S. В Java 9 ожидается подобная оптимизация в самом классе String: http://openjdk.java.net/jeps/254
 */
public class AsciiCharSequence implements CharSequence {
    private byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes)
            sb.append((char) b);
        return sb.toString();
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(bytes, start, end));

//        byte[] temp = new byte[end-start];
//            for(int k = 0; k<temp.length;) {
//                for (int i = start; i <end; i++) {
//                    temp[k] = bytes[i];
//                    k++;
//                }
//        }
//        return new AsciiCharSequence(temp);
    }
}
