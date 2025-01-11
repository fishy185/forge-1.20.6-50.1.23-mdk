package net.fishy.weaponmod.datagen;

import net.fishy.weaponmod.WeaponMod;
import net.fishy.weaponmod.block.ModBlocks;
import net.fishy.weaponmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WeaponMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOCK_OF_SILLY.get())
                .add(ModBlocks.SILLY_BLOCK.get())
                .add(ModBlocks.RANDOM_ORE.get())
                .add(ModBlocks.SILLY_ORE.get());

        tag(ModTags.Blocks.NEEDS_SILLY_TOOL)
                .add(ModBlocks.RANDOM_ORE.get())
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_SILLY_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_SILLY_TOOL);
    }
}
