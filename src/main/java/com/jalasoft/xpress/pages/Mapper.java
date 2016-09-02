package com.jalasoft.xpress.pages;

import com.jalasoft.xpress.pages.project.ProjectSteps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniel Gonzales on 9/2/2016.
 */
public class Mapper {
    private static final Map<String, Map> PROJECTS_VALUES = new HashMap<>();

    public static Map<String, Map> addProjects(String key, Map<ProjectSteps, Object> values) {
        return PROJECTS_VALUES.put(key, values);
    }
}
