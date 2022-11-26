package com.yancy.project.model.dto.tag;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 新增用户标签
 * @author yancy0109
 */

@Data
public class TagDeleteRequest implements Serializable {

    private static final long serialVersionUID = 6757307172198767594L;
    /**
     * 用户删除标签名
     */
    private String tagName;
}
