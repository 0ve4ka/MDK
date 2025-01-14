public class Main {
    private static boolean isCapsLock = false;
    public static void main(String[] args) {
    print("WeLcOmE N...a");
    capsLock();
    print("WeLcOmE N...a");
    capsLock();
    print("WeLcOmE N...a");
    }
    public static void capsLock() {
        // Здесь нужно изменить значение флага isCapsLock на противоположное
        isCapsLock  = !isCapsLock;
    }

    public static void print(String str) {
        // а здесь нужно распечатать строку или в верхнем регистре, или без изменений, учитывая флаг
        if(isCapsLock)
            System.out.println(str.toUpperCase());
        else
            System.out.println(str);
    }
}