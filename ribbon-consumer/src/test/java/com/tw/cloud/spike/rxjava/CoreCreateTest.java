package com.tw.cloud.spike.rxjava;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

public class CoreCreateTest {
    @Test
    public void create_core() throws Exception {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("exec");
                subscriber.onNext("first");
                System.out.println("exec1");
                subscriber.onNext("second");
                System.out.println("exec2");
                subscriber.onCompleted();
            }
        });
        System.out.println("----");
        Thread.sleep(3000);
        Subscriber<String> subscriber = new Subscriber<String>(){

            @Override
            public void onCompleted() {
                System.out.println("complete");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error");
            }

            @Override
            public void onNext(String o) {
                System.out.println(o);
            }
        };
        Subscriber<String> subscriber2 = new Subscriber<String>(){

            @Override
            public void onCompleted() {
                System.out.println("complete2");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error2");
            }

            @Override
            public void onNext(String o) {
                System.out.println(o);
            }
        };
        observable.subscribe(subscriber);
        observable.subscribe(subscriber2);
    }

    @Test
    public void test_thread() throws Exception {
    }
}
