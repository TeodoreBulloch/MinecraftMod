// Specifies the package where this class belongs in the project
package net.teenuggetta.teenuggetta_mod;

// Imports the necessary classes from Mojang, Minecraft, Forge, and our own mod
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.teenuggetta.teenuggetta_mod.item.ModItems;
import org.slf4j.Logger;

// This annotation tells Forge that this is a mod class, and the mod ID is "teenuggetta_mod"
@Mod(TeeNuggetTa_Mod.MOD_ID)
public class TeeNuggetTa_Mod
{
    // Declares a constant string for the mod's ID that can be used throughout the mod code
    public static final String MOD_ID = "teenuggetta_mod";
    // Sets up a logger that we can use to output information to the console
    private static final Logger LOGGER = LogUtils.getLogger();

    // Constructor for the main mod class. This is run when Minecraft is loading mods.
    public TeeNuggetTa_Mod()
    {
        // Gets the mod event bus that allows us to receive or emit events
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Calls the method that registers our mod items with the event bus
        ModItems.register(modEventBus);

        // Add a listener for the 'common setup' stage of mod loading
        modEventBus.addListener(this::commonSetup);

        // Registers this mod to receive MinecraftForge events
        MinecraftForge.EVENT_BUS.register(this);

        // Adds a listener for when we should add our items to the creative tab
        modEventBus.addListener(this::addCreative);


    }

    // Method to do some setup when Forge is in the 'common setup' stage of loading mods
    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Method to add our items to the creative tab when Forge tells us it's time to do so
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.MINISTEVE);
        }
    }

    // Event handler for when the server starts. This is where we can do things that should happen
    // right as the server starts up.
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // A nested class to handle client-only events
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        // Event handler for when the client is setting up. This is where we can do things that should
        // happen right as the client is being set up.
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Output some information to the console
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
