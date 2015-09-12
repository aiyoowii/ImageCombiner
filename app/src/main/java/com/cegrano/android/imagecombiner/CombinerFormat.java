package com.cegrano.android.imagecombiner;

import java.util.List;

/**
 * Created by cegrano on 15/8/31.
 */
public class CombinerFormat {
    public int columnCount;
    public int rowCount;
    public String backgroundURI;
    public List<CombinerImage> images;

    public static class CombinerImage {
        public int column;
        public int row;
        public int columnSpan;
        public int rowSpan;
        public String imageURI;
        public float rotate;
        public String borderURI;
    }

    public static String test=
            "[" +
                    "{\"columnCount\":1," +
            "\"rowCount\":1," +
            "\"images\":[" +
            "{" +
            "\"column\":0," +
            "\"row\":0," +
            "\"columnSpan\":1," +
            "\"rowSpan\":1," +
            "\"imageURI\":\"res://"+R.mipmap.bg_float_tip+"\"" +
            "}" +
            "]" +
            "}" +","+//next
                    "{\"columnCount\":3," +
                    "\"rowCount\":1," +
                    "\"images\":[" +
                    "{" +
                    "\"column\":0," +
                    "\"row\":0," +
                    "\"columnSpan\":1," +
                    "\"rowSpan\":1," +
                    "\"imageURI\":\"res://"+R.mipmap.bg_float_tip+"\"" +
                    "}" +","+
                    "{" +
                    "\"column\":1," +
                    "\"row\":0," +
                    "\"columnSpan\":2," +
                    "\"rowSpan\":1," +
                    "\"imageURI\":\"res://"+R.mipmap.bg_float_tip+"\"" +
                    "}" +
                    "]" +
                    "}" +","+//next
                    "{\"columnCount\":1," +
                    "\"rowCount\":2," +
                    "\"images\":[" +
                    "{" +
                    "\"column\":0," +
                    "\"row\":0," +
                    "\"columnSpan\":1," +
                    "\"rowSpan\":1," +
                    "\"imageURI\":\"res://"+R.mipmap.bg_float_tip+"\"" +
                    "}" + "," +
                    "{" +
                    "\"column\":0," +
                    "\"row\":1," +
                    "\"columnSpan\":1," +
                    "\"rowSpan\":1," +
                    "\"imageURI\":\"res://"+R.mipmap.bg_float_tip+"\"" +
                    "}" +
                    "]" +
                    "}" +","+//next
                    "{\"columnCount\":10," +
                    "\"rowCount\":5," +
                    "\"images\":[" +
                    "{" +
                    "\"column\":0," +
                    "\"row\":0," +
                    "\"columnSpan\":10," +
                    "\"rowSpan\":3," +
                    "\"imageURI\":\"res://"+R.mipmap.bg_float_tip+"\"" +
                    "}" +","+
                    "{" +
                    "\"column\":0," +
                    "\"row\":3," +
                    "\"columnSpan\":3," +
                    "\"rowSpan\":2," +
                    "\"imageURI\":\"res://"+R.mipmap.bg_float_tip+"\"" +
                    "}" +","+
                    "{" +
                    "\"column\":3," +
                    "\"row\":3," +
                    "\"columnSpan\":7," +
                    "\"rowSpan\":2," +
                    "\"imageURI\":\"res://"+R.mipmap.bg_float_tip+"\"" +
                    "}" +
                    "]" +
                    "}" +
            "]";
}
