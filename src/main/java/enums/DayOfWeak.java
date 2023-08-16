package enums;

public enum DayOfWeak {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int dayOrder;
    private String code;

    DayOfWeak(int dayOrder, String code){
        this.dayOrder = dayOrder;
        this.code = code;
    }

    DayOfWeak(int dayOrder){
        this.dayOrder = dayOrder;
    }

    public int getDayOrder(){
        return dayOrder;
    }

    public String shortName(int dayOrder){
        switch (dayOrder){
            case 1:
                System.out.println("MN");
            case 2:
                System.out.println("TU");
            case 3:
                System.out.println("WD");
            case 4:
                System.out.println("TH");
            case 5:
                System.out.println("FR");
            case 6:
                System.out.println("ST");
            case 7:
                System.out.println("SD");
            default:
                System.out.println("You input incorrect day number");
        }
        return " ";


    }

}
