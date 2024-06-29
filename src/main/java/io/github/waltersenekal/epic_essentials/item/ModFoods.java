package io.github.waltersenekal.epic_essentials.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties ORANGE =
            new FoodProperties.Builder()
                .nutrition(10)
                .saturationModifier(20.0f)
                .alwaysEdible()
                .effect(new MobEffectInstance(MobEffects.JUMP,5*20,3),1).build();

    public static final FoodProperties DRIED_ORANGE =
            new FoodProperties.Builder()
                    .nutrition(40)
                    .saturationModifier(100.0f)
                    .alwaysEdible()
                    .effect(new MobEffectInstance(MobEffects.LUCK,5*20,3),1).build();
}
