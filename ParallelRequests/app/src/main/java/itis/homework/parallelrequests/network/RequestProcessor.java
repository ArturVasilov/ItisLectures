package itis.homework.parallelrequests.network;

import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import android.os.SystemClock;

/**
 * @author Artur Vasilov
 */
public class RequestProcessor implements RequestsService {

    private final RequestsController mRequestsController;

    public RequestProcessor(RequestsController requestsController) {
        mRequestsController = requestsController;
    }

    @Override
    public void config() {
        process(RequestType.CONFIG);
    }

    @Override
    public void auth() {
        process(RequestType.AUTH);
    }

    @Override
    public void friends() {
        process(RequestType.FRIENDS);
    }

    @Override
    public void posts() {
        process(RequestType.POSTS);
    }

    @Override
    public void groups() {
        process(RequestType.GROUPS);
    }

    @Override
    public void messages() {
        process(RequestType.MESSAGES);
    }

    @Override
    public void photos() {
        process(RequestType.PHOTOS);
    }

    @Override
    public void reset() {
        mRequestsController.reset();
    }

    private void process(RequestType requestType) {
        if (mRequestsController.tryRequest(requestType)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new NetworkOnMainThreadException();
            }
            SystemClock.sleep(requestType.getDelay());
            mRequestsController.onRequestFinished(requestType);
        }
    }
}
