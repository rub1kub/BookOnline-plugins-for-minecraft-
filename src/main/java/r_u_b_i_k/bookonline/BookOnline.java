package r_u_b_i_k.bookonline;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class BookOnline extends JavaPlugin implements Listener {
    final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    private static BookOnline instance;
    String version = "1.0";

    public void onEnable() {
        instance = this;
        this.console.sendMessage(this.getMessageColor("\n \n&8[]=====[&aEnabling BookOnline&8]=====[]\n&8| &cInformation:\n&8|   &cName: &aBookOnline\n&8|   &cDeveloper: &aR_u_B_i_K / SlimeStudio\n&8|   &cVersion: &a" + this.getVersion() + "\n&8[]======================================[]&r\n "));
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
    }

    public void onDisable() {
        this.console.sendMessage(this.getMessageColor("\n \n&8[]=====[&aDisabling BookOnline&8]=====[]\n&8| &cInformation:\n&8|   &cName: &aBookOnline\n&8|   &cDeveloper: &aR_u_B_i_K / SlimeStudio\n&8|   &cVersion: &a" + this.getVersion() + "\n&8[]======================================[]&r\n "));
    }

    public void refreshInventory(Inventory inv) {
    }

    public String getVersion() {
        return this.version;
    }

    public String getMessageColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static BookOnline getInstance() {
        return instance;
    }
}