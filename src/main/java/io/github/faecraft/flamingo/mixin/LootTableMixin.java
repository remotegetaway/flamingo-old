package io.github.faecraft.flamingo.mixin;

import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LootTable.class)
public interface LootTableMixin {
    @Accessor("pools")
    LootPool[] getPools();

    @Accessor("pools")
    void setPools(LootPool[] pools);
}
