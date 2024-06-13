import java.util.*;

/**
 * Base file for the ChatterBot exercise.
 * The bot's replyTo method receives a statement.
 * If it starts with the constant REQUEST_PREFIX, the bot returns
 * whatever is after this prefix. Otherwise, it returns one of
 * a few possible replies as supplied to it via its constructor.
 * In this case, it may also include the statement after
 * the selected reply (coin toss).
 *
 * @author Dan Nirel
 */

class ChatterBot {
    static final String REQUEST_PREFIX = "say ";
    static final String PLACEHOLDER_FOR_REQUESTED_PHRASE = "<phrase>";
    static final String PLACEHOLDER_FOR_ILLEGAL_REQUEST = "<request>";

    Random rand = new Random();

    String[] repliesToIllegalRequest;
    String[] legalRequestsReplies;
    String name;

    /**
     * Constructor for ChatterBot.
     *
     * @param name                    The name of the bot.
     * @param repliesToLegalRequest   An array of possible replies to a legal request.
     * @param repliesToIllegalRequest An array of possible replies to an illegal request.
     */
    ChatterBot(String name, String[] repliesToLegalRequest, String[] repliesToIllegalRequest) {
        this.name = name;
        this.legalRequestsReplies = new String[repliesToLegalRequest.length];
        this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
        for (int i = 0; i < repliesToIllegalRequest.length; i = i + 1) {
            this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
        }
        for (int i = 0; i < repliesToLegalRequest.length; i++) {
            this.legalRequestsReplies[i] = repliesToLegalRequest[i];
        }
    }


    /**
     * Getter for the bot's name.
     *
     * @return The name of the bot.
     */
    String getName() {
        return this.name;
    }


    /**
     * The bot's reply to a statement.
     *
     * @param statement The statement to reply to.
     * @return The bot's reply.
     */
    String replyTo(String statement) {
        if (statement.startsWith(REQUEST_PREFIX)) {
            return replyToLegalRequest(statement);
        }
        return replyToIllegalRequest(statement);
    }


    /**
     * The bot's reply to an illegal request.
     *
     * @param statement The illegal request.
     * @return The bot's reply.
     */
    String replyToIllegalRequest(String statement) {
        String reply = replacePlaceholderInARandomPattern(repliesToIllegalRequest,
                PLACEHOLDER_FOR_ILLEGAL_REQUEST, statement);
        return reply;
    }


    /**
     * The bot's reply to a legal request.
     *
     * @param statement The legal request.
     * @return The bot's reply.
     */
    String replyToLegalRequest(String statement) {
        String phrase = statement.replaceFirst(REQUEST_PREFIX, "");
        String reply = replacePlaceholderInARandomPattern(legalRequestsReplies,
                PLACEHOLDER_FOR_REQUESTED_PHRASE, phrase);
        return reply;
    }


    /**
     * Replaces a placeholder in a random pattern.
     *
     * @param pattern     The pattern to replace the placeholder in.
     * @param placeholder The placeholder to replace.
     * @param replacement The replacement for the placeholder.
     * @return The pattern with the placeholder replaced.
     */
    String replacePlaceholderInARandomPattern(String[] pattern, String placeholder, String replacement) {
        int randomIndex = rand.nextInt(pattern.length);
        String selectedPattern = pattern[randomIndex];
        return selectedPattern.replaceAll(placeholder, replacement);
    }
}