package com.yancy.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yancy.project.common.ErrorCode;
import com.yancy.project.exception.BusinessException;
import com.yancy.project.model.dto.tag.TagAddRequest;
import com.yancy.project.model.dto.tag.TagDeleteRequest;
import com.yancy.project.model.entity.Tag;
import com.yancy.project.model.entity.User;
import com.yancy.project.model.vo.UserTagsVo;
import com.yancy.project.service.TagService;
import com.yancy.project.mapper.TagMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author 11567
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2022-11-24 14:01:02
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

    @Resource
    private TagMapper tagMapper;

    @Override
    public boolean addUserTag(TagAddRequest tagAddRequest, User loginUser) {
        Long userId = loginUser.getId();
        String tagName = tagAddRequest.getTagName();
        synchronized (loginUser.getUserAccount().intern()) {
            // 先进行标签判重
            Tag oldTag = getTagByUserId(userId);
            String tags = oldTag.getTags();
            if (tags.contains(tagName)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR.getCode(), "标签名重复");
            }
            // 新增用户标签
            return tagMapper.addUserTag(tagName, userId) > 0;
        }
    }

    @Override
    public Boolean deleteUserTag(TagDeleteRequest tagDeleteRequest, User loginUser) {
        String tagName = tagDeleteRequest.getTagName();
        Long userId = loginUser.getId();
        synchronized (loginUser.getUserRole().intern()) {
            // 先查询用户是否包含这个Tag
            Tag oldTag = getTagByUserId(userId);
            String oldTags = oldTag.getTags();
            if (!oldTags.contains(tagName)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR.getCode(), "标签名不存在");
            }
            String newTags = Arrays.stream(oldTags.split(",")).filter(
                    item -> {
                        if (!item.equals(tagName)) {
                            return true;
                        }
                        return false;
                    }
            ).collect(Collectors.toList()).toString()
                    .replace("[","")
                    .replace("]","")
                    .replace(" ","");
            oldTag.setTags(newTags);
            boolean result = this.updateById(oldTag);
            return result;
        }
    }

    @Override
    public Tag getTagByUserId(Long userId) {
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        Tag oldTag = this.getOne(queryWrapper);
        return oldTag;
    }

    @Override
    public UserTagsVo getUserTags(User loginUser) {
        Long userId = loginUser.getId();
        Tag tag = this.getTagByUserId(userId);
        // 对用户tag进行拆分
        List<String> tags = Arrays.stream(tag.getTags().split(",")).collect(Collectors.toList());
        // 创建返回对象
        UserTagsVo userTagsVo = new UserTagsVo();
        userTagsVo.setUserAccount(loginUser.getUserAccount());
        userTagsVo.setTags(tags);
        return userTagsVo;
    }
}




