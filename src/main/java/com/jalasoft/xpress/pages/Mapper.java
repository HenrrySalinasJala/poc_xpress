package com.jalasoft.xpress.pages;

import com.jalasoft.xpress.pages.project.ProjectSteps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniel Gonzales on 9/2/2016.
 */
public class Mapper {

    private Mapper() {
    }

    private static Map<String, Map> projectsValues = new HashMap<>();

    public static void addProjects(String key, Map<ProjectSteps, Object> values) {
        projectsValues.put(key, values);
    }

    public static String getValueProject(String projectValue) {
        String[] mapString = projectValue.split("\\.");
        return projectsValues.get(mapString[0]).get(ProjectSteps.valueOf(mapString[1])).toString();
    }
}

