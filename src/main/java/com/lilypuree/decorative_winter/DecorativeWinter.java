package com.lilypuree.decorative_winter;

import com.lilypuree.decorative_winter.client.WinterTextureStitcher;
import com.lilypuree.decorative_winter.setup.ClientConstruction;
import com.lilypuree.decorative_winter.setup.ClientSetup;
import com.lilypuree.decorative_winter.setup.ModSetup;
import com.lilypuree.decorative_winter.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(DecorativeWinter.MODID)
public class DecorativeWinter
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "decorative_winter";


    public DecorativeWinter() {
        WinterTextureStitcher.setupFolders();
        DistExecutor.runWhenOn(Dist.CLIENT, () -> ClientConstruction::run);

        Registration.register();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }


}
