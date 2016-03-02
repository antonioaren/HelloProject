package es.ulpgc.eite.hello.android.screen.bye.presenter;


import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObservable;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;
import es.ulpgc.eite.hello.android.landscape.LandscapeHelloView;
import es.ulpgc.eite.hello.android.mediator.HelloMediatorCode;
import es.ulpgc.eite.hello.android.portrait.PortraitHelloView;
import es.ulpgc.eite.hello.android.screen.bye.model.I_ByeModel;
import es.ulpgc.eite.hello.android.screen.bye.state.ByeState;
import es.ulpgc.eite.hello.android.screen.bye.view.I_ByeView;
import es.ulpgc.eite.hello.android.screen.hello.data.HelloData;
import es.ulpgc.eite.hello.android.screen.hello.model.I_HelloModel;
import es.ulpgc.eite.hello.android.screen.hello.state.HelloState;

public class ByePresenter extends AndroidScreenPresenter
        implements I_ByePresenter, I_ScreenObservable {


    private Boolean _btnClicked;

    public Boolean getBtnClicked() {
        return _btnClicked;
    }

    public void setBtnClicked(Boolean btnClicked) {
        _btnClicked = btnClicked;
    }

    private I_ByeView getByeView() {
        return (I_ByeView) getScreenView();
    }

    private I_ByeModel getByeModel(){
        return (I_ByeModel) getScreenModel();
    }

    @Override
    public void buttonClicked(){

        setBtnClicked(true);
        debug("buttonClicked", "clicked", getBtnClicked());

        getByeView().showMessage();
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getByeView().setLayout();
        getByeView().setListener();
        getByeView().hideMessage();
        setBtnClicked(false);

    }

    @Override
    public void backScreen() {

        debug("backScreen", "clicked", getBtnClicked());

        HelloState state = new HelloState();
        HelloData data;
        if(getBtnClicked()){
            data = new HelloData(I_ByeModel.TXT_MSG, I_HelloModel.TXT_BTN);

        } else {
            data = new HelloData(I_HelloModel.TXT_MSG, I_HelloModel.TXT_BTN);
        }
        state.setData(data);

        notifyScreenObservers(this, HelloMediatorCode.CLICK_BYE, state);
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");

        getByeView().setData(getByeModel().getData());
    }

    @Override
    public void pauseScreen() {
        debug("pauseScreen");
    }

    @Override
    public void rotateScreen() {
        debug("rotateScreen");
    }

    @Override
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "code", code);
        debug("setScreenState", "view", view.getSimpleName());

        if(state != null) {
            if ((view.equals(PortraitHelloView.class)
                    && code == HelloMediatorCode.CLICK_HELLO)
                    || (view.equals(LandscapeHelloView.class)
                    && code == HelloMediatorCode.CLICK_HELLO)) {

                ByeState _state = (ByeState) state;
                getByeModel().setData(_state.getData());
                setBtnClicked(_state.getBtnClicked());
            }
        }

        debug("setScreenState", "clicked", getBtnClicked());

    }

    @Override
    public I_ScreenState getScreenState() {

        ByeState state = new ByeState();
        state.setData(getByeModel().getData());
        state.setBtnClicked(getBtnClicked());

        debug("getScreenState", "clicked", getBtnClicked());

        return state;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        return null;
    }

    @Override
    public void updateObservableState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateObservableState");

    }
}
