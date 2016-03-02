package es.ulpgc.eite.hello.android.screen.bye.data;


public class ByeData {

    private String _txtMsg;
    private String _txtBtn;

    public ByeData(String txtMsg, String txtBtn) {
        setTxtMsg(txtMsg);
        setTxtBtn(txtBtn);
    }

    public ByeData() {
        setTxtBtn("");
        setTxtMsg("");
    }

    public String getTxtMsg() {
        return _txtMsg;
    }

    public void setTxtMsg(String txtMsg) {
        _txtMsg = txtMsg;
    }

    public String getTxtBtn() {
        return _txtBtn;
    }

    public void setTxtBtn(String txtBtn) {
        _txtBtn = txtBtn;
    }
}
