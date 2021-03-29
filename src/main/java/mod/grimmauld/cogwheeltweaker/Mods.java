package mod.grimmauld.cogwheeltweaker;

import net.minecraftforge.fml.ModList;

import java.util.function.Supplier;

public enum Mods {
	CONTENTTWEAKER;

	public boolean isLoaded() {
		return ModList.get().isLoaded(asId());
	}

	public String asId() {
		return name().toLowerCase();
	}

	public void runIfInstalled(Supplier<Runnable> toRun) {
		if (isLoaded())
			toRun.get().run();
	}
}
