package com.yancy.project.controller;

import com.yancy.project.common.BaseResponse;
import com.yancy.project.common.ErrorCode;
import com.yancy.project.common.PageRequest;
import com.yancy.project.common.ResultUtils;
import com.yancy.project.exception.BusinessException;
import com.yancy.project.model.dto.task.TaskAddRequest;
import com.yancy.project.model.entity.Task;
import com.yancy.project.model.entity.User;
import com.yancy.project.model.vo.UserTaskVo;
import com.yancy.project.service.TagService;
import com.yancy.project.service.TaskService;
import com.yancy.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author yancy0109
 */

@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @Resource
    private UserService userService;

    @Resource
    private TagService tagService;

    @Resource
    private TaskService taskService;

    /**
     * 用户添加个人任务
     * @param taskAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Boolean> createUserTask(@RequestBody TaskAddRequest taskAddRequest, HttpServletRequest request) {
        String taskName = taskAddRequest.getTaskName();
        String taskTag = taskAddRequest.getTaskTag();
        Date finishTime = taskAddRequest.getFinishTime();
        if (StringUtils.isAllBlank(taskName, taskTag) || ObjectUtils.isEmpty(finishTime)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        boolean result = taskService.createUserTask(taskAddRequest, loginUser);
        return ResultUtils.success(result);
    }

    /**
     * 分页查询用户任务列表
     * @param pageRequest
     * @param request
     * @return
     */
    @GetMapping("/page")
    public BaseResponse<List<UserTaskVo>> getUserTasks(@RequestBody PageRequest pageRequest, HttpServletRequest request){
        User loginUser = userService.getLoginUser(request);
        taskService.getUserTasksPages(pageRequest, loginUser);
        return ResultUtils.success(null);
    }

    /**
     * 按照结束时间倒叙查看任务列表
     * @param request
     * @return
     */
    @GetMapping("/list")
    public BaseResponse<List<Task>> getUserTasks(HttpServletRequest request){
        User loginUser = userService.getLoginUser(request);
        List<Task> taskList = taskService.getUserTasks(loginUser);
        return ResultUtils.success(taskList);
    }

}
