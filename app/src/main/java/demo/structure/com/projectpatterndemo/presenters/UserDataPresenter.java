package demo.structure.com.projectpatterndemo.presenters;

import android.app.Activity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;
import java.util.List;
import demo.structure.com.projectpatterndemo.models.UserDataModel;
import demo.structure.com.projectpatterndemo.viewmodels.UserModelView;
import demo.structure.com.projectpatterndemo.views.interfaces.UserInterFace;
import demo.structure.com.projectpatterndemo.views.parser.Parser;

public class UserDataPresenter {
    private UserInterFace userInterface;
    private Activity mActivity;
    private String WEB_URL = "https://jsonplaceholder.typicode.com/users";
    private List<UserDataModel> userDataList;

    public UserDataPresenter(UserInterFace muserInterFace) {
        //System.out.print(""+muserInterFace);
        this.userInterface = muserInterFace;

    }

    public void getuserData(Activity mActivity) {
        this.mActivity = mActivity;
        userDataList= new ArrayList<UserDataModel>();
        fetchData();

    }

    /**
     * Method to  fetch data from server
     */
    private void fetchData() {
        StringRequest userRequest = new StringRequest(WEB_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        userDataList = Parser.getUserDataList(response);
                        UserModelView userViewModel = new UserModelView(userDataList);
                        userInterface.setUserDetail(userDataList);
                        userInterface.setFullAddress(userViewModel.getFullAddress());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(mActivity);
        requestQueue.add(userRequest);
    }


}





