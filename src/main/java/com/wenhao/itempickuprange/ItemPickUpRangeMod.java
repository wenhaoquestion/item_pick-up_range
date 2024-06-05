package com.wenhao.itempickuprange;

import com.wenhao.itempickuprange.commands.SetPickUpRangeCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

public class ItemPickUpRangeMod implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            SetPickUpRangeCommand.register(dispatcher);
        });
    }
}
