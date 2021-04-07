package mod.grimmauld.cogwheeltweaker.cogwheel;

import com.blamejared.contenttweaker.VanillaFactory;
import com.blamejared.contenttweaker.api.blocks.BlockTypeBuilder;
import com.blamejared.contenttweaker.blocks.BlockBuilder;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
@ZenRegister(modDeps = {"contenttweaker"})
@ZenCodeType.Name("mods.cogweeltweaker.block.cogwheel.CoTWheelBuilder")
public class CoTWheelBuilder extends BlockTypeBuilder {
	private boolean large;
	private boolean noTemplate;
	@Nullable
	private ResourceLocation topTexture;
	@Nullable
	private ResourceLocation legacyTexture;

	public CoTWheelBuilder(BlockBuilder blockBuilder) {
		super(blockBuilder);
	}

	public boolean isLegacyModel() {
		return topTexture != null && legacyTexture != null ;
	}

	@Override
	public void build(ResourceLocation resourceLocation) {
		VanillaFactory.queueBlockForRegistration(new CoTWheelBlock(this, resourceLocation));
	}

	public boolean isLarge() {
		return large;
	}

	public boolean hasNoTemplate() {
		return noTemplate;
	}

	@Nullable
	public ResourceLocation getTopTexture() {
		return topTexture;
	}

	@Nullable
	public ResourceLocation getLegacyTexture() {
		return legacyTexture;
	}

	@ZenCodeType.Method
	public CoTWheelBuilder withLarge(boolean large) {
		this.large = large;
		return this;
	}

	@ZenCodeType.Method
	public CoTWheelBuilder noTemplate() {
		this.noTemplate = true;
		return this;
	}

	@ZenCodeType.Method
	public CoTWheelBuilder withLegacyTexture(String legacyTexture, String topTexture) {
		this.topTexture = new ResourceLocation(topTexture);
		this.legacyTexture = new ResourceLocation(legacyTexture);
		return this;
	}

	@ZenCodeType.Method
	public CoTWheelBuilder withLegacyTexture(String legacyTexture) {
		return withLegacyTexture(legacyTexture, legacyTexture + "_top");
	}
}
