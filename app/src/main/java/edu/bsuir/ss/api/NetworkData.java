package edu.bsuir.ss.api;

/**
 * Created by Antony on 04.12.2016.
 */
public class NetworkData {

    public static final String BASE_URL = "https://suits-solutions.herokuapp.com/api/";

    public static final String LOGIN  = "login";
    public static final String LOGOUT  = "logout";
    public static final String GET_TRACKING_TIMES  = "tracking/times";
    public static final String TRACK_UPDATE  = "tracking/update";
    public static final String GET_TASKS  = "task";
    public static final String GET_TASK_BY_ID  = "task/{id}";
    public static final String ID = "id";
    public static final String PAGE = "page";
    public static final String LIKE  = "task/{id}/like";
    public static final String TOKEN  = "api_token";
    public static final String CREATE_TASK  = "user/task";
    public static final String GET_USER_TASKS  = "user/tasks";
    public static final String UPDATE_USER_TASKS  = "task/{id}/update";
    public static final String DELETE_USER_TASKS  = "task/{id}/delete";
    public static final String TASK_COST  = "task-cost";
    public static final String SEND_INVITE  = "send-invite";
}
