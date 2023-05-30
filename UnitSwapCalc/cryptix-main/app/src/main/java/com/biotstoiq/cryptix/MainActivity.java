package com.biotstoiq.cryptix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String typeExtra = "te";
    public static final String unitInputExtra = "uie";
    public static final String unitOutputExtra = "uoe";
    public static final String unitInputIndexExtra = "uiie";
    public static final String unitOutputIndexExtra = "uoie";
    public static final String numOfDecimalPointsExtra = "nodpe";
    String typeStringPub = "";

    static String[] typesArray;
	static String[] accelerationUnits;
    static String[] accelerationAngularUnits;
    static String[] angleUnits;
    static String[] areaUnits;
    static String[] baseUnits;
    static String[] codeUnits;
    static String[] cookingUnits;
    static String[] currentUnits;
    static String[] chargeUnits;
    static String[] dataUnits;
    static String[] densityUnits;
    static String[] energyUnits;
    static String[] footwearUnits;
    static String[] forceUnits;
    static String[] heatDensityUnits;
    static String[] illuminationUnits;
    static String[] inductanceUnits;
    static String[] lengthUnits;
    static String[] luminanceUnits;
    static String[] luminousIntensityUnits;
    static String[] magneticFluxUnits;
    static String[] magneticFluxDensityUnits;
    static String[] massUnits;
    static String[] powerUnits;
    static String[] pressureUnits;
    static String[] permeabilityUnits;
    static String[] radiationUnits;
    static String[] radiationActivityUnits;
    static String[] radiationExposureUnits;
    static String[] resistanceUnits;
    static String[] speedUnits;
    static String[] surfaceTensionUnits;
    static String[] temperatureUnits;
    static String[] timeUnits;
    static String[] trigonometryUnits;
    static String[] torqueUnits;
    static String[] velocityAngularUnits;
    static String[] volumeUnits;

    static String[] typeTempArr;
    static String[] unitTempArr;

    static String[] typeTempArrFinal;
    static String[] unitTempArrFinal;

    ListView typeInputList;
    ListView unitInputList;
    ListView unitOutputList;

    ArrayAdapter<String> typeListAdapter;
    ArrayAdapter<String> unitListAdapter;

    EditText typeInputSearchText;
    EditText unitInputSearchText;
    EditText unitOutputSearchText;

    Button inverseButton;
    Button goButton;

    static int latestTypeListItemPos = 0;
    static int latestUnitInputListItemPos = 0;
    static int latestUnitOutputListItemPos = 0;
    static int numOfDecimalPoints;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setPrefs();

        typesArray = new String[]
                {"Acceleration", "Acceleration(Angular)", "Angle", "Area", "Base", "Charge", "Code",
                        "Cooking", "Current", "Density", "Energy", "Footwear size", "Force",
                        "Heat Density", "Illumination", "Inductance", "Length", "Luminance",
                        "Luminous intensity", "Magnetic Flux", "Magnetic Flux Density", "Mass", "Permeability",
                        "Power", "Pressure", "Radiation", "Radiation Activity", "Radiation Exposure",
                        "Resistance", "Speed/Velocity", "Speed(Data)", "Surface Tension", "Temperature", "Time",
                        "Torque", "Trigonometry", "Velocity(Angular)", "Volume"};
        accelerationUnits = new String[]
                {"Acceleration of gravity", "Attometre/square second", "Centimetre/square second",
                        "Decametre/square second", "Decimetre/square second", "Femtometre/square second",
                 "Foot/square second", "Gal", "Galileo", "Hectometre/square second", "Inch/square metre",
                        "Kilometre/square second", "Metre/square second", "Micrometre/square second",
                 "Mile/square second", "Millimetre/square second", "Nanometre/square second",
                        "Picometre/square second", "Yard/square second"};
        accelerationAngularUnits = new String[]
                {"Radian/square second", "Radian/Square minute", "Revolution/square second",
                        "Revolution/minute/second", "Revolution/square metre"};
        angleUnits = new String[]
                {"Binary degree", "Degree", "Grad", "Hexacontade", "Minute of arc",
                "Pi", "Quadrant", "Radian", "Sextant",
                "Second of arc", "Turn"};
        areaUnits = new String[]
                {"Acre", "Are", "Barn", "Brass", "Cent", "Hectare", "Square", "Square centimetre",
                "Square foot", "Square kilometre", "Square metre", "Square mile", "Square millimetre",
                "Square yard"};
        baseUnits = new String[]
                {"Binary", "Decimal", "Hexadecimal", "Nonary", "Octal", "Quaternary", "Quinary",
                "Septenary", "Ternary"};
        codeUnits = new String[]
                {"Alphanumeral", "ASCII", "Caesar cipher(key=2)", "Caesar cipher(key=3)", "Morse code"};
        currentUnits = new String[]
                {"Abampere", "Ampere", "Biot", "CGS em unit", "CGS es unit", "EMU of current",
                 "ESU of current", "Kiloampere", "Milliampere", "Statampere"};
        chargeUnits = new String[]
                {"Abcoulomb", "Ampere-Hour", "Ampere-Minute", "Ampere-Second", "Coulomb", "Elementary charge",
                 "EMU of charge", "ESU of charge", "Faraday", "Franklin", "Kilocoulomb", "Millicoulomb", "Megacoulomb",
                 "Microcoulomb", "Millicoulomb", "Nanocoulomb", "Picocoulomb", "Statcoulomb"};
        cookingUnits = new String[]
                {"Cup", "Dessertspoon", "Fluid ounce", "Gill", "Millilitre", "Pint", "Quart",
                "Tablespoon", "Teaspoon"};
        dataUnits = new String[]
                {"Bit/second", "Byte/second", "Gigabit/second", "Gigabyte/second", "Kilobit/second", "Kilobyte/second",
                "Megabit/second", "Megabyte/second", "Terabit/second", "Terabyte/second"};
        densityUnits = new String[]
                {"Gram/cubic centimetre", "Gram/millilitre",
                "Kilogram/cubic decimetre", "Kilogram/cubic metre", "Kilogram/litre",
                "Tonne/cubic metre"};
        energyUnits = new String[]
                {"British thermal unit", "Calorie", "Electron volt", "Erg", "Foe", "Foot pound force",
                "Gasoline gallon", "Horsepower-hour", "Joule",
                "Kilowatt-hour", "Quad", "Therm"};
        footwearUnits = new String[]
                {"Centimetre", "EU", "UK", "US(Kids')", "US(Men's)", "US(Women's)"};
        forceUnits = new String[]
                {"Dyne", "Kilogram-force", "Newton", "Pound-force",
                "Poundal", "Sthène", "Tonforce"};
        heatDensityUnits = new String[]
                {"Joule/square metre", "Calorie(th)/square centimetre", "Langley", "BTU(IT)/square foot", "BTU(th)/square foot"};
        illuminationUnits = new String[]
                {"Candela steradian/metre", "Centimetre-candle", "Flame", "Foot-candle", "Lumen/square centimetre",
                        "Lumen/square foot", "Lumen/square metre", "Lux", "Metre-candle", "Nox", "Phot", "Watt/square metre"};
        inductanceUnits = new String[]
                {"Abhenry", "EMU of inductance", "ESU of inductance", "Henry", "Stathenry", "Weber/ampere"};
        lengthUnits = new String[]
                {"Attometre", "Barleycorn", "Boat length", "Cable", "Centimetre", "Chain",
                "Decametre", "Decimetre", "Fathom", "Femtometre", "Foot", "Furlong", "Gigametre",
                "Hammer", "Hand", "Hectometre", "Horse", "Inch", "Kilometre", "League", "Light year", "Link", "Megametre",
                "Metre", "Micrometre", "Mile", "Millimetre", "Nanometre", "Nautical mile", "Picometre",
                "Rack unit", "Rod/Perch/Pole/Lug", "Terametre", "Thou", "Yard", "Yoctometre", "Zeptometre",
                "Zetametre"};
        luminanceUnits = new String[]
                {"Apostilb", "Blondel", "Bril", "Candela/square centimetre", "Candela/square foot",
                        "Candela/square inch", "Candela/square metre", "Foot-lambert", "Kilocandela/square metre",
                        "Lambert", "Lumen/square centimetre/steradian", "Lumen/square foot/steradian",
                        "Lumen/square metre/steradian",
                        "Millilambert", "Millinit", "Nit", "Skot", "Stilb", "Watt/square centimetre/steradian"};
        luminousIntensityUnits = new String[]
                {"Candela", "Candlepower", "Carcel", "Hefnerkerze", "Violle"};
        magneticFluxUnits = new String[]
                {"Gauss square centimetre", "Kiloline", "Line", "Magnetic flux quantum", "Maxwell",
                        "Megaline", "Microweber", "Milliweber", "Tesla square metre",
                        "Tesla square centimetre", "Unit pole", "Volt second", "Weber"};
        magneticFluxDensityUnits = new String[]
                {"Gamma", "Gauss", "Line/square centimetre", "Line/square inch", "Maxwell/square centimetre",
                        "Maxwell/square inch", "Maxwell/square metre", "Tesla", "Weber/square centimetre",
                        "Weber/square inch", "Weber/square metre"
                };
        massUnits = new String[]
                {"Attogram", "Carat", "Decagram", "Decigram", "Femtogram", "Gigagram",
                "Grain", "Gram", "Hectogram", "Kilogram", "Megagram", "Microgram", "Milligram",
                "Nanogram", "Ounce", "Picogram", "Pound", "Slug", "Stone", "Teragram", "Tonne",
                "Yoctogram", "Zeptogram", "Zetagram"};
        permeabilityUnits = new String[]
                {"Kilogram/pascal/square metre", "Permeability(0°C)", "Permeability(23°C)",
                        "Permeability inch(0°C)", "Permeability inch(23°C)"
                };
        powerUnits = new String[]
                {"British thermal unit/hour", "Calorie/hour", "Decibel-milliwatt", "Erg/second",
                "Foot pound force/min", "Horsepower", "Watt"};
        pressureUnits = new String[]
                {"Atmospheric pressure", "Bar", "Barye", "Foot sea water", "Metric sea water",
                "Pascal", "Pièze", "Pound/square inch", "Technical atmosphere", "Torr"};
        radiationUnits = new String[]
                {"Attogray/second", "Centigray/second", "Decagray/second", "Decigray/second", "Exagray/second",
                "Femtogray/second", "Gigagray/second", "Gray/second", "Hectogray/second", "Joule/kilogram/second",
                        "Kilogray/second", "Megagray/second", "Microgray/second", "Milligray/second",
                        "Nanogray/second", "Petagray/second", "Picogray/second", "Rad/second",
                        "Rem/second", "Sievert/second", "Teragray/second", "Watt/kilogram", "Yoctogray/second",
                        "Zeptogray/second", "Zetagray/second"};
        radiationActivityUnits = new String[]
                {"Becquerel", "Curie", "Gigabecquerel", "Kilobecquerel", "Kilocurie",
                        "Megabecquerel", "Microcurie", "Millibecquerel", "Millicurie", "Nanocurie", "Picocurie",
                        "Terabecquerel", "Rutherford", "One/second", "Disintegration/second"
                };
        radiationExposureUnits = new String[]
                {"Coulomb/kilogram", "Millicoulomb/kilogram", "Microcoulomb/kilogram", "Parker",
                        "Rep", "Roentgen", "Tissue roentgen"
                };
        resistanceUnits = new String[]
                {"Abohm/Emu resistance", "Kiloohm", "Megaohm", "Ohm", "Statohm"};
        speedUnits = new String[]
                {"Centimetre/second", "Kilometre/hour", "Kilometre/second",
                "Knot", "Mach", "Metre/hour", "Metre/second", "Mile/hour", "Mile/second", "Speed of light"};
        surfaceTensionUnits = new String[]
                {"Dyne/centimetre", "Erg/square centimetre", "Erg/square millimetre",
                        "Gram-force/centimetre", "Millinewton/metre", "Newtom/metre", "Pound-force/inch",
                        "Poundal/inch"
                };
        temperatureUnits= new String[]
                {"Celsius", "Delisle", "Fahrenheit", "Kelvin", "Newton", "Rankine",
                "Réaumur", "Rømer"};
        timeUnits = new String[]
                {"Day", "Fortnight", "Hour", "Ke", "Leap year", "Minute", "Moment", "Month",
                "Quarter", "Second", "Semester", "Sol", "Week", "Year"};
        torqueUnits = new String[]
                {"Dyne centimetre", "Dyne metre", "Dyne millimetre", "Gram-force centimetre",
                        "Gram-force metre", "Gram-force millimetre", "Kilogram-force centimetre",
                        "Kilogram-force metre", "Kilogram-force millimetre", "Kilonewton metre",
                        "Newton centimetre", "Newton metre", "Newton millimetre", "Ounce-force foot",
                        "Ounce-force inch", "Pound-force foot", "Pound-force inch"
                };
        trigonometryUnits = new String[]
                {"Cosecant", "Cosine", "Cotangent", "Degree", "Radian", "Sine", "Secant", "Tangent"};
        velocityAngularUnits = new String[]
                {"Degree/day", "Degree/hour", "Degree/minute", "Degree/second", "Radian/day",
                        "Radian/hour", "Radian/minute", "Radian/second", "Revolution/day", "Revolution/hour",
                        "Revolution/minute", "Revolution/second"
                };
        volumeUnits = new String[]
                {"Barrel", "Board foot", "Cord", "Cubic centimetre", "Cubic decimetre",
                "Cubic foot", "Cubic inch", "Cubic metre", "Cubic yard", "Gallon", "Hoppus cubic foot",
                "Hoppus ton", "Litre", "Millilitre", "Pint", "Raummeter/Stere"};

        typeTempArr = new String[typesArray.length];
        unitTempArr = new String[accelerationUnits.length+accelerationAngularUnits.length+angleUnits.length+
                areaUnits.length+baseUnits.length+chargeUnits.length+
                codeUnits.length+cookingUnits.length+currentUnits.length+dataUnits.length+densityUnits.length+energyUnits.length+
                footwearUnits.length+forceUnits.length+heatDensityUnits.length+illuminationUnits.length+
                inductanceUnits.length+lengthUnits.length+luminanceUnits.length+luminousIntensityUnits.length+
                magneticFluxUnits.length+magneticFluxDensityUnits.length+massUnits.length+permeabilityUnits.length+
                powerUnits.length+pressureUnits.length+radiationUnits.length+radiationActivityUnits.length+
                radiationExposureUnits.length+resistanceUnits.length+speedUnits.length+surfaceTensionUnits.length+
                temperatureUnits.length+timeUnits.length+torqueUnits.length+trigonometryUnits.length+
                velocityAngularUnits.length+volumeUnits.length];

        typeInputList = findViewById(R.id.typeInputList);
        unitInputList = findViewById(R.id.unitInputList);
        unitOutputList = findViewById(R.id.unitOutputList);

        typeInputSearchText = findViewById(R.id.typeInputSearchText);
        unitInputSearchText = findViewById(R.id.unitInputSearchText);
        unitOutputSearchText = findViewById(R.id.unitOutputSearchText);

        inverseButton = findViewById(R.id.inverseButton);
        goButton = findViewById(R.id.goButton);

        typeListAdapter = new ArrayAdapter<>(this,
                R.layout.activity_list, R.id.label, typesArray);

        typeInputList.setAdapter(typeListAdapter);
        typeInputList.setSelection(0);
        typeStringPub = typeInputList.getItemAtPosition(0).toString();

        typeInputList.setOnItemClickListener(typeInputListMessageClickedHandler);
        unitInputList.setOnItemClickListener(unitInputListMessageClickedHandler);
        unitOutputList.setOnItemClickListener(unitOutputListMessageClickedHandler);

        unitListAdapter = new ArrayAdapter<>(this,
                R.layout.activity_list, R.id.label, angleUnits);

        unitInputList.setAdapter(unitListAdapter);
        unitOutputList.setAdapter(unitListAdapter);

        unitInputList.setSelection(0);
        unitOutputList.setSelection(0);

        typeInputSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int g = 0;
                Arrays.fill(typeTempArr, "");
                String typeSearchInput = s.toString();
                if(typeSearchInput.equals("")) {
                    typeInputList.setAdapter(typeListAdapter);
                }
                if(!typeSearchInput.equals("")) {
                    typeSearchInput = typeSearchInput.toLowerCase();
                    for (int i = 0; i < typeTempArr.length; i++) {
                        if ((typesArray[i].toLowerCase()).contains(typeSearchInput)) {
                            typeTempArr[g] = typesArray[i];
                            g++;
                        }
                    }
                    if(g!=0) {
                        typeTempArrFinal = new String[g];
                        System.arraycopy(typeTempArr, 0, typeTempArrFinal, 0, g);
                        typeListAdapter = new ArrayAdapter<>(MainActivity.this,
                                R.layout.activity_list, R.id.label, typeTempArrFinal);
                        typeInputList.setAdapter(typeListAdapter);
                    }
                } else {
                    typeListAdapter = new ArrayAdapter<>(MainActivity.this,
                            R.layout.activity_list, R.id.label, typesArray);
                    typeInputList.setAdapter(typeListAdapter);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        unitInputSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Arrays.fill(unitTempArr, "");
                updateList(s.toString(), false);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String unitSearchInput = s.toString();
                if (unitSearchInput.equals("")) {
                    updateAdapter(typeStringPub);
                    unitInputList.setAdapter(unitListAdapter);
                }
            }
        });

        unitOutputSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Arrays.fill(unitTempArr,"");
                updateList(s.toString(), true);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override public void afterTextChanged(Editable s) {
                String unitSearchOutput = s.toString();
                if(unitSearchOutput.equals("")) {
                    updateAdapter(typeStringPub);
                    unitOutputList.setAdapter(unitListAdapter);
                }
            }
        });

        inverseButton.setOnClickListener(v -> {
            unitInputList.requestFocusFromTouch();
            unitInputList.setSelection(latestUnitOutputListItemPos);
            unitOutputList.requestFocusFromTouch();
            unitOutputList.setSelection(latestUnitInputListItemPos);
            int temp;
            temp = latestUnitInputListItemPos;
            latestUnitInputListItemPos = latestUnitOutputListItemPos;
            latestUnitOutputListItemPos = temp;
            Toast.makeText(getApplicationContext(),
                    unitInputList.getItemAtPosition(latestUnitInputListItemPos) + " To " +
                            unitOutputList.getItemAtPosition(latestUnitOutputListItemPos),
                            Toast.LENGTH_SHORT).show();
        });
        goButton.setOnClickListener(v -> {
            String type, unitInput, unitOutput;
            Intent showResultIntent = new Intent(MainActivity.this, ShowResultActivity.class);
            type = typeInputList.getItemAtPosition(latestTypeListItemPos).toString();
            unitInput = unitInputList.getItemAtPosition(latestUnitInputListItemPos).toString();
            unitOutput = unitOutputList.getItemAtPosition(latestUnitOutputListItemPos).toString();
            if(!type.equals("")) {
                if(unitInput.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please select the input unit.", Toast.LENGTH_SHORT).show();
                }
                if(unitOutput.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please select the output unit.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Please select the type.", Toast.LENGTH_SHORT).show();
            }
            showResultIntent.putExtra(typeExtra, type);
            showResultIntent.putExtra(unitInputExtra, unitInput);
            showResultIntent.putExtra(unitOutputExtra, unitOutput);
            showResultIntent.putExtra(unitInputIndexExtra, latestUnitInputListItemPos);
            showResultIntent.putExtra(unitOutputIndexExtra, latestUnitOutputListItemPos);
            showResultIntent.putExtra(numOfDecimalPointsExtra, numOfDecimalPoints);
            startActivity(showResultIntent);
        });
    }

    final private AdapterView.OnItemClickListener typeInputListMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {

            latestTypeListItemPos = position;
            String typeString = (String)parent.getItemAtPosition(position);
            typeStringPub = typeString;
            typeInputList.setSelection(latestTypeListItemPos);

            updateAdapter(typeString);

            unitInputList.setAdapter(unitListAdapter);
            unitOutputList.setAdapter(unitListAdapter);

            unitInputList.setSelection(0);
            unitOutputList.setSelection(0);

            latestUnitInputListItemPos = 0;
            latestUnitOutputListItemPos = 0;
        }
    };

    final private AdapterView.OnItemClickListener unitInputListMessageClickedHandler =
            new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            latestUnitInputListItemPos = position;
            unitInputList.setSelection(latestUnitInputListItemPos);
        }
    };

    final private AdapterView.OnItemClickListener unitOutputListMessageClickedHandler =
            new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            latestUnitOutputListItemPos = position;
            unitOutputList.setSelection(latestUnitOutputListItemPos);
        }
    };

    public void updateAdapter(String choice) {
        switch (choice) {
            case "Acceleration":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, accelerationUnits);
                break;
            case "Acceleration(Angular)":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, accelerationAngularUnits);
                break;
            case "Angle":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, angleUnits);
                break;
            case "Area":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, areaUnits);
                break;
            case "Base":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, baseUnits);
                break;
            case "Charge":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, chargeUnits);
                break;
            case "Code":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, codeUnits);
                break;
            case "Cooking":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, cookingUnits);
                break;
            case "Current":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, currentUnits);
                break;
            case "Density":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, densityUnits);
                break;
            case "Energy":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, energyUnits);
                break;
            case "Footwear size":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, footwearUnits);
                break;
            case "Force":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, forceUnits);
                break;
            case "Heat Density":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, heatDensityUnits);
                break;
            case "Illumination":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, illuminationUnits);
                break;
            case "Inductance":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, inductanceUnits);
                break;
            case "Length":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, lengthUnits);
                break;
            case "Luminance":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, luminanceUnits);
                break;
            case "Luminous intensity":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, luminousIntensityUnits);
                break;
            case "Magnetic Flux":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, magneticFluxUnits);
                break;
            case "Magnetic Flux Density":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, magneticFluxDensityUnits);
                break;
            case "Mass":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, massUnits);
                break;
            case "Permeability":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, permeabilityUnits);
                break;
            case "Power":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, powerUnits);
                break;
            case "Pressure":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, pressureUnits);
                break;
            case "Radiation":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, radiationUnits);
                break;
            case "Radiation Activity":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, radiationActivityUnits);
                break;
            case "Radiation Exposure":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, radiationExposureUnits);
                break;
            case "Resistance":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, resistanceUnits);
                break;
            case "Speed/Velocity":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, speedUnits);
                break;
            case "Speed(Data)":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, dataUnits);
                break;
            case "Surface Tension":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, surfaceTensionUnits);
                break;
            case "Temperature":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, temperatureUnits);
                break;
            case "Time":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, timeUnits);
                break;
            case "Torque":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, torqueUnits);
                break;
            case "Trigonometry":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, trigonometryUnits);
                break;
            case "Velocity(Angular)":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, velocityAngularUnits);
                break;
            case "Volume":
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, volumeUnits);
                break;
        }
    }
    public void updateList(String unitSearch, boolean isOutput) {
        if(!unitSearch.equals("")) {
            int g=0;
            unitSearch = unitSearch.toLowerCase();
            String[] unitList= {};
            if (latestTypeListItemPos == 0) {
                unitList = Arrays.copyOf(accelerationUnits, accelerationUnits.length);
            }
            if (latestTypeListItemPos == 1) {
                unitList = Arrays.copyOf(accelerationAngularUnits, accelerationAngularUnits.length);
            }
            if (latestTypeListItemPos == 2) {
                unitList = Arrays.copyOf(angleUnits, angleUnits.length);
            }
            if (latestTypeListItemPos == 3) {
                unitList = Arrays.copyOf(areaUnits, areaUnits.length);
            }
            if (latestTypeListItemPos == 4) {
                unitList = Arrays.copyOf(baseUnits, baseUnits.length);
            }
            if (latestTypeListItemPos == 5) {
                unitList = Arrays.copyOf(chargeUnits, chargeUnits.length);
            }
            if (latestTypeListItemPos == 6) {
                unitList = Arrays.copyOf(codeUnits, codeUnits.length);
            }
            if (latestTypeListItemPos == 7) {
                unitList = Arrays.copyOf(cookingUnits, cookingUnits.length);
            }
            if (latestTypeListItemPos == 8) {
                unitList = Arrays.copyOf(currentUnits, currentUnits.length);
            }
            if (latestTypeListItemPos == 9) {
                unitList = Arrays.copyOf(densityUnits, densityUnits.length);
            }
            if (latestTypeListItemPos == 10) {
                unitList = Arrays.copyOf(energyUnits, energyUnits.length);
            }
            if (latestTypeListItemPos == 11) {
                unitList = Arrays.copyOf(footwearUnits, footwearUnits.length);
            }
            if (latestTypeListItemPos == 12) {
                unitList = Arrays.copyOf(forceUnits, forceUnits.length);
            }
            if (latestTypeListItemPos == 13) {
                unitList = Arrays.copyOf(heatDensityUnits, heatDensityUnits.length);
            }
            if (latestTypeListItemPos == 14) {
                unitList = Arrays.copyOf(illuminationUnits, illuminationUnits.length);
            }
            if (latestTypeListItemPos == 15) {
                unitList = Arrays.copyOf(inductanceUnits, inductanceUnits.length);
            }
            if (latestTypeListItemPos == 16) {
                unitList = Arrays.copyOf(lengthUnits, lengthUnits.length);
            }
            if (latestTypeListItemPos == 17) {
                unitList = Arrays.copyOf(luminanceUnits, luminanceUnits.length);
            }
            if (latestTypeListItemPos == 18) {
                unitList = Arrays.copyOf(luminousIntensityUnits, luminousIntensityUnits.length);
            }
            if (latestTypeListItemPos == 19) {
                unitList = Arrays.copyOf(magneticFluxUnits, magneticFluxUnits.length);
            }
            if (latestTypeListItemPos == 20) {
                unitList = Arrays.copyOf(magneticFluxDensityUnits, magneticFluxDensityUnits.length);
            }
            if (latestTypeListItemPos == 21) {
                unitList = Arrays.copyOf(massUnits, massUnits.length);
            }
            if (latestTypeListItemPos == 22) {
                unitList = Arrays.copyOf(permeabilityUnits, permeabilityUnits.length);
            }
            if (latestTypeListItemPos == 23) {
                unitList = Arrays.copyOf(powerUnits, powerUnits.length);
            }
            if (latestTypeListItemPos == 24) {
                unitList = Arrays.copyOf(pressureUnits, pressureUnits.length);
            }
            if (latestTypeListItemPos == 25) {
                unitList = Arrays.copyOf(radiationUnits, radiationUnits.length);
            }
            if (latestTypeListItemPos == 26) {
                unitList = Arrays.copyOf(radiationActivityUnits, radiationActivityUnits.length);
            }
            if (latestTypeListItemPos == 27) {
                unitList = Arrays.copyOf(radiationExposureUnits, radiationExposureUnits.length);
            }
            if (latestTypeListItemPos == 28) {
                unitList = Arrays.copyOf(resistanceUnits, resistanceUnits.length);
            }
            if (latestTypeListItemPos == 29) {
                unitList = Arrays.copyOf(speedUnits, speedUnits.length);
            }
            if (latestTypeListItemPos == 30) {
                unitList = Arrays.copyOf(dataUnits, dataUnits.length);
            }
            if (latestTypeListItemPos == 31) {
                unitList = Arrays.copyOf(surfaceTensionUnits, surfaceTensionUnits.length);
            }
            if (latestTypeListItemPos == 32) {
                unitList = Arrays.copyOf(temperatureUnits, temperatureUnits.length);
            }
            if (latestTypeListItemPos == 33) {
                unitList = Arrays.copyOf(timeUnits, timeUnits.length);
            }
            if (latestTypeListItemPos == 34) {
                unitList = Arrays.copyOf(torqueUnits, torqueUnits.length);
            }
            if (latestTypeListItemPos == 35) {
                unitList = Arrays.copyOf(trigonometryUnits, trigonometryUnits.length);
            }
            if (latestTypeListItemPos == 36) {
                unitList = Arrays.copyOf(velocityAngularUnits, velocityAngularUnits.length);
            }
            if (latestTypeListItemPos == 37) {
                unitList = Arrays.copyOf(volumeUnits, volumeUnits.length);
            }
            for (String Unit : unitList) {
                if ((Unit.toLowerCase()).contains(unitSearch)) {
                    unitTempArr[g] = Unit;
                    g++;
                }
            }
            if (g != 0) {
                unitTempArrFinal = new String[g];
                System.arraycopy(unitTempArr, 0, unitTempArrFinal, 0, g);
                unitListAdapter = new ArrayAdapter<>(MainActivity.this,
                        R.layout.activity_list, R.id.label, unitTempArrFinal);
                if(isOutput) {
                    unitOutputList.setAdapter(unitListAdapter);
                } else {
                    unitInputList.setAdapter(unitListAdapter);
                }
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.settings) {
            Intent showSettingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(showSettingsIntent);
            return true;
        } else if(item.getItemId() == R.id.share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Cryptix");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out Cryptix - a free, open-source code/unit converter: " +
                    "https://biotstoiq.org/software/cryptix.html");
            startActivity(Intent.createChooser(shareIntent, "Share Link"));
        }
        return false;
    }
    public void setPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = prefs.getString("themelist", "light");
        numOfDecimalPoints = prefs.getInt("numofdecimal", 10);

        switch(theme) {
            case "light":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case "dark":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case "system":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
        }
    }
    public void onResume() {
        super.onResume();
        setPrefs();
    }
}
