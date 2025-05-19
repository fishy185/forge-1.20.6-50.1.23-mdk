package net.fishy.weaponmod.worldgen;

import net.fishy.weaponmod.WeaponMod;
import net.fishy.weaponmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILLY_ORE_KEY = registerKey("silly_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RANDOM_ORE_KEY = registerKey("random_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        /*
        List<OreConfiguration.TargetBlockState> overworldSillyOres = List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.SILLY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.RANDOM_ORE.get().defaultBlockState()));
         */

        register(context, OVERWORLD_RANDOM_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables, ModBlocks.RANDOM_ORE.get().defaultBlockState(), 15));
        register(context, OVERWORLD_SILLY_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,ModBlocks.SILLY_ORE.get().defaultBlockState(), 15));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(WeaponMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
