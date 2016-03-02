package es.ulpgc.eite.hello.android.screen.hello.view;


import es.ulpgc.eite.hello.android.screen.hello.data.HelloData;

public interface I_HelloView {

    void setLayout();
    void hideMessage();
    void showMessage();
    void setData(HelloData data);
    void setListener();
}
