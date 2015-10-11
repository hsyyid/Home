package io.github.hsyyid.spongeessentialcmds.listeners;

import io.github.hsyyid.spongeessentialcmds.Main;
import io.github.hsyyid.spongeessentialcmds.utils.Powertool;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.InteractEntityEvent;

public class PlayerClickListener
{
	@Listener
	public void onPlayerRightClick(InteractEntityEvent.Secondary event)
	{
		if (event.getCause().first(Player.class).isPresent())
		{
			Player player = event.getCause().first(Player.class).get();
			Powertool foundTool = null;

			for (Powertool powertool : Main.powertools)
			{
				if (powertool.getPlayer().equals(player))
				{
					if (player.getItemInHand().isPresent() && powertool.getItemID().equals(player.getItemInHand().get().getItem().getName()))
					{
						foundTool = powertool;
						break;
					}
				}
			}

			if (foundTool != null)
			{
				Main.game.getCommandDispatcher().process(player, foundTool.getCommand());
			}
		}
	}

	@Listener
	public void onPlayerLeftClick(InteractEntityEvent.Primary event)
	{
		if (event.getCause().first(Player.class).isPresent())
		{
			Player player = event.getCause().first(Player.class).get();
			Powertool foundTool = null;

			for (Powertool powertool : Main.powertools)
			{
				if (powertool.getPlayer().equals(player))
				{
					if (player.getItemInHand().isPresent() && powertool.getItemID().equals(player.getItemInHand().get().getItem().getName()))
					{
						foundTool = powertool;
						break;
					}
				}
			}

			if (foundTool != null)
			{
				Main.game.getCommandDispatcher().process(player, foundTool.getCommand());
			}
		}
	}
}