package gliese832c.circulatorySystem.mainModContent.statusTrackers;

import java.util.ArrayList;

public class TemporaryPotionEffectObject {

    public String resourceLocation;
    public ArrayList<Integer> levels;

    public TemporaryPotionEffectObject(String resourceLocation, ArrayList<Integer> levels) {
        this.resourceLocation = resourceLocation;
        this.levels = levels;
    }
}
