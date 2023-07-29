// Package declaration, specifying where this file is located in the project
package net.teenuggetta.teenuggetta_mod.item;

// Importing necessary classes from the Minecraft and Forge libraries
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teenuggetta.teenuggetta_mod.TeeNuggetTa_Mod;
import net.minecraft.world.food.FoodProperties;

// The class responsible for registering mod items
public class ModItems {
    // Creation of a DeferredRegister for Items.
    // This DeferredRegister is a tool to make registration of items to the game easier.
    // It is tied to our mod via the TeeNuggetTa_Mod.MOD_ID identifier.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TeeNuggetTa_Mod.MOD_ID);

    // This line is registering a new item with the mod. It is creating a RegistryObject named MINISTEVE
    // which holds an item. The name of the item is "Mini Steve". The item is simply a new instance of Item
    // with default properties. Whenever this item is referred in the code, MINISTEVE will be used.
    public static final RegistryObject<Item> MINISTEVE = ITEMS.register("ministeve",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(2.4f).build())));

    // Method to register all items in our DeferredRegister to the mod's event bus.
    // This effectively makes the items available in the game.
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
