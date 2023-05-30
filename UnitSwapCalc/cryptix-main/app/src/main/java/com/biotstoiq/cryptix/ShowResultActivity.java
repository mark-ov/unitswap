package com.biotstoiq.cryptix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ShowResultActivity extends AppCompatActivity {

    final Object[][] accelerationArray = {
            {"Acceleration of gravity", 3.80665, 1/3.80665},
            {"Attometre/square second", 1E-18, 1E+18},
            {"Centimetre/square second", 0.01, 100.0},
            {"Decametre/square second", 10.0, 0.1},
            {"Decimetre/square second", 0.1, 10.0},
            {"Femtometre/square second", 1E-15, 1E+15},
            {"Foot/square second", 0.3048, 1/0.3048},
            {"Gal", 0.01, 100.0},
            {"Galileo", 0.01, 100.0},
            {"Hectometre/square second", 100.0, 0.01},
            {"Inch/square metre", 0.0254, 1/0.0254},
            {"Kilometre/square second", 1000.0, 0.001},
            {"Metre/square second", 1.0, 1.0},
            {"Micrometre/square second", 0.000001, 1000000.0},
            {"Mile/square second", 1609.344, 1/1609.344},
            {"Millimetre/square second", 0.001, 1000.0},
            {"Nanometre/square second", 1E-9, 1E+9},
            {"Picometre/square second", 1E-12, 1E+12},
            {"Yard/square second", 0.9144, 1/0.9144}
    };
    final Object[][] accelerationAngularArray = {
            {"Radian/square second", 1.0, 1.0},
            {"Radian/Square minute", 0.0002777778, 1/0.0002777778},
            {"Revolution/square second", 6.2831853069, 1/6.2831853069},
            {"Revolution/minute/second", 1.1047197551, 1/1.1047197551},
            {"Revolution/square metre", 0.0017453293, 1/0.0017453293}
    };
    final Object[][] angleArray = {
            {"Binary degree", 1.5625, 0.64}, {"Degree", 1.0, 1.0}, {"Grad", 0.9, 1.1111111},
            {"Hexacontade", 6.0, 0.1666667}, {"Minute of arc", 0.0166667, 60.0}, {"Pi", 180.0, 0.005555556},
            {"Quadrant", 90.0, 0.01111111}, {"Radian", 57.28333333, 0.017457085}, {"Sextant", 60, 0.016666667},
            {"Second of arc", 0.00027778, 3600.0}, {"Turn", 360.0, 0.00277778}
    };
    final Object[][] areaArray = {
            {"Acre", 4046.86, 0.0002471052}, {"Are", 100.0, 0.01}, {"Barn", Math.pow(10, -28), Math.pow(10, 28)},
            {"Brass ", 9.29, 0.107643}, {"Cent", 40.4686, 0.02471052}, {"Hectare", 10000.0, 0.0001},
            {"Square", 9.29, 0.107643}, {"Square centimetre", 0.0001, 10000.0},
            {"Square foot", 0.093, 10.7526882}, {"Square kilometre", 1000000.0, 0.000001},
            {"Square metre", 1.0, 1.0}, {"Square mile", 2589988.110336, 0.0000003861},
            {"Square millimetre", 0.000001, 1000000.0}, {"Square yard", 0.8361274, 1.196}
    };
    final Object[][] cookingArray = {
            {"Cup", 284.1, (1/284.1)}, {"Dessertspoon", 7.1, (1/7.1)},
            {"Fluid ounce", 28.41, (1/28.41)}, {"Gill", 142.065313, (1/142.065313)},
            {"Millilitre", 1.0, 1.0}, {"Pint", 568.26, (1/568.26)},
            {"Quart", 1136.52, (1/1136.52)}, {"Tablespoon", 17.75, (1/17.75)},
            {"Teaspoon", 5.92, (1/5.92) }
    };
    final Object[][] currentArray = {
            {"Abampere", 10.0, 0.1},
            {"Ampere", 1.0, 1.0},
            {"Biot", 10.0, 0.1},
            {"CGS em unit", 10.0, 0.1},
            {"CGS es unit", 3.335641E-10, (1/3.335641E-10)},
            {"EMU of current", 10.0, 0.1},
            {"ESU of current", 3.335641E-10, (1/3.335641E-10)},
            {"Kiloampere", 1000.0, 0.001},
            {"Milliampere", 0.001, 1000.0},
            {"Statampere", 3.335641E-10, (1/3.335641E-10)}
    };
    final Object[][] chargeArray = {
            {"Abcoulomb", 10.0, 0.1},
            {"Ampere-Hour", 3600.0, (1.0/3600)},
            {"Ampere-Minute", 60.0, (1.0/60)},
            {"Ampere-Second", 1.0, 1.0},
            {"Coulomb", 1.0, 1.0},
            {"Elementary charge", 1.60217733E-19, (1/1.60217733E-19)},
            {"EMU of charge", 10.0, 0.1},
            {"ESU of charge", 3.335641E-10, (1/3.335641E-10)},
            {"Faraday", 96485.309, (1/96485.309)},
            {"Franklin", 3.335641E-10, (1/3.335641E-10)},
            {"Kilocoulomb", 1000.0, 0.001},
            {"Millicoulomb", 0.001, 1000.0},
            {"Megacoulomb", Math.pow(10,6), Math.pow(10,-6)},
            {"Microcoulomb", Math.pow(10,-6), Math.pow(10,6)},
            {"Millicoulomb", Math.pow(10,-3), Math.pow(10,3)},
            {"Nanocoulomb", Math.pow(10,-9), Math.pow(10,9)},
            {"Picocoulomb", Math.pow(10,-12), Math.pow(10,12)},
            {"Statcoulomb", 3.335641E-10, (1/3.335641E-10)}
    };
    final Object[][] dataArray = {
            {"Bit/second", 1.0, 1.0}, {"Byte/second", 8.0, 0.125},
            {"Gigabit/second", Math.pow(10,9), Math.pow(10,-9)},
            {"Gigabyte/second", 8589934592.0, (1.0/8/1024/1024/1024)},
            {"Kilobit/second", 1000.0, 0.001}, {"Kilobyte/second", 8192.0, (1.0/8/1024)},
            {"Megabit/second", 1000000.0, 0.000001}, {"Megabyte/second", 8388608.0, (1.0/8/1024/1024)},
            {"Terabit/second", Math.pow(10,12), Math.pow(10,-12)},
            {"Terabyte/second", 8796093022208.0, (1.0/8/1024/1024/1024/1024)}
    };
    final Object[][] densityArray = {
            {"Gram/cubic centimetre", 1000.0, 0.001}, {"Gram/millilitre", 1000.0, 0.001},
            {"Kilogram/cubic decimetre", 1000.0, 0.001}, {"Kilogram/cubic metre", 1.0, 1.0},
            {"Kilogram/litre", 1000.0, 0.001}, {"Tonne/cubic metre", 1000.0, 0.001}
    };
    final Object[][] energyArray = {
            {"British thermal unit", 1055.0, 0.00094787}, {"Calorie", 4.184, 0.239006},
            {"Electron volt", (1.60218*Math.pow(10,-19)), (1.60218*Math.pow(10,19))},
            {"Erg", Math.pow(10,-7), 10000000.0}, {"Foe", Math.pow(10,44), Math.pow(10,-44)},
            {"Foot pound force", 1.3558, 0.737572},
            {"Gasoline gallon", 120.0*Math.pow(10,6), 0.00000000833334},
            {"Horsepower-hour", 2684500.0, 0.00000037250885}, {"Joule", 1.0, 1.0},
            {"Kilowatt-hour", 3600000.0, (1/3600000.0)},
            {"Quad", 1.055*Math.pow(10,18), 0.9478673*Math.pow(10,-18)},
            {"Therm", 1055000000.0, 9.478673*Math.pow(10,-10)}
    };
    final Object[][] footwearArray = {
            {"Centimetre", 0.0, 0.0}, {"EU", -13.0, 13.0}, {"UK", 19.5, -19.5},
            {"US(Kids')", 19.0, -19.0}, {"US(Men's)", 17.5, -17.5}, {"US(Women's)", 19.0, -19.0}
    };
    final Object[][] forceArray = {
            {"Dyne", Math.pow(10,-5), Math.pow(10,5)},
            {"Kilogram-force", 9.80665, 0.10197162}, {"Newton", 1.0, 1.0},
            {"Pound-force", 4.448222, 0.22480892},
            {"Poundal", 0.138255, 7.23301146}, {"Sthène", 1000.0, 0.001},
            {"Tonforce", 9806.665, 0.00010197}
    };
    final Object[][] heatDensityArray = {
            {"Joule/square metre", 1.0, 1.0},
            {"Calorie(th)/square centimetre", 41840.0, 1/41840},
            {"Langley", 41840.0, 1.0/41840},
            {"BTU(IT)/square foot", 0.0000880551, 11356.526682},
            {"BTU(th)/square foot", 0.000088114, 1134.981795}
    };
    final Object[][] inductanceArray = {
            {"Abhenry", 1E-9, 1E+9},
            {"EMU of inductance", 1E-9, 1E+9},
            {"ESU of inductance", 8497552E+5, (1/8497552E+5)},
            {"Henry", 1.0, 1.0},
            {"Stathenry", 8497552E+5, (1/8497552E+5)},
            {"Weber/ampere", 1.0, 1.0}
    };
    final Object[][] illuminationArray = {
            {"Candela steradian/metre", 1.0, 1.0},
            {"Centimetre-candle", 10000.0, 0.0001},
            {"Flame", 43.055641667, 1/43.055641667},
            {"Foot-candle", 10.763910417, 1/10.763910417},
            {"Lumen/square centimetre", 10000.0, 0.0001},
            {"Lumen/square foot", 10.763910417, 1/10.763910417},
            {"Lumen/square metre", 1.0, 1.0},
            {"Lux", 1.0, 1.0},
            {"Metre-candle", 1.0, 1.0},
            {"Nox", 0.001, 1000.0},
            {"Phot", 10000.0, 0.0001},
            {"Watt/square metre", 6830000.0, 1.0/6830000}
    };
    final Object[][] lengthArray = {
            {"Attometre", Math.pow(10,-18), Math.pow(10,18)},
            {"Barleycorn", 0.0084667, 118.11}, {"Boat length", 19.0, 0.0526316},
            {"Cable", 185.2, 0.0054}, {"Centimetre", Math.pow(10,-2), Math.pow(10,2)},
            {"Chain", 20.1168, 0.04871},
            {"Decametre", Math.pow(10,1), Math.pow(10,-1)},
            {"Decimetre", Math.pow(10,-1), Math.pow(10,1)},
            {"Fathom", 1.852, 0.54}, {"Femtometre", Math.pow(10,-15), Math.pow(10,15)},
            {"Foot", 0.3048, 3.2809}, {"Furlong", 201.168, 0.004971},
            {"Gigametre", Math.pow(10,9), Math.pow(10,-9)},
            {"Hammer", 0.01905, 52.49344}, {"Hand", 0.1016, 9.84252},
            {"Hectometre", Math.pow(10,2), Math.pow(10,-2)},
            {"Horse", 2.4, 0.4167}, {"Inch", 0.0254, 39.37008},
            {"Kilometre", Math.pow(10,3), Math.pow(10,-3)},
            {"League", 4828.032, 0.000207124},
            {"Light year", 9.461E15, 1.057E-16},
            {"Link", 0.201168, 4.971}, {"Megametre", Math.pow(10,6), Math.pow(10,-6)},
            {"Metre", 1.0, 1.0}, {"Micrometre", Math.pow(10,-6), Math.pow(10,6)},
            {"Mile", 1609.344, 0.00062138},
            {"Millimetre", Math.pow(10,-3), Math.pow(10,3)},
            {"Nanometre", Math.pow(10,-9), Math.pow(10,9)},
            {"Nautical mile", 1852.0, 0.00054},
            {"Picometre", Math.pow(10,-12), Math.pow(10,12)},
            {"Rack unit", 0.04445, 22,4972},
            {"Rod/Perch/Pole/Lug", 5.0292, 0.198839},
            {"Terametre", Math.pow(10,12), Math.pow(10,-12)},
            {"Thou", 0.0000254, 39370.0787402},
            {"Yard", 0.9144, 1.094},
            {"Yoctometre", Math.pow(10,-24), Math.pow(10,24)},
            {"Zeptometre", Math.pow(10,-21), Math.pow(10,21)},
            {"Zetametre", Math.pow(10,13), Math.pow(10,-13)}
    };
    final Object[][] luminanceArray = {
            {"Apostilb", 3.1830988618, 1/3.1830988618},
            {"Blondel", 3.1830988618, 1/3.1830988618},
            {"Bril", 3.183098861E-8, 1/3.183098861E-8},
            {"Candela/square centimetre", 10000.0, 0.0001},
            {"Candela/square foot", 10.763910417, 1/10.763910417},
            {"Candela/square inch", 1550.0031, 1/1550.0031},
            {"Candela/square metre", 1.0, 1.0},
            {"Foot-lambert", 3.4262590996, 1/3.4262590996},
            {"Kilocandela/square metre", 1000.0, 0.001},
            {"Lambert", 3183.0988618, 1/3183.0988618},
            {"Lumen/square centimetre/steradian", 10000.0, 0.0001},
            {"Lumen/square foot/steradian", 10.763910417, 1/10.763910417},
            {"Lumen/square metre/steradian", 1.0, 1.0},
            {"Millilambert", 3.1830988618, 1/3.1830988618},
            {"Millinit", 0.001, 1000.0},
            {"Nit", 1.0, 1.0},
            {"Skot", 0.0003183098, 1/0.0003183098},
            {"Stilb", 10000.0, 0.0001},
            {"Watt/square centimetre/steradian", 6830000.0, 1.0/6830000},
    };
    final Object[][] luminousIntensityArray = {
            {"Candela", 1.0, 1.0}, {"Candlepower", 0.981, (1/0.981)}, {"Carcel", 9.74, (1/9.74)},
            {"Hefnerkerze", 0.92, (1/0.92)}, {"Violle", 60.0, (1/60.0)}
    };
    final Object[][] magneticFluxArray = {
            {"Gauss square centimetre", 1E-8, 1E+8},
            {"Kiloline", 0.00001, 100000.0},
            {"Line", 1E-8, 1E+8},
            {"Magnetic flux quantum", 2.067834609E-15, 1/(2.067834609E-15)},
            {"Maxwell", 1E-8, 1E+8},
            {"Megaline", 0.01, 100.0},
            {"Microweber", 0.000001, 1000000.0},
            {"Milliweber", 0.001, 1000.0},
            {"Tesla square metre", 1E-8, 1E+8},
            {"Tesla square centimetre", 0.0001, 10000.0},
            {"Unit pole", 1.256637061E-7, 1/(1.256637061E-7)},
            {"Volt second", 1.0, 1.0},
            {"Weber", 1.0, 1.0}
    };
    final Object[][] magneticFluxDensityArray = {
            {"Gamma", 0.0001, 10000.0},
            {"Gauss", 0.0001, 10000.0},
            {"Line/square centimetre", 0.0001, 10000.0},
            {"Line/square inch", 0.0000155, 1/0.0000155},
            {"Maxwell/square centimetre", 0.0001, 10000.0},
            {"Maxwell/square inch", 0.0000155, 1/(0.0000155)},
            {"Maxwell/square metre", 1.0, 1.0},
            {"Tesla", 1.0, 1.0},
            {"Weber/square centimetre", 10000.0, 0.0001},
            {"Weber/square inch", 1550.0031, 1/(1550.0031)},
            {"Weber/square metre", 1.0, 1.0}
    };
    final Object[][] massArray = {
            {"Attogram", Math.pow(10,-21), Math.pow(10,21)},
            {"Carat", 2*Math.pow(10,-4), 5000.0},
            {"Centigram", Math.pow(10,-5), Math.pow(10,5)},
            {"Decagram", Math.pow(10,-2), Math.pow(10,2)},
            {"Decigram", Math.pow(10,-4), Math.pow(10,4)},
            {"Femtogram", Math.pow(10,-18), Math.pow(10,18)},
            {"Gigagram", Math.pow(10,6), Math.pow(10,-6)},
            {"Grain", 0.00006479891, 1543236.0},
            {"Gram", Math.pow(10,-3), Math.pow(10,3)},
            {"Hectogram", Math.pow(10,-1), Math.pow(10,1)},
            {"Kilogram", 1.0, 1.0},
            {"Megagram", Math.pow(10,3), Math.pow(10,-3)},
            {"Microgram", Math.pow(10,-9), Math.pow(10,9)},
            {"Milligram", Math.pow(10,-6), Math.pow(10,6)},
            {"Nanogram", Math.pow(10,-12), Math.pow(10,12)},
            {"Ounce", 0.0283, 35.33569},
            {"Picogram", Math.pow(10,-15), Math.pow(10,15)},
            {"Pound", 0.4536, 2.20458554},
            {"Slug", 14.6, 0.06849315},
            {"Stone", 6.3504, 0.1574704},
            {"Teragram", Math.pow(10,9), Math.pow(10,-9)},
            {"Tonne", 1000.0, 0.001},
            {"Yoctogram", Math.pow(10,-27), Math.pow(10,27)},
            {"Zeptogram", Math.pow(10,-24), Math.pow(10,24)},
            {"Zetagram", Math.pow(10,10), Math.pow(10,-10)}
    };
    final Object[][] morseArray = {
            {'A', ".-"}, {'B', "-..."}, {'C', "-.-."}, {'D', "-.."}, {'E', "."}, {'F', "..-."},
            {'G', "--."}, {'H', "...."}, {'I', ".."}, {'J', ".---"}, {'K', "-.-"}, {'L', ".-.."},
            {'M', "--"}, {'N', "-."}, {'O', "---"}, {'P', ".--."}, {'Q', "--.-"}, {'R', ".-."},
            {'S', "..."}, {'T', "-"}, {'U', "..-"}, {'V', "...-"}, {'W', ".--"}, {'X', "-..-"},
            {'Y', "-.--"}, {'Z', "--.."}, {'1', ".----"}, {'2', "..---"}, {'3', "...--"},
            {'4', "....-"}, {'5', "....."}, {'6', "-...."}, {'7', "--..."}, {'8', "---.."},
            {'9', "----."}, {'0', "-----"}, {'.', ".-.-.-"}, {'@', ".--.-."}, {'!', "-.-.--"},
            {')', "-.--.-"}, {'(', "-.--."}, {'?', "..--.."}, {'/', "-..-."}, {'+', ".-.-."},
            {'-', "-....-"}, {'=', "-...-"}, {'\'', ".----."}, {'\"', ".-..-."}, {'&', ".-..."},
            {' ', "/"},
    };
    final Object[][] permeabilityArray = {
            {"Kilogram/pascal/square metre", 1.0, 1.0},
            {"Permeability(0°C)", 5.721349999E-11, 1/5.721349999E-11},
            {"Permeability(23°C)", 5.745249999E-11, 1/5.745249999E-11},
            {"Permeability inch(0°C)", 1.453219999E-12, 1/1.453219999E-12},
            {"Permeability inch(23°C)", 1.459289999E-12, 1/1.459289999E-12},
    };
    final Object[][] powerArray = {
            {"British thermal unit/hour", 0.29307, 3.41215409},
            {"Calorie/hour", 0.001163, 859.845228}, {"Decibel-milliwatt", (1/30.0), 30.0},
            {"Erg/second", Math.pow(10,-7), 10000000.0},
            {"Foot pound force/min", 0.022597, 44.253662}, {"Horsepower", 745.6999, 0.00134102},
            {"Watt", 1.0, 1.0}
    };
    final Object[][] pressureArray = {
            {"Atmospheric pressure", 101325.0, 0.00000987}, {"Bar", 100000.0, 0.00001},
            {"Barye", 0.1, 10.0}, {"Foot sea water", 92.67302, 0.01079063},
            {"Metric sea water", 10000.0, 0.0001}, {"Pascal", 1.0, 1.0},
            {"Pièze", 1000.0, 0.001}, {"Pound/square inch", 6894.7573, 0.000145038},
            {"Technical atmosphere", 98066.5, 0.0000102}, {"Torr", 133.32237, 0.00750067}
    };
    final Object[][] radiationArray = {
            {"Attogray/second", Math.pow(10,-18), Math.pow(10,18)},
            {"Centigray/second", Math.pow(10,-2), Math.pow(10,2)},
            {"Decagray/second", Math.pow(10,1), Math.pow(10,-1)},
            {"Decigray/second", Math.pow(10,-1), Math.pow(10,1)},
            {"Exagray/second", Math.pow(10,18), Math.pow(10,-18)},
            {"Femtogray/second", Math.pow(10,-15), Math.pow(10,15)},
            {"Gigagray/second", Math.pow(10,9), Math.pow(10,-9)},
            {"Gray/second", 1.0, 1.0},
            {"Hectogray/second", Math.pow(10,2), Math.pow(10,-2)},
            {"Joule/kilogram/second", 1.0, 1.0},
            {"Kilogray/second", Math.pow(10,3), Math.pow(10,-3)},
            {"Megagray/second", Math.pow(10,6), Math.pow(10,-6)},
            {"Microgray/second", Math.pow(10,-6), Math.pow(10,6)},
            {"Milligray/second", Math.pow(10,-3), Math.pow(10,3)},
            {"Nanogray/second", Math.pow(10,-9), Math.pow(10,9)},
            {"Petagray/second", Math.pow(10,15), Math.pow(10,-15)},
            {"Picogray/second", Math.pow(10,-12), Math.pow(10,12)},
            {"Rad/second", 1.0, 1.0},
            {"Rem/second", 0.01, 100},
            {"Sievert/second", 1.0, 1.0},
            {"Teragray/second", Math.pow(10,12), Math.pow(10,-12)},
            {"Watt/kilogram", 1.0, 1.0},
            {"Yoctogray/second", Math.pow(10,-24), Math.pow(10,24)},
            {"Zeptogray/second", Math.pow(10,-21), Math.pow(10,21)},
            {"Zetagray/second", Math.pow(10,13), Math.pow(10,-13)}
    };
    final Object[][] radiationActivityArray = {
            {"Becquerel", 1.0, 1.0},
            {"Curie", 3.7E+10, 1/(3.7E+10)},
            {"Gigabecquerel", 1E+9, 1E-9},
            {"Kilobecquerel", 1E+3, 1E-3},
            {"Kilocurie", 3.7E+13, 1/(3.7E+13)},
            {"Megabecquerel", 1E+6, 1E-6},
            {"Microcurie", 3.7E+4, 1/(3.7E+4)},
            {"Millibecquerel", 1E+3, 1E-3},
            {"Millicurie", 3.7E+7, 1/(3.7E+7)},
            {"Nanocurie", 37.0, 1.0/(37)},
            {"Picocurie", 3.7E-2, 1/(3.7E-2)},
            {"Terabecquerel", 1E+12, 1E-12},
            {"Rutherford", 1000000.0, 0.000001},
            {"One/second", 1.0, 1.0},
            {"Disintegration/second", 1.0, 1.0}
    };
    final Object[][] radiationExposureArray = {
            {"Coulomb/kilogram", 1.0, 1.0},
            {"Millicoulomb/kilogram", 0.001, 1000.0},
            {"Microcoulomb/kilogram", 0.000001, 1000000.0},
            {"Parker", 0.000258, 1/0.000258},
            {"Rep", 0.000258, 1/0.000258},
            {"Roentgen", 0.000258, 1/0.000258},
            {"Tissue roentgen", 0.000258, 1/0.000258}
    };
    final Object[][] resistanceArray = {
            {"Abohm/Emu resistance", Math.pow(10,-9), Math.pow(10,9)}, {"Kiloohm", 1000.0, 0.001},
            {"Megaohm", 1000000.0, 0.000001}, {"Ohm", 1.0, 1.0},
            {"Statohm", (9*Math.pow(10,11)), (0.11*Math.pow(10,-11))}
    };
    final Object[][] speedArray = {
            {"Centimetre/second", 0.036, 27.7778}, {"Kilometre/hour", 1.0, 1.0},
            {"Kilometre/second", 3600.0, 0.000277778}, {"Knot", 1.852, 0.539957},
            {"Mach", 1234.8, 0.000809848}, {"Metre/hour", 0.001, 1000.0},
            {"Metre/second", 3.6, 0.277778}, {"Mile/hour", 1.60934, 0.621371},
            {"Mile/second", 5793.64, 0.000172603}, {"Speed of light", 1.079E+9, 9.26567E-10}
    };
    final Object[][] surfaceTensionArray = {
            {"Dyne/centimetre", 0.001, 1000.0},
            {"Erg/square centimetre", 0.001, 1000.0},
            {"Erg/square millimetre", 0.1, 10.0},
            {"Gram-force/centimetre", 0.980665, 1/0.980665},
            {"Millinewton/metre", 0.001, 1000.0},
            {"Newtom/metre", 1.0, 1.0},
            {"Pound-force/inch", 175.12683699, 1/175.12683699},
            {"Poundal/inch", 5.443108491, 1/5.443108491}
    };
    final Object[][] timeArray = {
            {"Day", 86400.0, 0.0000115741}, {"Fortnight", 1209600.0, 0.00000082672},
            {"Hour", 3600.0, 0.000277778}, {"Ke", 864.0, 0.00115741},
            {"Leap year", 31622400.0, (1/31622400.0)}, {"Minute", 60.0, 0.01666667},
            {"Moment", 90.0, 0.1111111}, {"Month", 2592000.0, (1/2592000.0)},
            {"Quarter", 7776000.0, (1/7776000.0)}, {"Second", 1.0, 1.0},
            {"Semester", 10886400.0, (1/10886400.0)}, {"Sol", 88775.0, (1/88775.0)},
            {"Week", 604800.0, 0.00000165344}, {"Year", 31556952.0, (1/31556952.0)}
    };
    final Object[][] torqueArray = {
            {"Dyne centimetre", 0.0000001, 10000000.0},
            {"Dyne metre", 0.00001, 100000.0},
            {"Dyne millimetre", 0.00000001, 100000000.0},
            {"Gram-force centimetre", 0.0000980665, 1/0.0000980665},
            {"Gram-force metre", 0.00980665, 1/0.00980665},
            {"Gram-force millimetre", 0.00000980665, 1/0.00000980665},
            {"Kilogram-force centimetre", 0.0980665, 1/0.0980665},
            {"Kilogram-force metre", 9.80665, 1/9.80665},
            {"Kilogram-force millimetre", 0.00980665, 1/0.00980665},
            {"Kilonewton metre", 1000.0, 0.001},
            {"Newton centimetre", 0.01, 100.0},
            {"Newton metre", 1.0, 1.0},
            {"Newton millimetre", 0.001, 1000.0},
            {"Ounce-force foot", 0.084738624, 1/0.084738624},
            {"Ounce-force inch", 0.007061552, 1/0.007061552},
            {"Pound-force foot", 1.355818, 1/1.355818},
            {"Pound-force inch", 0.1129848333, 1/0.1129848333}
    };
    final Object[][] velocityAngularArray = {
            {"Degree/day", 2.020057004E-7, 1/2.020057004E-7},
            {"Degree/hour", 0.0000048481, 1/0.0000048481},
            {"Degree/minute", 0.0002908882, 1/0.0002908882},
            {"Degree/second", 0.0174532925, 1/0.0174532925},
            {"Radian/day", 0.0000115741, 1/0.0000115741},
            {"Radian/hour", 0.0002777778, 1/0.0002777778},
            {"Radian/minute", 0.0166666667, 1/0.0166666667},
            {"Radian/second", 1.0, 1.0},
            {"Revolution/day", 0.0000727221, 1/0.0000727221},
            {"Revolution/hour", 0.0017453293, 1/0.0017453293},
            {"Revolution/minute", 0.1047197551, 1/0.1047197551},
            {"Revolution/second", 6.2831853072, 1/6.2831853072}
    };
    final Object[][] volumeArray = {
            {"Barrel", 0.159, 6.28930818}, {"Board foot", 0.00236, 423.728814},
            {"Cord", 3.62, 0.27624309}, {"Cubic centimetre", 0.000001, 1000000.0},
            {"Cubic decimetre", 0.001, 1000.0}, {"Cubic foot", 0.02317, 35.3144754},
            {"Cubic inch", 0.0000164, 60975.6098}, {"Cubic metre", 1.0, 1.0},
            {"Cubic yard", 0.764555, 1.30795038}, {"Gallon", 0.00379, 263.852243},
            {"Hoppus cubic foot", 0.03605, 27.739251}, {"Hoppus ton", 1.8027, 0.55472347},
            {"Litre", 0.001, 1000.0}, {"Millilitre", 0.000001, 1000000.0},
            {"Pint", 0.00047318, 2113.36067}, {"Raummeter/Stere", 0.7, 1.42857143}
    };

    EditText inputText;
    TextView outputText;

    Button convertButton;
    Button copyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        convertButton = findViewById(R.id.convertButton);
        copyButton = findViewById(R.id.copyButton);

        final Intent intent = getIntent();
        final String type = intent.getStringExtra(MainActivity.typeExtra);
        final String unitInput = intent.getStringExtra(MainActivity.unitInputExtra);
        final String unitOutput = intent.getStringExtra(MainActivity.unitOutputExtra);
        final int unitInputIndex = intent.getIntExtra(MainActivity.unitInputIndexExtra, 0);
        final int unitOutputIndex = intent.getIntExtra(MainActivity.unitOutputIndexExtra, 0);
        final int numOfDecimalPointsExtra = intent.getIntExtra(MainActivity.numOfDecimalPointsExtra, 0);

        final String numOfDecimalPoints = "%."+numOfDecimalPointsExtra+"f";

        inputText.setHint(unitInput);
        outputText.setHint(unitOutput);

        convertButton.setOnClickListener(v -> {
            double finalVal;
            outputText.setText("");
            String inputString = inputText.getText().toString().trim();
            Scanner sc = new Scanner(inputString);
            if((inputString).equals("")) {
                Toast.makeText(getApplicationContext(),"Please input the value to be converted.", Toast.LENGTH_SHORT).show();
            } else {
                while(sc.hasNextLine()) {
                    StringTokenizer inputStringCSV = new StringTokenizer(sc.nextLine(), ",");
                    while (inputStringCSV.hasMoreTokens()) {
                        inputString = inputStringCSV.nextToken().trim();
                        int numOfDots = inputString.length()-inputString.replace(".", "").length();
                        assert unitInput != null;
                        if((((unitInput.equals("Hexadecimal") && inputString.matches("^[A-F0-9.]+$")) ||
                                (!unitInput.equals("Hexadecimal") && !Objects.equals(type, "Code") && inputString.matches("^[0-9.]+$")))
                                && numOfDots <= 1 && !inputString.equals(".")) || Objects.equals(type, "Code")) {
                            switch (Objects.requireNonNull(type)) {
                                case "Acceleration":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)accelerationArray[unitInputIndex][1])
                                            * ((Double)accelerationArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Acceleration(Angular)":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)accelerationAngularArray[unitInputIndex][1])
                                            * ((Double)accelerationAngularArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Angle":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)angleArray[unitInputIndex][1])
                                            * ((Double)angleArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Area":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)areaArray[unitInputIndex][1])
                                            * ((Double)areaArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Base": {
                                    String decimal = "", output = "";
                                    if (!unitInput.equals("Hexadecimal")) {
                                        inputString = String.valueOf(Double.parseDouble(inputString));
                                    }
                                    StringTokenizer floatSplitter = new StringTokenizer(inputString, ".");
                                    int n = 0, r, q, s = 0;
                                    double doubleRes = 0.0;
                                    int a = 0;
                                    int afterLength = 0;
                                    String beforeFloat = floatSplitter.nextToken();
                                    String afterFloat = "";
                                    boolean floatActive = false;
                                    if (floatSplitter.hasMoreTokens()) {
                                        afterFloat = floatSplitter.nextToken();
                                        afterLength = afterFloat.length();
                                        floatActive = true;
                                    }
                                    if (!unitInput.equals("Hexadecimal")) {
                                        n = Integer.parseInt(beforeFloat);
                                    }
                                    switch (unitInput) {
                                        case "Binary":
                                            if (!inputString.matches("^[0-1.]+$")) {
                                                Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            decimal = baseFinder(n, 2, floatActive, afterFloat, afterLength);
                                            break;
                                        case "Ternary":
                                            if (!inputString.matches("^[0-2.]+$")) {
                                                Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            decimal = baseFinder(n, 3, floatActive, afterFloat, afterLength);
                                            break;
                                        case "Quaternary":
                                            if (!inputString.matches("^[0-3.]+$")) {
                                                Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            decimal = baseFinder(n, 4, floatActive, afterFloat, afterLength);
                                            break;
                                        case "Quinary":
                                            if (!inputString.matches("^[0-4.]+$")) {
                                                Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            decimal = baseFinder(n, 5, floatActive, afterFloat, afterLength);
                                            break;
                                        case "Septenary":
                                            if (!inputString.matches("^[0-6.]+$")) {
                                                Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            decimal = baseFinder(n, 7, floatActive, afterFloat, afterLength);
                                            break;
                                        case "Octal":
                                            if (!inputString.matches("^[0-7.]+$")) {
                                                Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            decimal = baseFinder(n, 8, floatActive, afterFloat, afterLength);
                                            break;
                                        case "Nonary":
                                            if (!inputString.matches("^[0-8.]+$")) {
                                                Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            decimal = baseFinder(n, 9, floatActive, afterFloat, afterLength);
                                            break;
                                        case "Decimal":
                                            decimal = inputString;
                                            break;
                                        case "Hexadecimal":
                                            String[] hexaD = new String[beforeFloat.length()];
                                            char musa;
                                            String[] hexaDFloat = new String[afterLength];
                                            for (int g = 0; g < beforeFloat.length(); g++) {
                                                musa = beforeFloat.charAt(g);
                                                switch (musa) {
                                                    case 'A':
                                                        hexaD[g] = "10";
                                                        break;
                                                    case 'B':
                                                        hexaD[g] = "11";
                                                        break;
                                                    case 'C':
                                                        hexaD[g] = "12";
                                                        break;
                                                    case 'D':
                                                        hexaD[g] = "13";
                                                        break;
                                                    case 'E':
                                                        hexaD[g] = "14";
                                                        break;
                                                    case 'F':
                                                        hexaD[g] = "15";
                                                        break;
                                                    default:
                                                        hexaD[g] = "" + (musa);
                                                }
                                            }
                                            for (int j = beforeFloat.length() - 1; j >= 0; j--) {
                                                a = (int) (a + (Integer.parseInt(hexaD[j]) * Math.pow(16.0, s)));
                                                s++;
                                            }

                                            decimal = String.valueOf(a);

                                            if (floatActive) {
                                                for (int g = 0; g < afterLength; g++) {
                                                    musa = afterFloat.charAt(g);
                                                    switch (musa) {
                                                        case 'A':
                                                            hexaDFloat[g] = "10";
                                                            break;
                                                        case 'B':
                                                            hexaDFloat[g] = "11";
                                                            break;
                                                        case 'C':
                                                            hexaDFloat[g] = "12";
                                                            break;
                                                        case 'D':
                                                            hexaDFloat[g] = "13";
                                                            break;
                                                        case 'E':
                                                            hexaDFloat[g] = "14";
                                                            break;
                                                        case 'F':
                                                            hexaDFloat[g] = "15";
                                                            break;
                                                        default:
                                                            hexaDFloat[g] = "" + (musa);
                                                    }
                                                }
                                                s = 1; int hexaDfloatlen = hexaDFloat.length; int j=0;
                                                while(j < hexaDfloatlen) {
                                                    doubleRes = (doubleRes + (Integer.parseInt(hexaDFloat[j]) * Math.pow(16.0, -s)));
                                                    j++;
                                                    s++;
                                                }
                                                decimal = String.valueOf(Double.parseDouble(decimal) + doubleRes);
                                            }
                                            break;
                                    }

                                    StringTokenizer floatSplitterT = new StringTokenizer(decimal, ".");
                                    beforeFloat = floatSplitterT.nextToken();
                                    n = Integer.parseInt(beforeFloat);
                                    q = n; double decimalDouble = Double.parseDouble(decimal);
                                    String rev = "";
                                    switch (Objects.requireNonNull(unitOutput)) {
                                        case "Decimal":
                                            output = decimal;
                                            break;
                                        case "Binary":
                                            output = baseInverter(n, 2, afterFloat, decimalDouble, beforeFloat);
                                            break;
                                        case "Ternary":
                                            output = baseInverter(n, 3, afterFloat, decimalDouble, beforeFloat);
                                            break;
                                        case "Quaternary":
                                            output = baseInverter(n, 4, afterFloat, decimalDouble, beforeFloat);
                                            break;
                                        case "Quinary":
                                            output = baseInverter(n, 5, afterFloat, decimalDouble, beforeFloat);
                                            break;
                                        case "Septenary":
                                            output = baseInverter(n, 7, afterFloat, decimalDouble, beforeFloat);
                                            break;
                                        case "Octal":
                                            output = baseInverter(n, 8, afterFloat, decimalDouble, beforeFloat);
                                            break;
                                        case "Nonary":
                                            output = baseInverter(n, 9, afterFloat, decimalDouble, beforeFloat);
                                            break;
                                        case "Hexadecimal":
                                            while (q > 0) {
                                                r = n % 16;
                                                q = n / 16;
                                                n = q;
                                                switch (r) {
                                                    case 10:
                                                        rev = rev.concat("A");
                                                        break;
                                                    case 11:
                                                        rev = rev.concat("B");
                                                        break;
                                                    case 12:
                                                        rev = rev.concat("C");
                                                        break;
                                                    case 13:
                                                        rev = rev.concat("D");
                                                        break;
                                                    case 14:
                                                        rev = rev.concat("E");
                                                        break;
                                                    case 15:
                                                        rev = rev.concat("F");
                                                        break;
                                                    default:
                                                        rev = rev.concat(String.valueOf(r));
                                                        break;
                                                }
                                            }
                                            for (int g = rev.length() - 1; g >= 0; g--) {
                                                output = output.concat(String.valueOf(rev.charAt(g)));
                                            }
                                            if (!afterFloat.equals("0")) {
                                                rev = "";
                                                int max = 0;
                                                doubleRes = decimalDouble - Double.parseDouble(beforeFloat);
                                                while ((doubleRes > 0.0) && (max < 100)) {
                                                    doubleRes = doubleRes * 16;
                                                    switch ((int) doubleRes) {
                                                        case 10:
                                                            rev = rev.concat("A");
                                                            break;
                                                        case 11:
                                                            rev = rev.concat("B");
                                                            break;
                                                        case 12:
                                                            rev = rev.concat("C");
                                                            break;
                                                        case 13:
                                                            rev = rev.concat("D");
                                                            break;
                                                        case 14:
                                                            rev = rev.concat("E");
                                                            break;
                                                        case 15:
                                                            rev = rev.concat("F");
                                                            break;
                                                        default:
                                                            rev = rev.concat(String.valueOf((int) doubleRes));
                                                            break;
                                                    }
                                                    doubleRes = doubleRes - ((int) doubleRes);
                                                    max++;
                                                }
                                                output = output.concat(".".concat(rev));
                                            }
                                            break;
                                    }
                                    outputText.append(output+ ",");
                                    break;
                                }
                                case "Charge": {
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double) chargeArray[unitInputIndex][1])
                                            * ((Double) chargeArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                }
                                case "Code": {
                                    String alphanum = "", output = "";
                                    switch (unitInput) {
                                        case "Alphanumeral":
                                            alphanum = inputString;
                                            break;
                                        case "Caesar cipher(key=2)":
                                        case "Caesar cipher(key=3)":
                                            int inputKey;
                                            if(unitInput.charAt(18) == '2') {
                                                inputKey = 2;
                                            } else  {
                                                inputKey = 3;
                                            }
                                            String outputCaesar = "";
                                            inputString = inputString.toUpperCase();
                                            if (!inputString.matches("^[A-Z. ]+$")) {
                                                Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            int charOfc;
                                            for(int j=0; j<inputString.length(); j++) {
                                                char caesarChar = inputString.charAt(j);
                                                if((int)caesarChar >= 65 && (int)caesarChar <=90) {
                                                    charOfc = (((caesarChar-65)-inputKey)%26)+65;
                                                    if(charOfc<65) {
                                                        charOfc = charOfc+26;
                                                    }
                                                    caesarChar = (char)charOfc;
                                                }
                                                outputCaesar = outputCaesar.concat(String.valueOf(caesarChar));
                                            }
                                            alphanum = outputCaesar;
                                            break;
                                        case "Morse code":
                                            boolean containsChar; int ind = 0;
                                            if (!inputString.matches("^[-/. ]+$")) {
                                                Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            StringTokenizer morseParser = new StringTokenizer(inputString, " ");
                                            String parserString;
                                            while (morseParser.hasMoreTokens()) {
                                                containsChar = false;
                                                parserString = morseParser.nextToken();
                                                for(int q = 0; q<50; q++) {
                                                    if((morseArray[q][1]).equals(parserString)) {
                                                        containsChar = true;
                                                        ind = q;
                                                    }
                                                }
                                                if (containsChar) {
                                                    alphanum = alphanum.concat(String.valueOf(morseArray[ind][0]));
                                                } else {
                                                    Toast.makeText(getApplicationContext(), "No morse code equivalent found.", Toast.LENGTH_SHORT).show();
                                                    return;
                                                }
                                            }
                                            break;
                                        case "ASCII":
                                            StringTokenizer ascTok = new StringTokenizer(inputString);
                                            char c;
                                            while (ascTok.hasMoreTokens()) {
                                                c = (char) (Integer.parseInt(ascTok.nextToken()));
                                                alphanum = alphanum.concat(String.valueOf(c));
                                            }
                                            break;
                                    }
                                    switch (Objects.requireNonNull(unitOutput)) {
                                        case "Morse code":
                                            boolean containsChar; int ind = 0;
                                            StringTokenizer morseParser = new StringTokenizer(alphanum, " ");
                                            String parserString;
                                            char now;
                                            int s = morseParser.countTokens();
                                            while (morseParser.hasMoreTokens()) {
                                                if (!(s == 1)) {
                                                    parserString = (morseParser.nextToken().toUpperCase()).concat(" ");
                                                } else {
                                                    parserString = (morseParser.nextToken().toUpperCase());
                                                }
                                                for (int g = 0; g < parserString.length(); g++) {
                                                    containsChar = false;
                                                    now = parserString.charAt(g);
                                                    for(int q = 0; q<50; q++) {
                                                        if(((Character)morseArray[q][0]) == now) {
                                                            containsChar = true;
                                                            ind = q;
                                                        }
                                                    }
                                                    if (containsChar) {
                                                        output = output.concat(String.valueOf(morseArray[ind][1]).concat(" "));
                                                    } else {
                                                        Toast.makeText(getApplicationContext(), "Invalid morse code found.", Toast.LENGTH_SHORT).show();
                                                        return;
                                                    }
                                                }
                                                s--;
                                            }
                                            break;
                                        case "Alphanumeral":
                                            output = alphanum;
                                            break;
                                        case "ASCII":
                                            int leng = alphanum.length();
                                            int g = 0;
                                            int c;
                                            while (g < leng) {
                                                c = alphanum.charAt(g);
                                                output = output.concat(c + " ");
                                                g++;
                                            }
                                            break;
                                        case "Caesar cipher(key=2)":
                                        case "Caesar cipher(key=3)":
                                            int inputKey;
                                            if(unitOutput.charAt(18) == '2') {
                                                inputKey = 2;
                                            } else {
                                                inputKey = 3;
                                            }
                                            String outputCaesar = "";
                                            alphanum = alphanum.toUpperCase();
                                            if (!alphanum.matches("^[A-Z. ]+$")) {
                                                Toast.makeText(getApplicationContext(), "Invalid input.", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            int charOfc;
                                            for(int j=0; j<alphanum.length(); j++) {
                                                char caesarChar = alphanum.charAt(j);
                                                if((int)caesarChar >= 65 && (int)caesarChar <=90) {
                                                    charOfc = (((caesarChar-65)+inputKey)%26)+65;
                                                    caesarChar = (char)charOfc;
                                                }
                                                outputCaesar = outputCaesar.concat(String.valueOf(caesarChar));
                                            }
                                            output = outputCaesar;
                                            break;
                                    }
                                    outputText.append(output+ ",");
                                    break;
                                }
                                case "Cooking":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)cookingArray[unitInputIndex][1])
                                            * ((Double)cookingArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Current":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double) currentArray[unitInputIndex][1])
                                            * ((Double) currentArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Density":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)densityArray[unitInputIndex][1])
                                            * ((Double)densityArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Energy":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)energyArray[unitInputIndex][1])
                                            * ((Double)energyArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Force":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)forceArray[unitInputIndex][1])
                                            * ((Double)forceArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Footwear size":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)footwearArray[unitInputIndex][1])
                                            * ((Double)footwearArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Heat Density":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)heatDensityArray[unitInputIndex][1])
                                            * ((Double)heatDensityArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Illumination":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)illuminationArray[unitInputIndex][1])
                                            * ((Double)illuminationArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Inductance":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double) inductanceArray[unitInputIndex][1])
                                            * ((Double) inductanceArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Length":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)lengthArray[unitInputIndex][1])
                                            * ((Double)lengthArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Luminance":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)luminanceArray[unitInputIndex][1])
                                            * ((Double)luminanceArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Luminous intensity":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)luminousIntensityArray[unitInputIndex][1])
                                            * ((Double)luminousIntensityArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Magnetic Flux":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)magneticFluxArray[unitInputIndex][1])
                                            * ((Double)magneticFluxArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Magnetic Flux Density":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)magneticFluxDensityArray[unitInputIndex][1])
                                            * ((Double)magneticFluxDensityArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Mass":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)massArray[unitInputIndex][1])
                                            * ((Double)massArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Permeability":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double) permeabilityArray[unitInputIndex][1])
                                            * ((Double) permeabilityArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Power":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)powerArray[unitInputIndex][1])
                                            * ((Double)powerArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Pressure":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)pressureArray[unitInputIndex][1])
                                            * ((Double)pressureArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Radiation":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)radiationArray[unitInputIndex][1])
                                            * ((Double)radiationArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Radiation Activity":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)radiationActivityArray[unitInputIndex][1])
                                            * ((Double)radiationActivityArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Radiation Exposure":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)radiationExposureArray[unitInputIndex][1])
                                            * ((Double)radiationExposureArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Resistance":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)resistanceArray[unitInputIndex][1])
                                            * ((Double)resistanceArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Speed/Velocity":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)speedArray[unitInputIndex][1])
                                            * ((Double)speedArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Speed(Data)":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)dataArray[unitInputIndex][1])
                                            * ((Double)dataArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Surface Tension":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)surfaceTensionArray[unitInputIndex][1])
                                            * ((Double)surfaceTensionArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Temperature":
                                    double toCelsius;
                                    switch (unitInput) {
                                        case "Kelvin":
                                            toCelsius = Double.parseDouble(inputString) - 273.15;
                                            break;
                                        case "Fahrenheit":
                                            toCelsius = (Double.parseDouble(inputString) - 32) * (5.0 / 9.0);
                                            break;
                                        case "Rankine":
                                            toCelsius = (Double.parseDouble(inputString) - 491.67) * (5.0 / 9.0);
                                            break;
                                        case "Delisle":
                                            toCelsius = 100 + (Double.parseDouble(inputString) * (3.0 / 2.0));
                                            break;
                                        case "Newton":
                                            toCelsius = (Double.parseDouble(inputString)) * (100.0 / 33.0);
                                            break;
                                        case "Reaumur":
                                            toCelsius = (Double.parseDouble(inputString)) * (5.0 / 4.0);
                                            break;
                                        case "Rømer":
                                            toCelsius = (Double.parseDouble(inputString) - 7.5) * (40 / 21.0);
                                            break;
                                        default:
                                            toCelsius = Double.parseDouble(inputString);
                                            break;
                                    }
                                    double toDesiredUnit;
                                    switch (Objects.requireNonNull(unitOutput)) {
                                        case "Kelvin":
                                            toDesiredUnit = toCelsius + 273.15;
                                            break;
                                        case "Fahrenheit":
                                            toDesiredUnit = (toCelsius * (9.0 / 5)) + 32;
                                            break;
                                        case "Rankine":
                                            toDesiredUnit = (toCelsius * (9.0 / 5.0)) + 491.67;
                                            break;
                                        case "Delisle":
                                            toDesiredUnit = (100 - toCelsius) * (2 / 3.0);
                                            break;
                                        case "Newton":
                                            toDesiredUnit = toCelsius * 33 / 100.0;
                                            break;
                                        case "Reaumur":
                                            toDesiredUnit = toCelsius * 4.5;
                                            break;
                                        case "Rømer":
                                            toDesiredUnit = ((toCelsius * (21 / 40.0)) + 7.5);
                                            break;
                                        default:
                                            toDesiredUnit = toCelsius;
                                            break;
                                    }
                                    outputText.append(String.format(numOfDecimalPoints, toDesiredUnit) + ",");
                                    break;
                                case "Time":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)timeArray[unitInputIndex][1])
                                            * ((Double)timeArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Torque":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)torqueArray[unitInputIndex][1])
                                            * ((Double)torqueArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Trigonometry":
                                    double value = Double.parseDouble(inputString);
                                    double radian = 0.0;
                                    switch (unitInput) {
                                        case "Degree":
                                            radian = Math.toRadians(value);
                                            break;
                                        case "Radian":
                                            break;
                                        case "Sine":
                                            radian = Math.asin(value);
                                            break;
                                        case "Cosine":
                                            radian = Math.acos(value);
                                            break;
                                        case "Tangent":
                                            radian = Math.atan(value);
                                            break;
                                        case "Secant":
                                            radian = 1/Math.acos(value);
                                            break;
                                        case "Cosecant":
                                            radian = 1/Math.asin(value);
                                            break;
                                        case "Cotangent":
                                            radian = 1/Math.atan(value);
                                            break;
                                        default:
                                            radian = value;
                                            break;
                                    }
                                    double output = 0.0;
                                    switch (Objects.requireNonNull(unitOutput)) {
                                        case "Degree":
                                            output = Math.toDegrees(radian);
                                            break;
                                        case "Sine":
                                            output = Math.sin(radian);
                                            break;
                                        case "Cosine":
                                            output = Math.cos(radian);
                                            break;
                                        case "Tangent":
                                            output = Math.tan(radian);
                                            break;
                                        case "Secant":
                                            output = 1/Math.cos(radian);
                                            break;
                                        case "Cosecant":
                                            output = 1/Math.sin(radian);
                                            break;
                                        case "Cotangent":
                                            output = 1/Math.tan(radian);
                                            break;
                                    }
                                    finalVal = output;
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Velocity(Angular)":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)velocityAngularArray[unitInputIndex][1])
                                            * ((Double)velocityAngularArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                case "Volume":
                                    finalVal = Double.parseDouble(inputString)
                                            * ((Double)volumeArray[unitInputIndex][1])
                                            * ((Double)volumeArray[unitOutputIndex][2]);
                                    outputText.append(String.format(numOfDecimalPoints, finalVal) + ",");
                                    break;
                                default:
                                    outputText.append(inputString);
                                    break;
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Input contains invalid values, denoted with 'INV'.", Toast.LENGTH_LONG).show();
                            outputText.append("INV,");
                        }
                    }
                    if(outputText.getText().toString().length() > 1) {
                        outputText.setText(outputText.getText().toString().substring(0, outputText.getText().toString().length()-1));
                    }
                    outputText.append("\n");
                }
            }
        });

        copyButton.setOnClickListener(v -> {
            if(!outputText.getText().toString().equals("")) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("copiedText", outputText.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Text copied to clipboard.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Output is empty.", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public String baseFinder(int n, int c, boolean floatActive, String afterFloat, int afterLength) {
        int q=n, r, a=0,s=0;
        String decimal; double doubleRes = 0.0;
        while (q > 0) {
            r = n % 10;
            q = n / 10;
            a = (int) (a + (r * Math.pow(c, s)));
            n = q;
            s++;
        }
        decimal = String.valueOf(a);
        if (floatActive) {
            s = 1;
            for (int g = 0; g < afterLength; g++) {
                doubleRes = (doubleRes + (Math.pow(c, -s) * Integer.parseInt(afterFloat.charAt(g) + "")));
                s++;
            }
            decimal = String.valueOf(Double.parseDouble(decimal) + doubleRes);
        }
        return decimal;
    }

    public String baseInverter(int n, int c, String afterFloat, double decimalDouble, String beforeFloat) {
        int q=n, r;
        String rev="", output="";
        double doubleRes;
        while (q > 0) {
            r = n % c;
            q = n / c;
            n = q;
            rev = rev.concat(String.valueOf(r));
        }
        for (int g = rev.length() - 1; g >= 0; g--) {
            output = output.concat(String.valueOf(rev.charAt(g)));
        }
        if (!afterFloat.equals("0")) {
            rev = "";
            int max = 0;
            doubleRes = decimalDouble - Double.parseDouble(beforeFloat);
            while ((doubleRes > 0.0) && (max < 100)) {
                doubleRes = doubleRes * c;
                rev = rev.concat(String.valueOf((int) doubleRes));
                doubleRes = doubleRes - ((int) doubleRes);
                max++;
            }
            output = output.concat(".".concat(rev));
        }
        return output;
    }
}
