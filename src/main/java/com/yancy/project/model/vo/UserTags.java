package com.yancy.project.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户接收Tag数据
 * @author yancy0109
 */

@Data
public class UserTags implements Serializable {

    private static final long serialVersionUID = -3167259566125225559L;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户标签列表
     */
    private List<String> tags;

}
