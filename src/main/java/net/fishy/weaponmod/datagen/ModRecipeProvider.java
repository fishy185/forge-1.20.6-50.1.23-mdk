package net.fishy.weaponmod.datagen;

import net.fishy.weaponmod.block.ModBlocks;
import net.fishy.weaponmod.item.Moditems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_SILLY.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Moditems.raw_silliness.get())
                .unlockedBy(getHasName(Moditems.raw_silliness.get()), has(Moditems.raw_silliness.get())).save(pRecipeOutput);

    }
}
