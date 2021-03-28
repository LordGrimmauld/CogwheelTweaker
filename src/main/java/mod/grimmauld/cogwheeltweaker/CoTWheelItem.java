package mod.grimmauld.cogwheeltweaker;

import com.blamejared.contenttweaker.api.items.IIsCotItem;
import com.blamejared.contenttweaker.api.resources.*;
import com.simibubi.create.content.contraptions.relays.elementary.CogwheelBlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CoTWheelItem extends CogwheelBlockItem implements IIsCotItem {
	public CoTWheelItem(CoTWheelBlock blockIn, Item.Properties builder) {
		super(blockIn, builder);
		this.setRegistryName(blockIn.getRegistryNameNonNull());
	}

	@Nonnull
	@Override
	public Collection<WriteableResource> getResourcePackResources() {
		final ResourceLocation location = getRegistryNameNonNull();
		final List<WriteableResource> out = new ArrayList<>();
		out.add(WriteableResourceImage.noImage(ImageType.ITEM, location));
		final WriteableResourceTemplate modelTemplate = new WriteableResourceTemplate(ResourceType.ASSETS, location,
			"models", "item").withTemplate(ResourceType.ASSETS,
			new ResourceLocation(CogwheelTweaker.MODID, "models/item/item_block")).setLocationProperty(location);
		out.add(modelTemplate);
		return out;
	}

	@Nonnull
	@Override
	public Collection<WriteableResource> getDataPackResources() {
		return Collections.emptyList();
	}
}
