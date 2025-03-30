package net.fishy.weaponmod.datagen;

import net.fishy.weaponmod.WeaponMod;
import net.fishy.weaponmod.item.Moditems;
import net.fishy.weaponmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, WeaponMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //tag(ModTags.Items.TRANSFORMABLE_ITEMS);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(Moditems.UNKNOWN_BOOTS.get())
                .add(Moditems.UNKNOWN_HELMET.get())
                .add(Moditems.UNKNOWN_LEGGINGS.get())
                .add(Moditems.UNKNOWN_CHESTPLATE.get());
    }
}
