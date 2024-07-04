package io.github.waltersenekal.epic_essentials.data.texture;

import io.github.waltersenekal.epic_essentials.EpicEssentials;
import io.github.waltersenekal.epic_essentials.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemStateProvider extends ItemModelProvider {
    public ModItemStateProvider(PackOutput output,ExistingFileHelper existingFileHelper) {
        super(output, EpicEssentials.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(ModItems.ORANGE.get());
        item(ModItems.DRIED_ORANGE.get());
        item(ModItems.TEMPERED_IRON_INGOT.get());
    }

    private void item(Item item){
        String name = getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/" + name);
    }
    private String getItemName(Item item){
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(EpicEssentials.MODID + ":","");
    }
}
