package mod.grimmauld.cogwheeltweaker.util;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister(modDeps = {"contenttweaker"})
@ZenCodeType.Name("mods.cogweeltweaker.util.StringUtil")
@SuppressWarnings("unused")
public class StringUtil {
	@ZenCodeType.Method
	public static String remove(String string, String pattern) {
		return string.replaceAll(pattern, "");
	}

	@ZenCodeType.Method
	public static boolean modLoaded(String string) {
		String modid = new ResourceLocation(string).getNamespace();
		return modid.equals("minecraft") || ModList.get().isLoaded(modid);
	}
}
