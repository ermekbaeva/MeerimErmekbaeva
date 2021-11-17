package com.epam.tc.hw7.data;

import com.epam.tc.hw7.entity.User;

public class UserDataProvider {

    public static User ROMAN = new User().set(c -> {
                c.name = "Roman";
                c.password = "Jdi1234";
            }
    );
}
