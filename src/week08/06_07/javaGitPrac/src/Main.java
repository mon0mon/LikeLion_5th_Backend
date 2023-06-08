public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage: add, commit");
        } else if (args[0].equals("add")) {
            System.out.println("add changes to git:");
            for (int i = 1; i < args.length; i++) {
                System.out.println(args[i]);
            }
        } else if (args[0].equals("commit")) {
            if (args[1].equals("-m")) {
                for (int i = 2; i < args.length; i++) {
                    System.out.printf("%s ", args[i]);
                }
            } else {
                System.out.println("no message specified");
            }
        }
    }
}