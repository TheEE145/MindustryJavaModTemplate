package example;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;

public class ExampleContent {
    public static Block block1, block2;

    public static void load() {
        block1 = new Block("example-block") {{
            this.requirements(Category.defense, ItemStack.empty);
        }};

        block2 = new Block("example-block2") {{
            this.requirements(Category.defense, ItemStack.empty);
        }};
    }
}