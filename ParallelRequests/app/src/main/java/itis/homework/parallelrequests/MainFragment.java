package itis.homework.parallelrequests;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Artur Vasilov
 */
public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
            TODO : put your code somewhere here
            1) Use RequestsService reference above to process all requests you need
            2) Be sure to user correct order of request:
            2.1) Photos request must be executed only after messages request has finished
            2.2) Friends, posts, messages and group request must be executed only after
                    auth and config requests has finished

            Do not change any code here, except MainFragment class and possible MainActivity.
            Of course you can add as many new classes as you want.

            If you'll execute all requests consequentially it'll take about 47 second - it isn't thing you want.
            Best result you can achieve is 23 seconds. Good luck!

            I've provided simple version with consequential execution in SampleService class.
            I don't force you to use it, it's just a sample.
         */

        //TODO : do not forget to remove it when you implement requests yourself
        SampleService.start(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
