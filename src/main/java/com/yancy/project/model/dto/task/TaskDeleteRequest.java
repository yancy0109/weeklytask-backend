package com.yancy.project.model.dto.task;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 新增用户标签
 * @author yancy0109
 */

@Data
public class TaskDeleteRequest implements Serializable {

    private static final long serialVersionUID = -1080777159357684972L;

    /**
     * 任务删除标签名
     */
    private String tagName;
}
