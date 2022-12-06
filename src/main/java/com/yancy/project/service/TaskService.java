package com.yancy.project.service;

import com.yancy.project.model.dto.task.TaskAddRequest;
import com.yancy.project.model.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yancy.project.model.entity.User;

/**
* @author 11567
* @description 针对表【task(任务)】的数据库操作Service
* @createDate 2022-11-24 13:08:01
*/
public interface TaskService extends IService<Task> {

    /**
     * 用户创建任务
     * @param taskAddRequest
     * @param loginUser
     * @return
     */
    boolean createUserTask(TaskAddRequest taskAddRequest, User loginUser);
}
