package com.rapoo.store;

import lombok.Data;

@Data
public class User {
    private Long uid;
    private String username;
    private String password;
    private String identity;
    private Long cartid;
}
