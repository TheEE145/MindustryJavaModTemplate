package example;

import mindustry.game.EventType;

import arc.util.Time;
import arc.util.Log;

import net.tmmc.util.events.Events;
import net.tmmc.annotations.Mod;
import net.tmmc.ApplicationMod;
import net.tmmc.util.UIUtils;

@Mod
public class ExampleJavaMod extends ApplicationMod {
    //the code if you want to show exception in dialog
    //it`s can help modding when causes error
    //
    //static {
    //    Events.postDataRun = (data) -> {
    //        if(data.hasErrors()) data.causes().forEach(ThrowableUtils::showDialog);
    //    };
    //}

    public ExampleJavaMod() {
        Log.info("Loaded ExampleJavaMod constructor.");
        Events.register(EventType.ClientLoadEvent.class, () -> {
            var reg = this.atlas.createAnimation("frog", 108);
            reg.runTrigger(30f);

            Time.runTask(10f, () -> UIUtils.invoke("frog", table -> {
                table.add("behold").row();
                table.image(reg).pad(20f).size(108).row();
            }));

            //ImageBackgroundRender.pack(this.atlas.get("vietnam"));
        });
    }

    @Override
    public void loadContent() {
        Log.info("Loading some example content.");
        ExampleContent.load();
    }
}
