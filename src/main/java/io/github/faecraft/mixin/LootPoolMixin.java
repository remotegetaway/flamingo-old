package io.github.faecraft.mixin;

import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.LootPoolEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LootPool.class)
public interface LootPoolMixin {
    @Accessor("entries")
    LootPoolEntry[] getEntries();

    @Accessor("entries")
    void setEntries(LootPoolEntry[] entries);
}
