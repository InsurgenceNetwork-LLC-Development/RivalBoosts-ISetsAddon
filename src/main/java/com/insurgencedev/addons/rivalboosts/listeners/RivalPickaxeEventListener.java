package com.insurgencedev.addons.rivalboosts.listeners;

import com.insurgencedev.addons.rivalboosts.RivalBoostsAddon;
import com.insurgencedev.addons.rivalboosts.utils.AddonUtil;
import me.rivaldev.pickaxes.api.events.PickaxeEssenceReceiveEnchantEvent;
import me.rivaldev.pickaxes.api.events.PickaxeXPGainEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class RivalPickaxeEventListener implements Listener {

    @EventHandler
    private void onReceive(PickaxeEssenceReceiveEnchantEvent event) {
        AddonUtil.getMulti(event.getPlayer(), "Essence", RivalBoostsAddon.NAMESPACE, (found, multi) -> {
            if (found) {
                event.setEssence(AddonUtil.calculateAmount(event.getEssence(), multi));
            }
        });
    }

    @EventHandler
    private void onReceive(PickaxeXPGainEvent event) {
        AddonUtil.getMulti(event.getPlayer(), "Tool XP", RivalBoostsAddon.NAMESPACE, (found, multi) -> {
            if (found) {
                event.setXP(AddonUtil.calculateAmount(event.getXP(), multi));
            }
        });
    }
}
