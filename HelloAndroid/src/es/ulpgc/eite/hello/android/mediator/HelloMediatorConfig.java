package es.ulpgc.eite.hello.android.mediator;


import es.ulpgc.eite.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.framework.core.mediator.MediatorConfig;
import es.ulpgc.eite.framework.core.mediator.MediatorScreen;
import es.ulpgc.eite.framework.core.mediator.MediatorTransition;
import es.ulpgc.eite.hello.android.landscape.LandscapeHelloPresenter;
import es.ulpgc.eite.hello.android.landscape.LandscapeHelloView;
import es.ulpgc.eite.hello.android.portrait.PortraitHelloPresenter;
import es.ulpgc.eite.hello.android.portrait.PortraitHelloView;
import es.ulpgc.eite.hello.android.screen.bye.model.ByeModel;
import es.ulpgc.eite.hello.android.screen.bye.presenter.ByePresenter;
import es.ulpgc.eite.hello.android.screen.bye.view.ByeView;
import es.ulpgc.eite.hello.android.screen.hello.model.HelloModel;

public class HelloMediatorConfig extends MediatorConfig{

    public HelloMediatorConfig(I_MediatorSingleton mediator) {
        super(mediator);
    }

    @Override
    public void setCustomConfig() {
        setHelloConfig();
    }

    private void setHelloConfig() {
        setHelloScreenCollection();
        setHelloTransitionCollection();
    }

    private void setHelloScreenCollection() {
        getScreens().add(new MediatorScreen(LandscapeHelloView.class,
                LandscapeHelloPresenter.class, HelloModel.class));
        getScreens().add(new MediatorScreen(PortraitHelloView.class,
                PortraitHelloPresenter.class, HelloModel.class));
        getScreens().add(new MediatorScreen(
                ByeView.class, ByePresenter.class, ByeModel.class));
    }

    private void setHelloTransitionCollection() {

        getTransitions().add(new MediatorTransition(PortraitHelloView.class,
                LandscapeHelloView.class, HelloMediatorCode.LANDSCAPE));
        getTransitions().add(new MediatorTransition(LandscapeHelloView.class,
                PortraitHelloView.class, HelloMediatorCode.PORTRAIT));

        getTransitions().add(new MediatorTransition(PortraitHelloView.class,
                ByeView.class, HelloMediatorCode.CLICK_HELLO));
        getTransitions().add(new MediatorTransition(LandscapeHelloView.class,
                ByeView.class, HelloMediatorCode.CLICK_HELLO));
    }
}
