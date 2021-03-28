package mod.grimmauld.cogwheeltweaker;

import com.blamejared.contenttweaker.api.blocks.IIsCoTBlock;
import com.blamejared.contenttweaker.api.items.IIsCotItem;
import com.blamejared.contenttweaker.api.resources.*;
import com.simibubi.create.content.contraptions.relays.elementary.CogWheelBlock;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CoTWheelBlock extends CogWheelBlock implements IIsCoTBlock {
	private final IIsCotItem item;

	public CoTWheelBlock(CoTWheelBuilder builder, ResourceLocation location) {
		super(false, builder.getBlockBuilder().getBlockProperties());
		this.setRegistryName(location);
		item = new CoTWheelItem(this, builder.getBlockBuilder().getItemProperties());
	}

	@Nonnull
	@Override
	public IIsCotItem getItem() {
		return item;
	}

	@Nonnull
	@Override
	public Collection<WriteableResource> getResourcePackResources() {
		final ResourceLocation location = getRegistryNameNonNull();
		final Collection<WriteableResource> out = new ArrayList<>();

		out.add(WriteableResourceImage.noImage(ImageType.BLOCK, location));

		final WriteableResourceTemplate modelTemplate = new WriteableResourceTemplate(ResourceType.ASSETS,
			location, "models", "block").withTemplate(ResourceType.ASSETS,
			new ResourceLocation(CogwheelTweaker.MODID, "models/block/cogwheel")).setLocationProperty(location);
		out.add(modelTemplate);

		final WriteableResourceTemplate blockstateTemplate = new WriteableResourceTemplate(ResourceType.ASSETS,
			location, "blockstates").withTemplate(ResourceType.ASSETS,
			new ResourceLocation(CogwheelTweaker.MODID, "blockstates/cogwheel")).setLocationProperty(location);
		out.add(blockstateTemplate);

		return out;
	}

	@Nonnull
	@Override
	public Collection<WriteableResource> getDataPackResources() {
		return Collections.singleton(new WriteableResourceLootTableItem(getRegistryNameNonNull()));
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.INVISIBLE;
	}
}
