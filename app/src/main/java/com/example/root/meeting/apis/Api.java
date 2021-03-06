package com.example.root.meeting.apis;

import com.example.root.meeting.ObRealm.Meeting;
import com.example.root.meeting.ObRealm.Message;
import com.example.root.meeting.ObRealm.MessagingData;
import com.example.root.meeting.ObRealm.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by root on 11.02.18.
 */

public interface Api {
    @GET("/crud-1.0.0-SNAPSHOT/profile/auth")
    Call<User> authUser(@Header("Authorization") String authkey);
    @GET("/crud-1.0.0-SNAPSHOT/profile/friends")
    Call<List<User>> getFriends(@Header("Authorization") String authkey);
    @POST("/crud-1.0.0-SNAPSHOT/profile/friends/add")
    Call<ResponseBody> addFriend(@Header("Authorization") String authKey,@Body User user);

    @GET("/crud-1.0.0-SNAPSHOT/users/")
    Call<List<User>> getUsers(@Header("Authorization") String authkey);
    @GET("/crud-1.0.0-SNAPSHOT/users/{id}")
    Call<List<User>> getUserById(@Header("Authorization") String authkey, @Path("id") String id);

    @POST("/crud-1.0.0-SNAPSHOT/meeting")
    Call<Meeting> createMeeting(@Header("Authorization") String authkey,@Body Meeting meeting);
    @PUT("/crud-1.0.0-SNAPSHOT/meeting/updateName")
    Call<ResponseBody> updateMeetingName(@Header("Authorization") String authkey, @Body Meeting meeting);
    @PUT("/crud-1.0.0-SNAPSHOT/meeting/updatePlace")
    Call<ResponseBody> updateMeetingPlace(@Header("Authorization") String authkey, @Body Meeting meeting);

    @GET("/crud-1.0.0-SNAPSHOT/meeting")
    Call<List<Meeting>> getAllMeetings(@Header("Authorization") String authkey);
    @GET("/crud-1.0.0-SNAPSHOT/meeting/{id}")
    Call<Meeting> getMeeting(@Header("Authorization") String authkey, @Path("id") int id);
    @POST("/crud-1.0.0-SNAPSHOT/meeting/{id}/add")
    Call<ResponseBody> addUserToMeeting(@Header("Authorization") String authkey,@Path("id") int id,@Body User user);
    @GET("/crud-1.0.0-SNAPSHOT/users/fname/{name}")
    Call<List<User>> getUserByName(@Header("Authorization") String authkey, @Path("name") String name);
    @HTTP(method = "DELETE", path = "/crud-1.0.0-SNAPSHOT/meeting/{id}", hasBody = true)
    Call<ResponseBody> deleteUserFromMeeting(@Header("Authorization") String authkey,@Path("id") int id,@Body User user);

    @POST("/crud-1.0.0-SNAPSHOT/create")
    Call<User> createUser(@Header("Authorization") String authkey,@Body User user);

    @POST("/crud-1.0.0-SNAPSHOT/messaging/send")
    Call<ResponseBody> sendMessage(@Header("Authorization") String authkey, @Body Message message);
    @GET("/crud-1.0.0-SNAPSHOT/messaging/{mid}")
    Call<List<MessagingData>> getMessages(@Header("Authorization") String authkey, @Path("mid") int mid);


    @POST("/crud-1.0.0-SNAPSHOT/messaging/token")
    Call<ResponseBody> updateToken(@Header("Authorization") String authkey,@Body String token);
}
