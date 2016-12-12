package edu.bsuir.ss.utils;

import java.util.List;

import edu.bsuir.ss.api.login.LoginResponse;

/**
 * Created by Antony on 04.12.2016.
 */
public class UserStorage {
    private static UserStorage instance;

    private LoginResponse sessionDetails;
    //private List<TrackingModel> listTracking;

    private UserStorage() {
    }

    public synchronized static UserStorage getInstance() {
        if (instance == null)
            instance = new UserStorage();

        return instance;
    }

    public void logout(){
        sessionDetails = null;
    }

    public void setSessionDetails(LoginResponse details) {
        this.sessionDetails = details;
    }

    public LoginResponse getSessionDeatils() {
        return this.sessionDetails;
    }

 /*   public void setListTracking(List<TrackingModel> listTracking) {
        this.listTracking = listTracking;
    }
    public List<TrackingModel> getListTracking() {
        return this.listTracking;
    }
    */

}
