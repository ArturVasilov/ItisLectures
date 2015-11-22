package ru.samples.itis.rxpractice.tasks;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;

/**
 * @author Artur Vasilov
 */
public class RxJavaTask1 {

    /**
     * TODO : implement this method
     *
     * This method takes list of strings and creates an observable of integers,
     * that represents length of strings which contains letter 'r' (or 'R')
     *
     * @param list - list of string
     * @return integer observable with strings length
     */
    @NonNull
    public static Observable<Integer> task1Observable(@NonNull List<String> list) {
        throw new RuntimeException("Observable not implemented exception");
    }

}


