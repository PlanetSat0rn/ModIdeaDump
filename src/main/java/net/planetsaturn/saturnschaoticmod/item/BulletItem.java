
package net.planetsaturn.saturnschaoticmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BulletItem extends Item {
	public BulletItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.COMMON));
	}
}
