package net.fishy.weaponmod.datagen;

import net.fishy.weaponmod.block.ModBlocks;
import net.fishy.weaponmod.item.Moditems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        //blocks that drop themselves when broken :3
        dropSelf(ModBlocks.SILLY_BLOCK.get());
        dropSelf(ModBlocks.BLOCK_OF_SILLY.get());

        //blocks that drop other stuff (ore) :O
        this.add(ModBlocks.RANDOM_ORE.get(), block -> createOreDrop(ModBlocks.RANDOM_ORE.get(), Moditems.raw_randomness.get()));
        this.add(ModBlocks.SILLY_ORE.get(), block -> createOreDrop(ModBlocks.SILLY_ORE.get(), Moditems.raw_silliness.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
