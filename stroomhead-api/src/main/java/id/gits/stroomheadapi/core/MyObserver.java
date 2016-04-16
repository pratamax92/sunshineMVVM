package id.gits.stroomheadapi.core;


import rx.Observer;

public abstract class MyObserver<T> implements Observer<T> {

    @Override
    public final void onCompleted() {
        onApiResultCompleted();
    }

    @Override
    public final void onError(Throwable e) {
        onApiResultError(e.getMessage());
        onApiResultCompleted();
    }

    @Override
    public final void onNext(T t) {
        onApiResultOk(t);
    }

    public abstract void onApiResultCompleted();

    public abstract void onApiResultError(String message);

    public abstract void onApiResultOk(T t);
}