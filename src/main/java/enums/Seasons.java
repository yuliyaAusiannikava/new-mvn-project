package enums;

import java.util.Scanner;

public enum Seasons {
    //0      1      2       3
    SUMMER, AUTUMN, WINTER, SPRING;

    public static Seasons getSeasonByNum(int number){
        switch (number){
            case 1:
                return SUMMER;
            case 2:
                return AUTUMN;
            case 3:
                return WINTER;
            case 4:
                return SPRING;
        }
        return null;
    }

    public static Seasons getSeasonByMonthNum(int number) throws IllegalAccessException {
        switch (number){
            case 12:
            case 1:
            case 2:
                return WINTER;
            case 3:
            case 4:
            case 5:
                return SPRING;
            case 6:
            case 7:
            case 8:
                return SUMMER;
            case 9:
            case 10:
            case 11:
                return AUTUMN;

        }
        throw new IllegalAccessException("Incorrect month number " + number);

    }

}

class SeasonsTester{
//    public static void main(String[] args) throws IllegalAccessException {
//        Seasons s1 = Seasons.WINTER;
//        switch(s1){
//            case WINTER:
//                System.out.println("Finally snow! =]");
//                break;
//            case SUMMER:
//                System.out.println("Best season ever =]");
//                break;
//            default:
//                System.out.println(" =] ");
//        }

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Input month number (from 1 to 12):");
//        int monthNumber = sc.nextInt();
//        //Seasons s2 = Seasons.valueOf(monthNumber);
//        System.out.println(Seasons.valueOf("AUTUMN").ordinal());
//        switch(s2){
//            case WINTER:
//                System.out.println("Finnaly snow! =]");
//                break;
//            case SUMMER:
//                System.out.println("Best season ever =]");
//                break;
//            default:
//                System.out.println(" =] ");
        //Seasons.getSeasonByMonthNum(8);
        }










