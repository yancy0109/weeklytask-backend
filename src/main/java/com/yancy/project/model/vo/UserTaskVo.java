package com.yancy.project.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户列表VO
 */
@Data
public class UserTaskVo implements Serializable {

    private static final long serialVersionUID = 112306029282871786L;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务描述
     */
    private String taskDescription;

    /**
     * 任务标签
     */
    private List<String> taskTagList;

    /**
     * 是否完成
     */
    private Integer isFinish;

    /**
     * 是否有延期
     */
    private Integer isDelay;

    /**
     * 完成时间
     */
    private Date finishTime;


}