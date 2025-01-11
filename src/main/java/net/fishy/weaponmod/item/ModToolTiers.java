package net.fishy.weaponmod.item;

import net.fishy.weaponmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier SILLY = new ForgeTier(10000, 50, 25f, 5,
            ModTags.Blocks.NEEDS_SILLY_TOOL, () -> Ingredient.of(Moditems.raw_silliness.get()),
            ModTags.Blocks.INCORRECT_FOR_SILLY_TOOL);
}
