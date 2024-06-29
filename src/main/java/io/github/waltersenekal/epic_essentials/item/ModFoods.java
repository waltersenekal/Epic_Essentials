package io.github.waltersenekal.epic_essentials.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties ORANGE =
            new FoodProperties.Builder()
                .nutrition(100)
                .saturationModifier(100.0f)
                .alwaysEdible()
                .effect(new MobEffectInstance(MobEffects.JUMP,5*20,30),1).build();
}
