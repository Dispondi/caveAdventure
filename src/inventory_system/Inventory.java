package inventory_system;

import inventory_system.items.armors.Armor;
import inventory_system.items.armors.NakedBody;
import inventory_system.items.swords.Hands;
import inventory_system.items.swords.Sword;

public class Inventory {
    private Sword sword;
    private Armor armor;

    public Inventory() {
    }

    public Sword getSword() {
        if (sword == null) sword = new Hands();
        return sword;
    }

    public Armor getArmor() {
        if (armor == null) armor = new NakedBody();
        return armor;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
