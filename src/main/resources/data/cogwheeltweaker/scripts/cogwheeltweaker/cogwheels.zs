#loader contenttweaker

import mods.contenttweaker.block.BlockBuilder;
import mods.cogweeltweaker.block.cogwheel.CoTWheelBuilder;

	
new BlockBuilder()
	.withType<CoTWheelBuilder>()
    .build("brass_cog");
	
new BlockBuilder()
	.withType<CoTWheelBuilder>()
    .build("andesite_cog");