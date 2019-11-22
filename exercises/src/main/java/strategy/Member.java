package strategy;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;

    private List<String> skills;

    public Member(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

}
