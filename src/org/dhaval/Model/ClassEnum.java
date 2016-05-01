package org.dhaval.Model;

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
    ClassEnum(String name) {
        this.name = name;
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
