package com.example.espino.loginrelative;


public interface IloginMVP {

    int OK = 0;
    int PASSWORD_DIGIT = 1;
    int PASSWORD_CASE = 2;
    int PASSWORD_LENGTH = 3;
    int PASSWORD_DATA_EMTY = 4;

    interface View{
         void setMessage(String msg, int idView);

    }

    interface Presenter{
        void validateCredentials(String pass, String user);

    }
}
