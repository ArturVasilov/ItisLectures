package itis.homework.parallelrequests.network;

/**
 * @author Artur Vasilov
 */
public interface RequestsService {

    void config();

    void auth();

    void friends();

    void posts();

    void groups();

    void messages();

    void photos();

    void reset();

}
