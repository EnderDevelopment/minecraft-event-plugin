package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("evento")) {
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("gamerule")) {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        openEventMenu(player);
                    } else {
                        sender.sendMessage(Component.text("Este comando só pode ser usado por jogadores.").color(NamedTextColor.RED));
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void openEventMenu(Player player) {
        Inventory menu = getServer().createInventory(null, 9, Component.text("Configurar Evento").color(NamedTextColor.GOLD));

        ItemStack breakBlocks = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta breakBlocksMeta = breakBlocks.getItemMeta();
        breakBlocksMeta.setDisplayName("Quebrar Blocos");
        breakBlocks.setItemMeta(breakBlocksMeta);
        menu.setItem(0, breakBlocks);

        ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta pvpMeta = pvp.getItemMeta();
        pvpMeta.setDisplayName("PvP");
        pvp.setItemMeta(pvpMeta);
        menu.setItem(1, pvp);

        player.openInventory(menu);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(Component.text("Configurar Evento").color(NamedTextColor.GOLD))) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.hasItemMeta()) {
                if (clickedItem.getItemMeta().getDisplayName().equals("Quebrar Blocos")) {
                    player.sendMessage(Component.text("Permissão de quebrar blocos configurada!").color(NamedTextColor.GREEN));
                } else if (clickedItem.getItemMeta().getDisplayName().equals("PvP")) {
                    player.sendMessage(Component.text("Permissão de PvP configurada!").color(NamedTextColor.GREEN));
                }
            }
        }
    }
}