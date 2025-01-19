package net.fishy.weaponmod.sound;

import net.fishy.weaponmod.WeaponMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WeaponMod.MODID);

    public static final RegistryObject<SoundEvent> SILLY_BLOCK_BREAK = registerSoundEvent("silly_block_break");
    public static final RegistryObject<SoundEvent> SILLY_BLOCK_STEP = registerSoundEvent("silly_block_step");
    public static final RegistryObject<SoundEvent> SILLY_BLOCK_PLACE = registerSoundEvent("silly_block_place");
    public static final RegistryObject<SoundEvent> SILLY_BLOCK_HIT = registerSoundEvent("silly_block_hit");
    public static final RegistryObject<SoundEvent> SILLY_BLOCK_FALL = registerSoundEvent("silly_block_fall");

    public static final ForgeSoundType SILLY_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.SILLY_BLOCK_BREAK, ModSounds.SILLY_BLOCK_STEP, ModSounds.SILLY_BLOCK_PLACE, ModSounds.SILLY_BLOCK_HIT, ModSounds.SILLY_BLOCK_FALL);



    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WeaponMod.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

}
