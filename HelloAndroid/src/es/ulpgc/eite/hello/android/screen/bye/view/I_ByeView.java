package es.ulpgc.eite.hello.android.screen.bye.view;


import es.ulpgc.eite.hello.android.screen.bye.data.ByeData;

public interface I_ByeView {

    void setLayout();
    void hideMessage();
    void showMessage();
    void setData(ByeData data);
    void setListener();
}
