package net.fishy.weaponmod.item;

import net.fishy.weaponmod.WeaponMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WeaponMod.MODID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> nuclear_waste_1 = ITEMS.register("nuclear_waste_1", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> sheet_metal = ITEMS.register("sheet_metal", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> raw_silliness = ITEMS.register("raw_silliness", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> raw_randomness = ITEMS.register("raw_randomness", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> special_stick = ITEMS.register("special_stick", () -> new SwordItem(ModToolTiers.SILLY, new Item.Properties()
            .attributes(SwordItem.createAttributes(ModToolTiers.SILLY, 3, -2.4f))));
    public static final RegistryObject<Item> silly_pickaxe = ITEMS.register("silly_pickaxe", () -> new PickaxeItem(ModToolTiers.SILLY, new Item.Properties()
            .attributes(PickaxeItem.createAttributes(ModToolTiers.SILLY, 1, -2.8f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
