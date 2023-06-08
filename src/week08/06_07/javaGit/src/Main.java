public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        for (String arg : args) {
            System.out.println(arg);
        }

        String command = args[0];
        if (command.equals("add")) {
            System.out.println("여기에 add용 코드 작성");
        }
        if (command.equals("commit")) {
            System.out.println("여기에 commit용 코드 작성");
        }
        else {
            System.out.println("invalid command");
        }
    }
}