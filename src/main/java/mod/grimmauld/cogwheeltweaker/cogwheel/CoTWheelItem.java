package mod.grimmauld.cogwheeltweaker.cogwheel;

import com.blamejared.contenttweaker.ContentTweaker;
import com.blamejared.contenttweaker.api.items.IIsCotItem;
import com.blamejared.contenttweaker.api.resources.ResourceType;
import com.blamejared.contenttweaker.api.resources.WriteableResource;
import com.blamejared.contenttweaker.api.resources.WriteableResourceTemplate;
import com.simibubi.create.content.contraptions.relays.elementary.CogwheelBlockItem;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;

public class CoTWheelItem extends CogwheelBlockItem implements IIsCotItem {
	public CoTWheelItem(CoTWheelBlock blockIn, CoTWheelBuilder builder) {
		super(blockIn, builder.getBlockBuilder().getItemProperties());
		this.setRegistryName(blockIn.getRegistryNameNonNull());
	}

	@Nonnull
	@Override
	public Collection<WriteableResource> getResourcePackResources() {
		return ((CoTWheelBlock) getBlock()).builder.hasNoTemplate() ? Collections.emptyList() :
			Collections.singleton(new WriteableResourceTemplate(ResourceType.ASSETS, getRegistryNameNonNull(),
			"models", "item").withTemplate(ResourceType.ASSETS,
			new ResourceLocation(ContentTweaker.MOD_ID, "models/item/item_block")).setLocationProperty(getRegistryNameNonNull()));
	}

	@Nonnull
	@Override
	public Collection<WriteableResource> getDataPackResources() {
		return Collections.emptyList();
	}
}
