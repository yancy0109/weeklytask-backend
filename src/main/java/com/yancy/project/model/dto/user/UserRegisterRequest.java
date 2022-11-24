package com.yancy.project.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author yupi
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 6419213369476290560L;

    private String userName;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
