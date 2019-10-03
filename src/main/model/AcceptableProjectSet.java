package model;

import java.util.ArrayList;

public interface AcceptableProjectSet {

    String toString();

    void addProject(String projectName);

    void removeProject(String projectName);

    ArrayList getProjectList();




}
