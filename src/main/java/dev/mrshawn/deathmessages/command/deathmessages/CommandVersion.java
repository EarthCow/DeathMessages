package dev.mrshawn.deathmessages.command.deathmessages;

import dev.mrshawn.deathmessages.DeathMessages;
import dev.mrshawn.deathmessages.enums.Permission;
import dev.mrshawn.deathmessages.utils.Assets;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.command.CommandSender;
import org.minidns.record.A;

public class CommandVersion extends DeathMessagesCommand {


	@Override
	public String command() {
		return "version";
	}

	@Override
	public void onCommand(CommandSender sender, String[] args) {
		if (!sender.hasPermission(Permission.DEATHMESSAGES_COMMAND_VERSION.getValue())) {
			sender.sendMessage(Assets.convertLegacy(Assets.formatMessage("Commands.DeathMessages.No-Permission")));
			return;
		}
		String message = Assets.formatMessage("Commands.DeathMessages.Sub-Commands.Version");
		message = message
				.replaceAll("%version%", DeathMessages.getInstance().getDescription().getVersion())
				.replaceAll("%authors%", DeathMessages.getInstance().getDescription().getAuthors().toString());
		sender.sendMessage(Assets.convertLegacy(message));
	}
}