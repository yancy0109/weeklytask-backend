package com.yancy.project.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yancy0109
 */
@SpringBootTest
public class TagServiceTest {

    @Test
    void testSplit () {
        String str = "学习,CODING,单词,娱乐";
        List<String> collect = Arrays.stream(str.split(",")).filter(
                item -> {
                    if (!item.equals("学习")){
                        return true;
                    }
                    return false;
                }
        ).collect(Collectors.toList());

        String newStr = Arrays.toString(collect.toArray());
        String replace = newStr.replace("[", "").replace("]","").replace(" ","");
        String[] split = replace.split(",");
        for (String s : split) {
            System.out.println(":"+s+":");
        }

        System.out.println(replace);
    }
}
