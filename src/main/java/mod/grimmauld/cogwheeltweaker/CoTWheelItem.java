package mod.grimmauld.cogwheeltweaker;

import com.blamejared.contenttweaker.ContentTweaker;
import com.blamejared.contenttweaker.api.items.IIsCotItem;
import com.blamejared.contenttweaker.api.resources.ResourceType;
import com.blamejared.contenttweaker.api.resources.WriteableResource;
import com.blamejared.contenttweaker.api.resources.WriteableResourceTemplate;
import com.simibubi.create.content.contraptions.relays.elementary.CogwheelBlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;

public class CoTWheelItem extends CogwheelBlockItem implements IIsCotItem {
	public CoTWheelItem(CoTWheelBlock blockIn, Item.Properties builder) {
		super(blockIn, builder);
		this.setRegistryName(blockIn.getRegistryNameNonNull());
	}

	@Nonnull
	@Override
	public Collection<WriteableResource> getResourcePackResources() {
		final ResourceLocation location = getRegistryNameNonNull();
		return Collections.singleton(new WriteableResourceTemplate(ResourceType.ASSETS, location,
			"models", "item").withTemplate(ResourceType.ASSETS,
			new ResourceLocation(ContentTweaker.MOD_ID, "models/item/item_block")).setLocationProperty(location));
	}

	@Nonnull
	@Override
	public Collection<WriteableResource> getDataPackResources() {
		return Collections.emptyList();
	}
}
