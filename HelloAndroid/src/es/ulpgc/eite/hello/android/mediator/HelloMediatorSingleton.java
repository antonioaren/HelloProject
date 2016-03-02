package es.ulpgc.eite.hello.android.mediator;


import es.ulpgc.eite.framework.android.AndroidMediatorSingleton;

public class HelloMediatorSingleton extends AndroidMediatorSingleton{

    @Override
    public void createMediator() {
        setCustomConfig(new HelloMediatorConfig(this));
    }
}
