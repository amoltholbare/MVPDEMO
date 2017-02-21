package demo.structure.com.projectpatterndemo.views.interfaces;

import java.util.List;

import demo.structure.com.projectpatterndemo.models.UserDataModel;

/**
 * Created by amol on 21/2/17.
 */

public interface UserInterFace {
    public void setUserDetail(List<UserDataModel> dataList);
    public void setFullAddress(String address);
}
