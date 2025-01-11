package net.fishy.weaponmod.datagen;

import net.fishy.weaponmod.WeaponMod;
import net.fishy.weaponmod.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WeaponMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(Moditems.ALEXANDRITE.get());
        basicItem(Moditems.sheet_metal.get());
        basicItem((Moditems.nuclear_waste_1.get()));

        basicItem(Moditems.raw_randomness.get());
        basicItem(Moditems.raw_silliness.get());

        handheldItem(Moditems.special_stick);
        handheldItem(Moditems.silly_pickaxe);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0", ResourceLocation.fromNamespaceAndPath(WeaponMod.MODID, "item/" + item.getId().getPath()));
    }

}
