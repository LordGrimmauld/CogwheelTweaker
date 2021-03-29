package mod.grimmauld.cogwheeltweaker;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public final class ObjectHolders {
	public ObjectHolders() {}

	@ObjectHolder("cogwheeltweaker:cotwheel")
	public static TileEntityType<CoTWheelTileEntity> COTWHEEL_TILE;
}
