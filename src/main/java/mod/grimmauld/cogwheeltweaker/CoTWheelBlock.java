package mod.grimmauld.cogwheeltweaker;

import com.blamejared.contenttweaker.api.blocks.IIsCoTBlock;
import com.blamejared.contenttweaker.api.items.IIsCotItem;
import com.blamejared.contenttweaker.api.resources.*;
import com.simibubi.create.content.contraptions.relays.elementary.CogWheelBlock;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CoTWheelBlock extends CogWheelBlock implements IIsCoTBlock {
	public static final Set<CoTWheelBlock> blocks = new HashSet<>();
	private final IIsCotItem item;

	public CoTWheelBlock(CoTWheelBuilder builder, ResourceLocation location) {
		super(builder.isLarge(location), builder.getBlockBuilder().getBlockProperties());
		this.setRegistryName(location);
		item = new CoTWheelItem(this, builder.getBlockBuilder().getItemProperties());
		blocks.add(this);
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

		out.add(new WriteableResourceTemplate(ResourceType.ASSETS,
			location, "models", "block").withTemplate(ResourceType.ASSETS,
			new ResourceLocation(CogwheelTweaker.MODID, "models/block/block_cogwheel")).setLocationProperty(location));

		out.add(new WriteableResourceTemplate(ResourceType.ASSETS,
			location, "blockstates").withTemplate(ResourceType.ASSETS,
			new ResourceLocation(CogwheelTweaker.MODID, "blockstates/block_cogwheel")).setLocationProperty(location));

		return out;
	}

	@Nonnull
	@Override
	public Collection<WriteableResource> getDataPackResources() {
		return Collections.singleton(new WriteableResourceLootTableItem(getRegistryNameNonNull()));
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new CoTWheelTileEntity();
	}
}
