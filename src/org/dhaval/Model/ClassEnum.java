package org.dhaval.Model;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Dhaval on 4/30/2016.
 */
public enum ClassEnum {
    HISTORY("history"),
    CHEMISTRY("chemistry"),
    PHYSICS("physics"),
    MATHEMATICS("mathematics");

    private String name;
    private int count;
    private Set<String> professors;

    public void setName(String name) {
        this.name = name;
    }

    ClassEnum(String name) {
        this.name = name;
    }

    public Set<String> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<String> professors) {
        this.professors = professors;
    }

    public String getName(){
        return name;

    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount(){
        return count;
    }
}
