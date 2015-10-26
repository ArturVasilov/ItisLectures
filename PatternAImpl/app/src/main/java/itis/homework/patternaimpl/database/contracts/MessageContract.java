package itis.homework.patternaimpl.database.contracts;

import itis.homework.patternaimpl.content.Message;

/**
 * @author Artur Vasilov
 */
public class MessageContract {

    public interface Columns {
        String MESSAGE = "message";
    }

    public interface DatabaseRequests {

        String TABLE_NAME = Message.class.getSimpleName();

        String CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                Columns.MESSAGE + " VARCHAR(255)" + ");";

        String DROP = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

}
