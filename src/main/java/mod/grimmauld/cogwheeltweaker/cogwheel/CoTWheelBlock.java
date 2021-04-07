package mod.grimmauld.cogwheeltweaker.cogwheel;

import com.blamejared.contenttweaker.api.blocks.IIsCoTBlock;
import com.blamejared.contenttweaker.api.items.IIsCotItem;
import com.blamejared.contenttweaker.api.resources.*;
import com.simibubi.create.content.contraptions.relays.elementary.CogWheelBlock;
import mcp.MethodsReturnNonnullByDefault;
import mod.grimmauld.cogwheeltweaker.CogwheelTweaker;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.LazyValue;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CoTWheelBlock extends CogWheelBlock implements IIsCoTBlock {
	private final LazyValue<IIsCotItem> item;
	final CoTWheelBuilder builder;

	public CoTWheelBlock(CoTWheelBuilder builder, ResourceLocation location) {
		super(builder.isLarge(), builder.getBlockBuilder().getBlockProperties());
		this.setRegistryName(location);
		this.item = new LazyValue<>(() -> new CoTWheelItem(this, builder));
		this.builder = builder;
		CoTWheelTileEntity.validBlocks.add(this);
	}

	@Nonnull
	@Override
	public IIsCotItem getItem() {
		return item.getValue();
	}

	@Nonnull
	@Override
	public Collection<WriteableResource> getResourcePackResources() {
		final Collection<WriteableResource> out = new ArrayList<>();
		if (builder.hasNoTemplate())
			return out;

		final ResourceLocation location = getRegistryNameNonNull();
		if (!builder.isLegacyModel())
			out.add(WriteableResourceImage.noImage(ImageType.BLOCK, location));

		if (builder.isLegacyModel()) {
			out.add(new WriteableResourceTemplate(ResourceType.ASSETS,
				location, "models", "block").withTemplate(ResourceType.ASSETS,
				new ResourceLocation(CogwheelTweaker.MODID, isLargeCog() ? "models/block/block_legacy_large_cogwheel"
					: "models/block/block_legacy_cogwheel"))
				.setProperty("NAMESPACE", builder.getLegacyTexture().getNamespace())
				.setProperty("PATH", builder.getLegacyTexture().getPath())
				.setProperty("NAMESPACE_TOP", builder.getTopTexture().getNamespace())
				.setProperty("PATH_TOP", builder.getTopTexture().getPath()));

		} else {
			out.add(new WriteableResourceTemplate(ResourceType.ASSETS,
				location, "models", "block").withTemplate(ResourceType.ASSETS,
				new ResourceLocation(CogwheelTweaker.MODID, isLargeCog() ? "models/block/block_large_cogwheel" : "models/block/block_cogwheel")).setLocationProperty(location));
		}
		out.add(new WriteableResourceTemplate(ResourceType.ASSETS,
			location, "blockstates").withTemplate(ResourceType.ASSETS,
			new ResourceLocation(CogwheelTweaker.MODID, "blockstates/block_cogwheel")).setLocationProperty(location));

		return out;
	}



	@Nonnull
	@Override
	public Collection<WriteableResource> getDataPackResources() {
		return builder.hasNoTemplate() ? Collections.emptyList() : Collections.singleton(new WriteableResourceLootTableItem(getRegistryNameNonNull()));
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new CoTWheelTileEntity();
	}
}
