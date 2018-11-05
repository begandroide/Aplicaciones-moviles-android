package cl.bgautier.tabletsamsung;

import java.math.BigInteger;

public class Country {
    private String Name;
    private String Population;
    private String Density;

    public Country(String Name, String Population, String Density){
        this.Name = Name;
        this.Population = Population;
        this.Density = Density;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public String getDensity() {
        return Density;
    }

    public void setDensity(String density) {
        Density = density;
    }

    @Override
    public String toString() {
        return getName()+' '+getDensity()+' '+getPopulation();
    }
}
