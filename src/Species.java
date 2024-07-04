public class Species {
    private int id;
    private String name;
    private String planetOfOrigin;
    private int baseDangerLevel;

    public Species(int id, String name, String planetOfOrigin, int baseDangerLevel) {
        this.id = id;
        this.name = name;
        this.planetOfOrigin = planetOfOrigin;
        this.baseDangerLevel = baseDangerLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanetOfOrigin() {
        return planetOfOrigin;
    }

    public void setPlanetOfOrigin(String planetOfOrigin) {
        this.planetOfOrigin = planetOfOrigin;
    }

    public int getBaseDangerLevel() {
        return baseDangerLevel;
    }

    public void setBaseDangerLevel(int baseDangerLevel) {
        this.baseDangerLevel = baseDangerLevel;
    }

}
