package com.insurgencedev.addons.rivalboosts.listeners;

import com.insurgencedev.addons.rivalboosts.RivalBoostsAddon;
import com.insurgencedev.addons.rivalboosts.utils.AddonUtil;
import me.rivaldev.fishingrod.rivalfishingrods.api.RodEssenceReceiveEvent;
import me.rivaldev.fishingrod.rivalfishingrods.api.RodXPGainEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class RivalRodEventListener implements Listener {

    @EventHandler
    private void onReceive(RodEssenceReceiveEvent event) {
        AddonUtil.getMulti(event.getPlayer(), "Essence", RivalBoostsAddon.NAMESPACE, (found, multi) -> {
            if (found) {
                event.setEssence(AddonUtil.calculateAmount(event.getEssence(), multi));
            }
        });
    }

    @EventHandler
    private void onGain(RodXPGainEvent event) {
        AddonUtil.getMulti(event.getPlayer(), "Tool XP", RivalBoostsAddon.NAMESPACE, (found, multi) -> {
            if (found) {
                event.setXP(AddonUtil.calculateAmount(event.getXP(), multi));
            }
        });
    }
}
