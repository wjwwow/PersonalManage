package com.davis.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author Davis
 * @date 2021-12-02 - 16:52
 * @description
 */

public class Auth extends Authenticator {

    private String username = "";
    private String password = "";

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}

