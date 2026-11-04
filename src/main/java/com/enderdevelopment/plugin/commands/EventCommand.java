package com.enderdevelopment.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class EventCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Component.text("Este comando só pode ser usado por jogadores.").color(NamedTextColor.RED));
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(Component.text("Uso: /evento <criar|iniciar|finalizar>").color(NamedTextColor.RED));
            return true;
        }

        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "criar":
                player.sendMessage(Component.text("Evento criado com sucesso!").color(NamedTextColor.GREEN));
                break;
            case "iniciar":
                player.sendMessage(Component.text("Evento iniciado!").color(NamedTextColor.GREEN));
                break;
            case "finalizar":
                player.sendMessage(Component.text("Evento finalizado!").color(NamedTextColor.GREEN));
                break;
            default:
                player.sendMessage(Component.text("Subcomando inválido. Use: criar, iniciar ou finalizar").color(NamedTextColor.RED));
                break;
        }

        return true;
    }
}