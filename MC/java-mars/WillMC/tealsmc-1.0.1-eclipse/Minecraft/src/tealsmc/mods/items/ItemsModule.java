package tealsmc.mods.items;

import org.tealsk12.tealsmodloader.module.Module;

public class ItemsModule extends Module {

    public static final RockSifter rockSifter = new RockSifter();
    public static final CrystalGrowingItem crystalGrowingItem = new CrystalGrowingItem();
    public static final SoundBarrier soundBarrier = new SoundBarrier();
    public static final TeslaCannon teslaCannon = new TeslaCannon();
    public void onLoad() {
        parentMod.itemRegistry.newInstance("rock_sifter", rockSifter, "Rock Sifter");
        parentMod.itemRegistry.newInstance("crystal_growing_item", crystalGrowingItem, "Crystal Growing Item");
        parentMod.itemRegistry.newInstance("sound_barrier_item", soundBarrier, "Sound Barrier");
        parentMod.itemRegistry.newInstance("tesla_cannon", teslaCannon, "Tesla Cannon");
    }
}
