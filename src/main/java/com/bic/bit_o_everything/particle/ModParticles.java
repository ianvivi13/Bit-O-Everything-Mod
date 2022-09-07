package com.bic.bit_o_everything.particle;

import com.bic.bit_o_everything.BitOEverything;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BitOEverything.MOD_ID);

    public static final RegistryObject<SimpleParticleType> FAILED_SPELL_PARTICLES =
            PARTICLE_TYPES.register("failed_spell_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> CRYSTAL_PARTICLES =
            PARTICLE_TYPES.register("crystal_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
