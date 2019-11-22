package composite;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Header implements DocumentPart {

    private Map<String, String> entries = new LinkedHashMap<>();

    public void addEntry(String name, String value) {
        entries.put(name, value);
    }

    @Override
    public List<DocumentPart> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public String getPrefix() {
        return "---\n";
    }

    @Override
    public String getContent() {
        return entries.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue()).collect(Collectors.joining("\n"));
    }

    @Override
    public String getPostfix() {
        return "---\n\n";
    }
}
