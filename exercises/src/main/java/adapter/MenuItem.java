package adapter;

import java.util.List;

public interface MenuItem {

    List<MenuItem> getChildren();

    String getName();

    int numberOfAllChildren();
}
