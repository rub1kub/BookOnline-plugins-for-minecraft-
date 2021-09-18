package r_u_b_i_k.bookonline;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class EventListener implements Listener {

    private BookOnline plugin;
    EventListener(BookOnline plugin){
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent e) {
        Inventory inv = e.getInventory();
        Inventory invP = e.getPlayer().getInventory();
        if (inv != null) {
            this.refreshInventory(inv);
        }

        if (invP != null) {
            this.refreshInventory(invP);
        }

    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e) {
        Inventory inv = e.getWhoClicked().getInventory();
        if (inv != null) {
            this.refreshInventory(inv);
        }

    }

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent e) {
        Inventory inv = e.getPlayer().getInventory();
        if (inv != null) {
            this.refreshInventory(inv);
        }

    }

    public void refreshInventory(Inventory inv) {
        ItemStack[] items = inv.getContents();

        for(int i = 0; items.length != i; ++i) {
            if (items[i] != null && items[i].getType() == Material.WRITTEN_BOOK) {
                this.changeAuthor(items[i]);
            }
        }

    }

    public void changeAuthor(ItemStack item) {
        String online = plugin.getConfig().getString("messages.events.online"); //"&a(в сети)";
        String offline = plugin.getConfig().getString("messages.events.offline");
        BookMeta book = (BookMeta)item.getItemMeta();
        if (book != null) {
            if (book.getAuthor() != null) {
                String author = book.getAuthor().split(" ")[0];
                Player p = Bukkit.getPlayer(author);
                if (p != null) {
                    book.setAuthor(BookOnline.getInstance().getMessageColor(author + " " + online));
                } else {
                    book.setAuthor(BookOnline.getInstance().getMessageColor(author + " " + offline));
                }

                item.setItemMeta(book);
            }
        }
    }
}