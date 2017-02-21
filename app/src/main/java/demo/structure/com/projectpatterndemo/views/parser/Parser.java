package demo.structure.com.projectpatterndemo.views.parser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import demo.structure.com.projectpatterndemo.models.UserDataModel;

/**
 * Created by amol on 21/2/17.
 */

public class Parser {

    /**
     * Method used to parse user data
     *
     * @param response
     * @return
     */
    public static List<UserDataModel> getUserDataList(String response) {
        List<UserDataModel> userDataList = new ArrayList<UserDataModel>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int count = 0; count < jsonArray.length(); count++) {
                JSONObject jsonObject = jsonArray.getJSONObject(count);
                UserDataModel userDataModel = new UserDataModel();
                userDataModel.setId(jsonObject.getString("id"));
                userDataModel.setName(jsonObject.getString("name"));
                userDataModel.setEmail(jsonObject.getString("email"));
                JSONObject jsonArrayAdd = jsonObject.getJSONObject("address");
                userDataModel.setStreet(jsonArrayAdd.getString("street"));
                userDataModel.setSuite(jsonArrayAdd.getString("suite"));
                userDataModel.setCity(jsonArrayAdd.getString("city"));
                userDataModel.setZipcode(jsonArrayAdd.getString("zipcode"));
                userDataList.add(userDataModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDataList;
    }
}
