package beans;

public class ColorBean {
    private String foregroundColor;
    private String backgroundColor;
    private Boolean borders;

    public ColorBean() {
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Boolean getBorders() {
        return borders;
    }

    public void setBorders(Boolean borders) {
        this.borders = borders;
    }
}
