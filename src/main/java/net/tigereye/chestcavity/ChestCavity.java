package net.tigereye.chestcavity;

import net.tigereye.chestcavity.components.CCComponent;
import net.tigereye.chestcavity.components.InventoryComponent;
import net.tigereye.chestcavity.items.*;
import net.tigereye.chestcavity.listeners.LootTableRegister;
import nerdhub.cardinal.components.api.ComponentRegistry;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.event.EntityComponentCallback;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class ChestCavity implements ModInitializer {
	public static final String MODID = "chestcavity";

	//public static final ComponentKey<InventoryComponent> INVENTORY_COMPONENT = ComponentRegistry.INSTANCE.registerStatic(new Identifier("chestcavity","inventory_component"), InventoryComponent.class);
	public static final ComponentType<InventoryComponent> INVENTORYCOMPONENT =
		ComponentRegistry.INSTANCE.registerIfAbsent(new Identifier("chestcavity:inventorycomponent"), InventoryComponent.class);


	@Override
	public void onInitialize() {
		//Register mod resources
		RegisterItems.register();
		EntityComponentCallback.event(PlayerEntity.class).register((player, components) -> components.put(INVENTORYCOMPONENT, new CCComponent(player)));
		LootTableRegister.register();

		

	}
}