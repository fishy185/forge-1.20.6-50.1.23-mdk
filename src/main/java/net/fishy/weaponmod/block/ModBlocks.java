package net.fishy.weaponmod.block;

import com.mojang.blaze3d.shaders.Uniform;
import net.fishy.weaponmod.WeaponMod;
import net.fishy.weaponmod.item.Moditems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WeaponMod.MODID);

    public static final RegistryObject<Block> SILLY_BLOCK = registerBlock("silly_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));


    public static final RegistryObject<Block> BLOCK_OF_SILLY = registerBlock("block_of_silly", () -> new Block(BlockBehaviour.Properties.of()
            .strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.ANVIL)));


    public static final RegistryObject<Block> RANDOM_ORE = registerBlock("random_ore", () -> new DropExperienceBlock(UniformInt.of(5, 15),BlockBehaviour.Properties.of()
            .strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));


    public static final RegistryObject<Block> SILLY_ORE = registerBlock("silly_ore", () -> new DropExperienceBlock(UniformInt.of(70,100),BlockBehaviour.Properties.of()
            .strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
