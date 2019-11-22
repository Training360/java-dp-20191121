package mediator;

public class Component {

    private ComponentType componentType;

    private boolean visible;

    private String value;

    public Component(ComponentType componentType, boolean visible, String value) {
        this.componentType = componentType;
        this.visible = visible;
        this.value = value;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
