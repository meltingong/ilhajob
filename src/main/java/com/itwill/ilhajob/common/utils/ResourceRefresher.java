package com.itwill.ilhajob.common.utils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class ResourceRefresher {

    public static void refreshResources(String pattern) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources(pattern);
            for (Resource resource : resources) {
                resource.getFile().delete();
                resource.getFile().createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}