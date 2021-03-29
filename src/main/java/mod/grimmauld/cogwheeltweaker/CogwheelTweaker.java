package mod.grimmauld.cogwheeltweaker;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CogwheelTweaker.MODID)
public class CogwheelTweaker {
	public static final String MODID = "cogwheeltweaker";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public CogwheelTweaker() {
		Mods.CONTENTTWEAKER.runIfInstalled(() -> () -> ContenttweakerCompat.registerEvents(MinecraftForge.EVENT_BUS));
	}
}
