package demo.structure.com.projectpatterndemo.viewmodels;

import java.util.List;

import demo.structure.com.projectpatterndemo.models.UserDataModel;

/**
 * Created by amol on 21/2/17.
 */

public class UserModelView {
    private List<UserDataModel> dataList;
    public  UserModelView(List<UserDataModel> list){
        this.dataList=list;

    }
    public String getFullAddress() {
        String fullAddress = dataList.get(0).getStreet() +
                " "+ dataList.get(0).getSuite() +
                " "+ dataList.get(0).getCity()+
                " "+dataList.get(0).getZipcode();
        return fullAddress;
    }
}
