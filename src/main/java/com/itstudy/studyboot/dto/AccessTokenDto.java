package com.itstudy.studyboot.dto;

public class AccessTokenDto {
//    client_id	string	需要。您从GitHub收到的GitHub应用程序的客户端ID。
//    client_secret	string	需要。您从GitHub收到的GitHub应用程序的客户机密。
//    code	string	需要。您收到的代码作为对第1步的回复。
//    redirect_uri	string	应用程序中的URL，用于在授权后发送用户。
//    state
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "AccessTokenDto{" +
                "client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", code='" + code + '\'' +
                ", redirect_uri='" + redirect_uri + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
