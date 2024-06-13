import java.util.Scanner;

/**
 * A Chat class for the ChatterBot exercise.
 * The chat class creates two ChatterBot objects and has them converse.
 *
 * @author Amir Rosengarten
 */
class Chat {
    public static void main(String[] args) {
        ChatterBot[] bots = new ChatterBot[2];
        bots[0] = new ChatterBot("Sammy",
                new String[]{"say " + ChatterBot.PLACEHOLDER_FOR_REQUESTED_PHRASE + "? okay: " +
                        ChatterBot.PLACEHOLDER_FOR_REQUESTED_PHRASE, "You want me to say " +
                        ChatterBot.PLACEHOLDER_FOR_REQUESTED_PHRASE + ", do you? alright: " +
                        ChatterBot.PLACEHOLDER_FOR_REQUESTED_PHRASE},
                new String[]{"what", "say I should say",
                        "whaat " + ChatterBot.PLACEHOLDER_FOR_ILLEGAL_REQUEST + "?"});
        bots[1] = new ChatterBot("Ruthy",
                new String[]{"say " + ChatterBot.PLACEHOLDER_FOR_REQUESTED_PHRASE + "? okay: " +
                        ChatterBot.PLACEHOLDER_FOR_REQUESTED_PHRASE, "Do You want me to say " +
                        ChatterBot.PLACEHOLDER_FOR_REQUESTED_PHRASE + ", do you? alright: " +
                        ChatterBot.PLACEHOLDER_FOR_REQUESTED_PHRASE},
                new String[]{"whaaat", "say say",
                        "what do you mean " + ChatterBot.PLACEHOLDER_FOR_ILLEGAL_REQUEST + "?"});
        String statement = "Hello there.";
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; ; i++) {
            int currentBot = i % bots.length;
            String currentResponse = bots[currentBot].replyTo(statement);
            System.out.print(bots[currentBot].getName() + ": " + currentResponse);
            statement = currentResponse;
            scanner.nextLine();
        }
    }
}