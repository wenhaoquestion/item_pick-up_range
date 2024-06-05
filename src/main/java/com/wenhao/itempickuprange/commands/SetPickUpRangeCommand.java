package com.wenhao.itempickuprange.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.server.network.ServerPlayerEntity;
import com.wenhao.itempickuprange.util.PlayerEntityAccess;

public class SetPickUpRangeCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("setPickupRange")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.argument("range", DoubleArgumentType.doubleArg(0.0))
                        .executes(context -> {
                            double range = DoubleArgumentType.getDouble(context, "range");
                            ServerCommandSource source = context.getSource();
                            ServerPlayerEntity player = source.getPlayer();
                            if (player != null) {
                                ((PlayerEntityAccess) player).setCustomPickupRange(range);
                                source.sendFeedback(new LiteralText("Pickup range set to " + range), true);
                            }
                            return 1;
                        })));
    }
}
