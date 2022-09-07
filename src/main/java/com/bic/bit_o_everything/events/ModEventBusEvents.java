package com.bic.bit_o_everything.events;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.particle.ModParticles;
import com.bic.bit_o_everything.particle.custom.CrystalParticles;
import com.bic.bit_o_everything.particle.custom.FailedSpellParticles;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BitOEverything.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerPaticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.FAILED_SPELL_PARTICLES.get(),
                FailedSpellParticles.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.CRYSTAL_PARTICLES.get(),
                CrystalParticles.Provider::new);

    }



}
