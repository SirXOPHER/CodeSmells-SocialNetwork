import java.util.Scanner;

public class SmellyApp {

    public static void main (String[] args) {

        Scanner console = new Scanner(System.in);
        Context context = new Context();

        System.out.print("\n" + "Welcome to the big stink!" + "\n");

        boolean active = true;

        do {
            System.out.print(">");
            String currentInput = console.nextLine();
            CommandHandler handler = new CommandHandler(currentInput);
            Command currentCMD = handler.translate(currentInput);

            switch (currentCMD) {
                case CMD_POST:   context.addUser(handler.grabUserName());
                    context.addPosting(handler.grabUserName(), handler.grabMessageText());
                    break;
                case CMD_READ:   context.readPostings(currentInput);
                    break;
                case CMD_FOLLOW: context.follow(handler.grabUserName(), handler.grabFolloweeName());
                    break;
                case CMD_WALL:      context.printWall(handler.grabUserName());
                    break;
                case CMD_EXIT:      active = false;
                    console.close();
                    System.out.print("\n" + "Thank you for having a sniff. See you soon!" + "\n");
                    break;
                default:
                    break;
            }
        } while (active);
    }

}
