package mod.grimmauld.cogwheeltweaker.cogwheel;

import com.blamejared.contenttweaker.VanillaFactory;
import com.blamejared.contenttweaker.api.blocks.BlockTypeBuilder;
import com.blamejared.contenttweaker.blocks.BlockBuilder;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.util.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.function.Function;

@SuppressWarnings("unused")
@ZenRegister(modDeps = {"contenttweaker"})
@ZenCodeType.Name("mods.cogweeltweaker.block.cogwheel.CoTWheelBuilder")
@Document("mods/cogweeltweaker/API/block/cogwheel/CoTWheelBuilder")
public class CoTWheelBuilder extends BlockTypeBuilder {
	private Function<ResourceLocation, Boolean> large;
	private Function<ResourceLocation, Boolean> noTemplate;

	public CoTWheelBuilder(BlockBuilder blockBuilder) {
		super(blockBuilder);
		large = rl -> false;
		noTemplate = rl -> false;
	}

	@Override
	public void build(ResourceLocation resourceLocation) {
		VanillaFactory.queueBlockForRegistration(new CoTWheelBlock(this, resourceLocation));
	}

	public boolean isLarge(ResourceLocation name) {
		return large.apply(name);
	}

	public boolean hasNoTemplate(ResourceLocation name) {
		return noTemplate.apply(name);
	}

	@ZenCodeType.Method
	public CoTWheelBuilder withLarge(boolean large) {
		this.large = rl -> large;
		return this;
	}

	@ZenCodeType.Method
	public CoTWheelBuilder withLarge(Function<ResourceLocation, Boolean> large) {
		this.large = large;
		return this;
	}

	@ZenCodeType.Method
	public CoTWheelBuilder noTemplate() {
		this.noTemplate = rl -> true;
		return this;
	}
}
