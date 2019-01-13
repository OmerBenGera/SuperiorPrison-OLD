package xyz.wildseries.prison.tasks.player.mine;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.objects.mines.Region;
import xyz.wildseries.prison.setup.KeyItem;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.tasks.TaskFlag;
import xyz.wildseries.prison.tasks.player.PlayerTask;
import xyz.wildseries.prison.tasks.types.InteractTask;
import xyz.wildseries.prison.tasks.types.ScrollTask;

@Getter
public class RegionTask extends PlayerTask implements InteractTask, ScrollTask {

    private Region region;
    private ItemStack[] items;

    private Location a;
    private Location b;
    private World world;

    private int slot;

    public RegionTask(Region region, Prisoner prisoner) {
        super(prisoner);

        addFlags(TaskFlag.CANCEL_DROPS, TaskFlag.CANCEL_INVENTORY);

        this.region = region;

        items = prisoner.getPlayer().getInventory().getContents();
        prisoner.getPlayer().getInventory().clear();

        prisoner.getPlayer().getInventory().setItem(1, KeyItem.BTN_CANCEL.getItem());
        prisoner.getPlayer().getInventory().setItem(4, KeyItem.REGION_TOOL.getItem());
        prisoner.getPlayer().getInventory().setItem(7, KeyItem.BTN_CONFIRM.getItem());

        prisoner.getPlayer().getInventory().setHeldItemSlot(4);
        slot = 1;
    }

    @Override
    public void update() {

    }

    @Override
    public void end() {
        super.end();

        prisoner.getPlayer().getInventory().clear();
        prisoner.getPlayer().getInventory().setContents(items);
    }

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {

        event.setCancelled(true);

        if (event.getItem() == null || event.getItem().getType() == Material.AIR)
            return;

        KeyItem key = KeyItem.idenfiy(event.getItem());

        if (key == null)
            return;

        switch (key) {
            case BTN_CANCEL:
                Message.REGION_CANCEL.send(prisoner.getPlayer());
                end();
                break;
            case BTN_CONFIRM:
                if (a == null || b == null || world == null || a.equals(b) || !a.getWorld().equals(b.getWorld())) {
                    Message.REGION_FAILED.send(prisoner);
                    break;
                }

                region.setA(a.toVector());
                region.setB(b.toVector());
                region.setWorld(world);

                Message.REGION_CONFIRM.send(prisoner.getPlayer());
                end();
                break;
            case REGION_TOOL:

                if (event.getClickedBlock() == null || event.getClickedBlock().getType() == Material.AIR)
                    break;

                switch (event.getAction()) {
                    case LEFT_CLICK_BLOCK:
                        a = event.getClickedBlock().getLocation();
                        world = event.getClickedBlock().getLocation().getWorld();
                        Message.REGION_SET_POS.send(prisoner.getPlayer(), "number:1,location:" + blockToString(event.getClickedBlock()));
                        break;
                    case RIGHT_CLICK_BLOCK:
                        b = event.getClickedBlock().getLocation();
                        world = event.getClickedBlock().getLocation().getWorld();
                        Message.REGION_SET_POS.send(prisoner.getPlayer(), "number:2,location:" + blockToString(event.getClickedBlock()));
                        break;
                }

                break;
        }

    }

    @Override
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {

        event.setCancelled(true);

        if (event.getPreviousSlot() < event.getNewSlot())
            slot++;

        else if (event.getPreviousSlot() > event.getNewSlot())
            slot--;

        if (slot < 0)
            slot = 2;

        if (slot > 2)
            slot = 0;

        switch (slot) {
            case 0:
                prisoner.getPlayer().getInventory().setHeldItemSlot(1);
                break;
            case 1:
                prisoner.getPlayer().getInventory().setHeldItemSlot(4);
                break;
            case 2:
                prisoner.getPlayer().getInventory().setHeldItemSlot(7);
                break;
        }
    }

    private String blockToString(Block block) {
        Location location = block.getLocation();
        return location.getBlockX() + "/" + location.getBlockY() + "/" + location.getBlockZ();
    }

}
