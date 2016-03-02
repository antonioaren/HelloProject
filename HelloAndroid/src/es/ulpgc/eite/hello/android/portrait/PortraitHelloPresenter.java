package es.ulpgc.eite.hello.android.portrait;

import es.ulpgc.eite.hello.android.mediator.HelloMediatorCode;
import es.ulpgc.eite.hello.android.screen.hello.presenter.HelloPresenter;

public class PortraitHelloPresenter extends HelloPresenter {

    @Override
    public void rotateScreen() {
        debug("rotateScreen");

        changeRotation(HelloMediatorCode.LANDSCAPE);
    }
}
