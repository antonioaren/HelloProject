package es.ulpgc.eite.hello.android.screen.hello.model;


import es.ulpgc.eite.hello.android.screen.hello.data.HelloData;

public interface I_HelloModel {

    String TXT_MSG = "Hello World!";
    String TXT_BTN = "Say Hello";

    HelloData getData();
    void setData(HelloData data);
}
