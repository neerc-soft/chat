// $Id$
/**
 * Date: 24.10.2004
 */
package ru.ifmo.neerc.chat.message;

import ru.ifmo.ips.config.Config;

/**
 * Represents abstract chat message.
 *
 * @author Matvey Kazakov
 */
public abstract class Message {

    /**
     * Information message from server
     */
    protected static final int SERVER_MESSAGE = 0;
    /**
     * Message contains some task
     */
    protected static final int TASK_MESSAGE = 1;
    /**
     * Message from user
     */
    protected static final int USER_MESSAGE = 2;
    /**
     * Message with login information
     */
    protected static final int LOGIN_MESSAGE = 3;
    /**
     * Response to login information. Contains entry information:
     * Users, assigned tasks etc.
     */
    protected static final int WELCOME_MESSAGE = 4;
    /**
     * Message with NEERC clock
     */
    protected static final int TIMER_MESSAGE = 5;
    /**
     * Message with update to the users list
     */
    protected static final int UPDATE_USERS_LIST_MESSAGE = 6;
    /**
     * Message identifying End Of Stream
     */
    protected static final int EOF_MESSAGE = 1000;
    /**
     * Message used to check connection alive
     */
    protected static final int PING_MESSAGE = 1001;
    
    /**
     * Message used to send custom information
     */
    protected static final int CUSTOM_MESSAGE = 10000;

    /**
     * Stores message type. Either {@link #SERVER_MESSAGE}, {@link #TASK_MESSAGE}, {@link #USER_MESSAGE},
     * {@link #LOGIN_MESSAGE} or {@link #WELCOME_MESSAGE}.
     */
    private int type;
    /**
     * Serialized representation of this message.
     */
    private byte[] serialized = null;

    /**
     * Destination user. -1 -means everyone.
     */
    private int destination = -1;

    /**
     * Constructor cteates message of given type.
     *
     * @param type new message type.
     * @param destination destination of the message.
     */
    protected Message(int type, int destination) {
        this.type = type;
        this.destination = destination;
    }
    /**
     * Constructor cteates message of given type.
     *
     * @param type new message type.
     */
    protected Message(int type) {
        this(type, -1);
    }

    /**
     * Return message type.
     */
    public int getType() {
        return type;
    }

    /**
     * Returns message destination
     * @return user ID
     */
    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    /**
     * Returns serialized form of the message.
     *
     * @param serialized byte array representing this message.
     */
    public void setSerialized(byte[] serialized) {
        this.serialized = serialized;
    }

    public byte[] getSerialized() {
        return serialized;
    }

    protected abstract void serialize(Config message);

    protected abstract void deserialize(Config message);
    
    public abstract String asString();

    public boolean shouldBeSentTo(int id) {
        return destination == -1 || destination == id;
    }
}

