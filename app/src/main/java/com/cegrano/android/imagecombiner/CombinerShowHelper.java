package com.cegrano.android.imagecombiner;

import android.net.Uri;
import android.support.percent.PercentFrameLayout;
import android.support.percent.PercentLayoutHelper;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by cegrano on 15/8/31.
 */
public class CombinerShowHelper {
    public static void draw(GridLayout gridLayout,CombinerFormat combinerFormat) {
        gridLayout.removeAllViews();
        gridLayout.setColumnCount(combinerFormat.columnCount);
        gridLayout.setRowCount(combinerFormat.rowCount);
        gridLayout.setUseDefaultMargins(true);
        for (CombinerFormat.CombinerImage image:combinerFormat.images) {
            View view = View.inflate(gridLayout.getContext(),R.layout.layout_image,null);
            ImageView draweeView = (ImageView) view.findViewById(R.id.iv_feed_image_big);
//            if (TextUtils.isEmpty(image.imageURI))
//                draweeView.setImageURI(Uri.parse("res://" + R.mipmap.bg_float_tip));
//            else
//            draweeView.setImageURI(Uri.parse(image.imageURI));
            draweeView.setLayoutParams(new ViewGroup.LayoutParams(image.columnSpan/combinerFormat.columnCount*50,
                    image.row/combinerFormat.rowCount*50));
            draweeView.setImageResource(R.mipmap.bg_float_tip);
            // 指定行
            GridLayout.Spec rowSpec = GridLayout.spec(image.row,image.rowSpan);
            // 指定列
            GridLayout.Spec columnSpec = GridLayout.spec(image.column,image.columnSpan);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(
                    rowSpec , columnSpec);
//            params.height = image.row/combinerFormat.rowCount*50;
//            params.width = image.columnSpan/combinerFormat.columnCount*50;
            // 指定该组件占满父容器
            params.setGravity(Gravity.FILL);
            gridLayout.addView(view , params);
//            gridLayout.addView(view,image.columnSpan/combinerFormat.columnCount*400,
//                    image.row/combinerFormat.rowCount*400);
        }
    }

    public static void draw(PercentFrameLayout gridLayout,CombinerFormat combinerFormat) {
        gridLayout.removeAllViews();
//        gridLayout.setColumnCount(combinerFormat.columnCount);
//        gridLayout.setRowCount(combinerFormat.rowCount);
//        gridLayout.setUseDefaultMargins(true);
        for (CombinerFormat.CombinerImage image:combinerFormat.images) {
            View view = View.inflate(gridLayout.getContext(),R.layout.layout_image,null);
            SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.iv_feed_image_big);
//            if (TextUtils.isEmpty(image.imageURI))
                draweeView.setImageURI(Uri.parse("res:///" + R.mipmap.bg_float_tip));
//            else
//            draweeView.setImageURI(Uri.parse(image.imageURI));
            PercentFrameLayout.LayoutParams source = new PercentFrameLayout.LayoutParams(image.columnSpan/combinerFormat.columnCount*200,
                    image.row/combinerFormat.rowCount*200);
//            draweeView.setLayoutParams(new ViewGroup.LayoutParams(image.columnSpan/combinerFormat.columnCount*50,
//                    image.row/combinerFormat.rowCount*50));
//            draweeView.setImageResource(R.mipmap.bg_float_tip);
            PercentLayoutHelper.PercentLayoutInfo info = source.getPercentLayoutInfo();
            info.leftMarginPercent = image.column*1.0f/combinerFormat.columnCount;
            info.topMarginPercent = image.row*1.0f/combinerFormat.rowCount;
            info.widthPercent = image.columnSpan*1.0f/combinerFormat.columnCount;
            info.heightPercent = image.rowSpan*1.0f/combinerFormat.rowCount;
            // 指定行
//            GridLayout.Spec rowSpec = GridLayout.spec(image.row,image.rowSpan);
//            // 指定列
//            GridLayout.Spec columnSpec = GridLayout.spec(image.column,image.columnSpan);
//            GridLayout.LayoutParams params = new GridLayout.LayoutParams(
//                    rowSpec , columnSpec);
////            params.height = image.row/combinerFormat.rowCount*50;
////            params.width = image.columnSpan/combinerFormat.columnCount*50;
//            // 指定该组件占满父容器
//            params.setGravity(Gravity.FILL);
            gridLayout.addView(view , source);
//            gridLayout.addView(view,image.columnSpan/combinerFormat.columnCount*400,
//                    image.row/combinerFormat.rowCount*400);
        }
    }
}
