package jp.ac.meijou.android.yuuicnak;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public record ListItem(Drawable image, String description, Class<? extends Activity> activity) {
    public void startActivity(Context context) {
        context.startActivity(new Intent(context, activity));
    }
}
