package com.epam.tc.hw7.data;

import com.epam.tc.hw7.entity.MetalsAndColors;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.testng.annotations.DataProvider;


public class MetalsAndColorsDataProvider {
    public static final String PATH_TO_DATA_FILES = "src/test/resources/com.epam.tc.hw7/data/"
            + "JDI_ex8_metalsColorsDataSet.json";

    @DataProvider
    public static Object[][] getDataFromJson() throws FileNotFoundException {
        JsonObject metalsColorsData = JsonParser.parseReader(
                        new FileReader(PATH_TO_DATA_FILES))
                .getAsJsonObject();
        Gson gson = new Gson();
        return metalsColorsData.keySet().stream()
                .map(key -> gson.fromJson(metalsColorsData.get(key), MetalsAndColors.class))
                .map(value -> new MetalsAndColors[]{value})
                .toArray(Object[][]::new);
    }
}
