package com.insurgencedev.addons.rivalboosts;

import com.insurgencedev.addons.rivalboosts.listeners.RivalHoeEventListener;
import com.insurgencedev.addons.rivalboosts.listeners.RivalPickaxeEventListener;
import com.insurgencedev.addons.rivalboosts.listeners.RivalRodEventListener;
import com.insurgencedev.addons.rivalboosts.listeners.RivalSwordEventListener;
import org.insurgencedev.insurgencesets.api.addon.ISetsAddon;
import org.insurgencedev.insurgencesets.api.addon.InsurgenceSetsAddon;
import org.insurgencedev.insurgencesets.libs.fo.Common;

@ISetsAddon(name = "RivalBoostAddon", version = "1.0.1", author = "InsurgenceDev", description = "All-in-one tool boost")
public class RivalBoostsAddon extends InsurgenceSetsAddon {

    public static final String NAMESPACE = "RIVAL";

    @Override
    public void onAddonReloadablesStart() {
        if (Common.doesPluginExist("RivalPickaxes")) {
            registerEvent(new RivalPickaxeEventListener());
        }

        if (Common.doesPluginExist("RivalHarvesterHoes")) {
            registerEvent(new RivalHoeEventListener());
        }

        if (Common.doesPluginExist("RivalFishingRods")) {
            registerEvent(new RivalRodEventListener());
        }

        if (Common.doesPluginExist("RivalMobSwords")) {
            registerEvent(new RivalSwordEventListener());
        }
    }
}
