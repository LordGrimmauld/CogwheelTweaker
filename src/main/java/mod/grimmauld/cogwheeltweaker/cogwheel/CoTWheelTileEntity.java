package mod.grimmauld.cogwheeltweaker.cogwheel;

import com.simibubi.create.content.contraptions.relays.elementary.SimpleKineticTileEntity;
import mod.grimmauld.cogwheeltweaker.ObjectHolders;
import net.minecraft.block.Block;

import java.util.HashSet;
import java.util.Set;

public class CoTWheelTileEntity extends SimpleKineticTileEntity {
	public static final Set<Block> validBlocks = new HashSet<>();

	public CoTWheelTileEntity() {
		super(ObjectHolders.COTWHEEL_TILE);
	}
}
