package com.yancy.project.service;

import com.yancy.project.model.dto.tag.TagAddRequest;
import com.yancy.project.model.dto.tag.TagDeleteRequest;
import com.yancy.project.model.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yancy.project.model.entity.User;
import com.yancy.project.model.vo.UserTags;

/**
* @author 11567
* @description 针对表【tag(标签)】的数据库操作Service
* @createDate 2022-11-24 14:01:02
*/
public interface TagService extends IService<Tag> {

    /**
     *
     * @param tagAddRequest
     * @return
     */
    boolean addUserTag(TagAddRequest tagAddRequest, User loginUser);

    /**
     * 删除用户指定标签
     * @param tagDeleteRequest
     * @param loginUser
     * @return
     */
    Boolean deleteUserTag(TagDeleteRequest tagDeleteRequest, User loginUser);

    /**
     * 根据用户Id获取Tags列表
     * @param userId
     * @return
     */
    public Tag getTagByUserId(Long userId);

    /**
     * 获取用户Tags
     * @param loginUser
     * @return
     */
    UserTags getUserTags(User loginUser);
}
