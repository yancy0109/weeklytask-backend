package com.yancy.project.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yancy.project.common.PageRequest;
import com.yancy.project.model.dto.task.TaskAddRequest;
import com.yancy.project.model.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yancy.project.model.entity.User;
import com.yancy.project.model.vo.UserTaskVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    /**
     * 获取用户任务队列
     * @param loginUser
     * @return
     */
    List<Task> getUserTasks(User loginUser);

    /**
     * 分页获取任务数据
     * @param pageRequest
     * @param loginUser
     * @return
     */
    Page<UserTaskVo> getUserTasksPages(PageRequest pageRequest, User loginUser);
}
