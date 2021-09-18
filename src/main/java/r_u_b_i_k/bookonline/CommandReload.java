package r_u_b_i_k.bookonline;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandReload implements CommandExecutor {

    private BookOnline plugin;

    public CommandReload(BookOnline plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("book.reload")) {
            sender.sendMessage(plugin.getConfig().getString("messages.commands.donthaveperrm").replace("&","§"));
            return true;
        }
        plugin.reloadConfig();
        sender.sendMessage(plugin.getConfig().getString("messages.commands.reload").replace("&","§"));
        return true;
    }
}