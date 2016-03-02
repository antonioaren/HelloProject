package es.ulpgc.eite.hello.android.screen.bye.view;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import es.ulpgc.eite.framework.android.AndroidScreenView;
import es.ulpgc.eite.hello.android.R;
import es.ulpgc.eite.hello.android.screen.bye.data.ByeData;
import es.ulpgc.eite.hello.android.screen.bye.presenter.I_ByePresenter;

public class ByeView extends AndroidScreenView implements I_ByeView {

    private I_ByePresenter getByePresenter(){
        return (I_ByePresenter) getScreenPresenter();
    }

    @Override
    public void setLayout(){
        debug("setLayout");

        setContentView(R.layout.bye_view);
    }

    @Override
    public void hideMessage(){
        debug("hideMessage");

        TextView scrMsg = (TextView) findViewById(R.id.byeMsgTextView);
        scrMsg.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(){
        debug("showMessage");

        TextView scrMsg = (TextView) findViewById(R.id.byeMsgTextView);
        scrMsg.setVisibility(View.VISIBLE);
    }

    @Override
    public void setData(ByeData data){
        debug("setData");

        TextView scrMsg = (TextView) findViewById(R.id.byeMsgTextView);
        scrMsg.setText(data.getTxtMsg());

        Button scrBtn = (Button) findViewById(R.id.sayByeButton);
        scrBtn.setText(data.getTxtBtn());
    }

    @Override
    public void setListener(){
        debug("setListener");

        Button scrBtn = (Button) findViewById(R.id.sayByeButton);
        scrBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getByePresenter().buttonClicked();
            }
        });
    }
}
