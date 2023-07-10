package errors;

import model.Person;

public class ExceptionTester {
    public static void main(String[] args) {
        System.out.println("Begin.");
        Person p1 = new Person();

        Throwable throwable;
        Error error;
        Exception exception;

        try {
            // потенциально небезопасный код. пытаемся отловить закэтчить экспшн,
            // который ожидает в блоке кэтч
            p1.clone(); //will throw new NullPointerException object;
        } catch (NullPointerException e) {//в этом блоке ожидается объект конкретного типа (тип исключения)
            //обрваботка в случае, когда поймано это исключение
            System.out.println("Ooops! It's NullPointerException ( : " + e.getMessage());
            e.printStackTrace();
        } finally {
            //блок выполнится в любом случае (с ошибкой или без)
            System.out.println("final job");
        }

        int[] array = {2, 12, 33};
        int i = 10;

        try {
            int val = array[i];
            System.out.println(val);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong index : " + i);
            e.printStackTrace();
            System.out.println("Please use next indexes bounds -> from 0 to " + (array.length - 1));

        } finally {
            //default implementation -> print first element
            System.out.println(array[0]);
        }


        String str = "Hello Java world!";
        String[] words = str.split(" ");
        for (String word : words) {
            try {
                System.out.println(word.charAt(word.indexOf('o')));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Not symbol 'o' in this word " + word);
            }
        }


        System.out.println("End.");
    }
}
