package com.yancy.project.model.dto.tag;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 新增用户标签
 * @author yancy0109
 */

@Data
public class TagAddRequest implements Serializable {

    private static final long serialVersionUID = 441036086413102051L;
    /**
     * 用户新增标签名
     */
    private String tagName;
}
