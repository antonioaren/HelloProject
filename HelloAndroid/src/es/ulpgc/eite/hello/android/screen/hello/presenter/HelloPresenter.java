package es.ulpgc.eite.hello.android.screen.hello.presenter;


import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObserver;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;
import es.ulpgc.eite.hello.android.landscape.LandscapeHelloView;
import es.ulpgc.eite.hello.android.mediator.HelloMediatorCode;
import es.ulpgc.eite.hello.android.portrait.PortraitHelloView;
import es.ulpgc.eite.hello.android.screen.bye.data.ByeData;
import es.ulpgc.eite.hello.android.screen.bye.model.I_ByeModel;
import es.ulpgc.eite.hello.android.screen.bye.state.ByeState;
import es.ulpgc.eite.hello.android.screen.bye.view.ByeView;
import es.ulpgc.eite.hello.android.screen.hello.data.HelloData;
import es.ulpgc.eite.hello.android.screen.hello.model.I_HelloModel;
import es.ulpgc.eite.hello.android.screen.hello.state.HelloState;
import es.ulpgc.eite.hello.android.screen.hello.view.I_HelloView;

public abstract class HelloPresenter extends AndroidScreenPresenter
        implements I_HelloPresenter, I_ScreenObserver {

    private Boolean _btnClicked;

    public Boolean getBtnClicked() {
        return _btnClicked;
    }

    public void setBtnClicked(Boolean btnClicked) {
        _btnClicked = btnClicked;
    }

    private I_HelloView getHelloView() {
        return (I_HelloView) getScreenView();
    }

    private I_HelloModel getHelloModel(){
        return (I_HelloModel) getScreenModel();
    }

    @Override
    public void buttonClicked(){

        setBtnClicked(true);
        debug("buttonClicked", "clicked", getBtnClicked());

        getHelloView().showMessage();
        startNextScreenWithObserver(this, HelloMediatorCode.CLICK_HELLO);
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getHelloView().setLayout();
        getHelloView().setListener();
        getHelloView().hideMessage();
        setBtnClicked(false);
        getHelloModel().setData(new HelloData(
                I_HelloModel.TXT_MSG, I_HelloModel.TXT_BTN));

    }

    @Override
    public void backScreen() {
        debug("backScreen");
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen", "clicked", getBtnClicked());

        getHelloView().setData(getHelloModel().getData());
        if(getBtnClicked()){
            getHelloView().showMessage();
        }
    }

    @Override
    public void pauseScreen() {
        debug("pauseScreen");
    }



    public void changeRotation(int code){
        debug("changeRotation", "code", code);

        startNextScreenWithFinish(code, true);
    }

    @Override
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "code", code);
        debug("setScreenState", "view", view.getSimpleName());


        if(state != null) {
            HelloState _state = (HelloState) state;
            getHelloModel().setData(_state.getData());
            setBtnClicked(_state.getBtnClicked());
        }

        debug("setScreenState", "clicked", getBtnClicked());
    }

    @Override
    public I_ScreenState getScreenState() {


        HelloState state = new HelloState();
        state.setData(getHelloModel().getData());
        state.setBtnClicked(getBtnClicked());

        debug("getScreenState", "clicked", getBtnClicked());

        return state;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {

        debug("getNextState", "code", code);
        debug("getNextState", "view", view.getSimpleName());

        debug("getNextState", "clicked", getBtnClicked());

        if(view.equals(ByeView.class) && code == HelloMediatorCode.CLICK_HELLO){
            ByeState state = new ByeState();
            state.setData(new ByeData(I_ByeModel.TXT_MSG, I_ByeModel.TXT_BTN));
            return state;
        }

        if((view.equals(LandscapeHelloView.class)
                && code == HelloMediatorCode.LANDSCAPE)
                || (view.equals(PortraitHelloView.class)
                && code == HelloMediatorCode.PORTRAIT)){

            HelloState state = new HelloState();
            state.setData(getHelloModel().getData());
            state.setBtnClicked(getBtnClicked());
            return state;
        }

        return null;
    }

    @Override
    public I_ScreenState updateObserverState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateObserverState", "code", code);
        debug("updateObserverState", "view", view.getSimpleName());

        if(state != null) {
            if(view.equals(ByeView.class) && code == HelloMediatorCode.CLICK_BYE){
                HelloState _state = (HelloState) state;
                getHelloModel().setData(_state.getData());
            }

            resumeScreen();
        }


        return null;
    }
}
