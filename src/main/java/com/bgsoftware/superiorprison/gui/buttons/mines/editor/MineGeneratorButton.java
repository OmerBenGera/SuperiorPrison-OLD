package com.bgsoftware.superiorprison.gui.buttons.mines.editor;


import com.bgsoftware.superiorprison.gui.buttons.mines.MineButton;
import com.bgsoftware.superiorprison.gui.menus.types.mines.GeneratorEditor;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MineEditor;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MineGeneratorButton extends MineButton {

    public MineGeneratorButton(MineEditor menu) {
        super(menu, menu.getMine(), ItemUtils.build(XMaterial.COMMAND_BLOCK, "§e§lGenerator", "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new GeneratorEditor(menu.getPlayer(), mine).open();
    }
}
