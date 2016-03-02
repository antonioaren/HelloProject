package es.ulpgc.eite.hello.android.screen.bye.model;


import es.ulpgc.eite.hello.android.screen.bye.data.ByeData;

public interface I_ByeModel {

    String TXT_MSG = "Bye World!";
    String TXT_BTN = "Say Bye";

    ByeData getData();
    void setData(ByeData data);
}
