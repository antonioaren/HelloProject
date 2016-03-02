package es.ulpgc.eite.hello.android.screen.hello.state;

import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.hello.android.screen.hello.data.HelloData;

public class HelloState implements I_ScreenState {

    private HelloData _data;
    private Boolean _btnClicked;

    public HelloState() {
        setData(new HelloData());
        setBtnClicked(false);
    }

    public HelloData getData() {
        return _data;
    }

    public void setData(HelloData data) {
        _data = data;
    }


    public Boolean getBtnClicked() {
        return _btnClicked;
    }

    public void setBtnClicked(Boolean btnClicked) {
        _btnClicked = btnClicked;
    }
}
