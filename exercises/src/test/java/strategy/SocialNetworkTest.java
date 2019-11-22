package strategy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SocialNetworkTest {

    @Test
    public void createMember() {
        Member member = new Member("John Doe", Arrays.asList("Java", "OOP"));
        assertThat(member.getName(), equalTo("John Doe"));
        assertThat(member.getSkills(), equalTo(Arrays.asList("Java", "OOP")));
    }

    @Test
    public void testFindMembersBy() {
        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
           new Member("John Doe", Arrays.asList("Java", "OOP")),
           new Member("Jane Doe", Arrays.asList(".NET", "OOP")),
           new Member("James Doe", Arrays.asList("Python", "Java", "OOP")),
           new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"))
        ));

        List<Member> found = socialNetwork.findMembersBy(m -> m.getSkills().contains("Java"));
        assertThat(found.size(), equalTo(2));
        assertThat(found.get(0).getName(), equalTo("John Doe"));
        assertThat(found.get(1).getName(), equalTo("James Doe"));
    }

    @Test
    public void testApplyToSelectedMembers() {
        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP")),
                new Member("Jane Doe", new ArrayList<>(Arrays.asList(".NET", "OOP"))),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP")),
                new Member("Janet Doe", new ArrayList<>(Arrays.asList("JavaScript", "scripting")))
        ));

        socialNetwork.applyToSelectedMembers(m -> m.getName().startsWith("Jane"), m -> m.getSkills().add("Design Patterns"));

        assertThat(socialNetwork.findMembersBy(m -> m.getName().equals("Jane Doe")).get(0).getSkills(),
                equalTo(Arrays.asList(".NET", "OOP", "Design Patterns")));

        assertThat(socialNetwork.findMembersBy(m -> m.getName().equals("John Doe")).get(0).getSkills(),
                equalTo(Arrays.asList("Java", "OOP")));

        assertThat(socialNetwork.findMembersBy(m -> m.getName().equals("Janet Doe")).get(0).getSkills(),
                equalTo(Arrays.asList("JavaScript", "scripting", "Design Patterns")));


    }

}
