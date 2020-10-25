package com.project.management.domainDAO;

public class ReportsQueryDAO {

    private final static String SALARY_BY_PROJECT = "SELECT sum(d.salary) FROM developers d JOIN developers_projects dp ON d.developer_id= dp.developer_id\n" +
            "WHERE dp.project_id in (SELECT project_id FROM projects WHERE name= ?)";
    private final static String DEVELOPERS_ON_PROJECT = "SELECT name FROM developers d JOIN developers_projects dp ON d.developer_id= dp.developer_id " +
            "WHERE dp.project_id IN (SELECT project_id  FROM projects WHERE  projects.name= ?);";
    private final static String DEVELOPERS_BY_LANGUAGE = "SELECT DISTINCT name,salary,sex,age FROM developers d JOIN developers_skills ds on d.developer_id = ds.developer_id\n" +
            "WHERE ds.skill_id IN (SELECT skills_id FROM skills WHERE skill_name = ?);";
    private final static String DEVELOPERS_BY_LEVEL = "SELECT DISTINCT name,salary,sex,age FROM developers d JOIN developers_skills ds on d.developer_id = ds.developer_id\n" +
            "WHERE ds.skill_id IN (SELECT skills_id FROM skills WHERE skill_level = ?);";
    private final static String LIST_OF_PROJECTS = "SELECT proj.date,proj.project_name,proj.count FROM" +
            "(SELECT DISTINCT p.name AS project_name,max( p.dead_line) AS date, count(dp.developer_id) AS count FROM projects p" +
            "  JOIN developers_projects dp on p.project_id = dp.project_id GROUP BY p.name ORDER BY p.name)proj;";

    public void costOfProject(String name) {
        OutPutValidator.writeOUT(SALARY_BY_PROJECT, name);
    }

    public void developersByLanguage(String name) {
        OutPutValidator.writeOUT(DEVELOPERS_BY_LANGUAGE, name);
    }

    public void developersOnProject(String name) {
        OutPutValidator.writeOUT(DEVELOPERS_ON_PROJECT, name);
    }

    public void developersByLevel(String name) {
        OutPutValidator.writeOUT(DEVELOPERS_BY_LEVEL, name);
    }

    public void listOfProjects() {
        OutPutValidator.writeOUT(LIST_OF_PROJECTS);
    }

}
