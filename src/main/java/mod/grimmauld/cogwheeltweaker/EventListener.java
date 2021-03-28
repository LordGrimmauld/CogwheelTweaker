package mod.grimmauld.cogwheeltweaker;

import com.simibubi.create.CreateClient;
import com.simibubi.create.content.contraptions.base.KineticTileEntityRenderer;
import com.simibubi.create.content.contraptions.base.SingleRotatingInstance;
import com.simibubi.create.content.contraptions.relays.elementary.BracketedKineticBlockModel;
import com.simibubi.create.foundation.render.backend.instancing.InstancedTileRenderRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = CogwheelTweaker.MODID)
public class EventListener {
	@SubscribeEvent
	public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
		CogwheelTweaker.LOGGER.info("TEs registering");
		event.getRegistry().register(TileEntityType.Builder.create(CoTWheelTileEntity::new,
			CoTWheelBlock.blocks.toArray(new Block[0])).build(null).setRegistryName("cotwheel"));
	}


	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void clientInit(FMLClientSetupEvent event) {
		CogwheelTweaker.LOGGER.info("renderers registering");
		ClientRegistry.bindTileEntityRenderer(ObjectHolders.COTWHEEL_TILE, KineticTileEntityRenderer::new);
		InstancedTileRenderRegistry.instance.register(ObjectHolders.COTWHEEL_TILE, SingleRotatingInstance::new);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onModelBake(ModelBakeEvent event) {
		CoTWheelBlock.blocks.forEach(block -> CreateClient.getCustomBlockModels().register(block.delegate, BracketedKineticBlockModel::new));
	}

}
