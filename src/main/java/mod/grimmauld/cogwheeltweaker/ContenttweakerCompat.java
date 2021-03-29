package mod.grimmauld.cogwheeltweaker;

import com.blamejared.crafttweaker.impl.commands.script_examples.ExampleCollectionEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;

public class ContenttweakerCompat {
	public static void registerEvents(IEventBus eventBus) {
		eventBus.addListener(ContenttweakerCompat::onExampleCollection);
	}

	public static void onExampleCollection(ExampleCollectionEvent event) {
		event.addResource(new ResourceLocation(CogwheelTweaker.MODID, CogwheelTweaker.MODID + "/cogwheels"));
	}
}
