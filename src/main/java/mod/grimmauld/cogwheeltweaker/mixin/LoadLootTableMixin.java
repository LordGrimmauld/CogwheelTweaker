package mod.grimmauld.cogwheeltweaker.mixin;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mod.grimmauld.cogwheeltweaker.CogwheelTweaker;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.crafting.CraftingHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ForgeHooks.class)
public class LoadLootTableMixin {
	private LoadLootTableMixin() {}

	@Inject(at = @At(value = "INVOKE"), method = {"loadLootTable"}, remap = false, cancellable = true)
	private static void loadLootTableMixin(Gson gson, ResourceLocation name, JsonElement data, boolean custom, LootTableManager lootTableManager, CallbackInfoReturnable<LootTable> cir) {
		JsonObject jsonObject = data.getAsJsonObject();
		if (jsonObject.has("conditions") && !CraftingHelper.processConditions(JSONUtils.getAsJsonArray(jsonObject, "conditions"))) {
			cir.setReturnValue(LootTable.EMPTY);
			CogwheelTweaker.LOGGER.debug("Skipping load of loot table {} as conditions weren't met", name);
		}
	}
}