package com.versuch.aufgabe.util;

public class Color {

    public static String getColor(String strColorCode){
        String color;
        int colorCode = Integer.parseInt(strColorCode);

        if (colorCode == 1) color = "blau";
        else if (colorCode == 2) color = "grün";
        else if (colorCode == 3) color = "violett";
        else if (colorCode == 4) color = "rot";
        else if (colorCode == 5) color = "gelb";
        else if (colorCode == 6) color = "türkis";
        else color = "weiß";

        return color;
    }

}
