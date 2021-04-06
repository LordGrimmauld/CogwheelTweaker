package mod.grimmauld.cogwheeltweaker.cogwheel;

import com.blamejared.contenttweaker.VanillaFactory;
import com.blamejared.contenttweaker.api.blocks.BlockTypeBuilder;
import com.blamejared.contenttweaker.blocks.BlockBuilder;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
@ZenRegister(modDeps = {"contenttweaker"})
@ZenCodeType.Name("mods.cogweeltweaker.block.cogwheel.CoTWheelBuilder")
@Document("mods/cogweeltweaker/API/block/cogwheel/CoTWheelBuilder")
public class CoTWheelBuilder extends BlockTypeBuilder {
	private boolean large;
	private boolean noTemplate;
	@Nullable
	private String topTexture;
	@Nullable
	private String legacyTexture;
	@Nullable
	private String legacyModid;

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
	public String getTopTexture() {
		return topTexture;
	}

	@Nullable
	public String getLegacyTexture() {
		return legacyTexture;
	}

	@Nullable
	public String getLegacyModid() {
		return legacyModid;
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
	public CoTWheelBuilder withLegacyTexture(String modid, String legacyTexture, String topTexture) {
		this.legacyModid = modid;
		this.topTexture = topTexture;
		this.legacyTexture = legacyTexture;
		return this;
	}

	@ZenCodeType.Method
	public CoTWheelBuilder withLegacyTexture(String legacyTexture) {
		return withLegacyTexture("minecraft", legacyTexture, legacyTexture + "_top");
	}
}
