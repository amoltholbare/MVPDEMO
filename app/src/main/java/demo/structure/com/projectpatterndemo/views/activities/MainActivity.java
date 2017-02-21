package demo.structure.com.projectpatterndemo.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import demo.structure.com.projectpatterndemo.R;
import demo.structure.com.projectpatterndemo.models.UserDataModel;
import demo.structure.com.projectpatterndemo.presenters.UserDataPresenter;
import demo.structure.com.projectpatterndemo.views.interfaces.UserInterFace;


public class MainActivity extends AppCompatActivity implements UserInterFace {
    private UserDataPresenter presenter;
    private TextView textViewName;
    private TextView textViewAddress;
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerUiComponent();
        presenter = new UserDataPresenter(this);
        presenter.getuserData(MainActivity.this);


    }

    /**
     * @param dataList
     */
    @Override
    public void setUserDetail(List<UserDataModel> dataList) {
        textViewName.setText("Name : " + dataList.get(0).getName());
        textViewEmail.setText("Email : " + dataList.get(0).getEmail());
    }

    /**
     * @param address
     */
    @Override
    public void setFullAddress(String address) {
        textViewAddress.setText("Address : " + address);

    }

    /**
     * Method use for register ui component
     */

    public void registerUiComponent() {
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAddress = (TextView) findViewById(R.id.textViewAddress);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
    }
}
