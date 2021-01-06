package model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

//Reads Json String and stores specific values into array lists
public class readJson {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> weights = new ArrayList<>();
    private ArrayList<Integer> heights = new ArrayList<>();
    private ArrayList<String> colors = new ArrayList();
;
    public readJson(String object){

        JsonParser parser = new JsonParser();


        Object obj = parser.parse(object);
        JsonArray jsonArray = (JsonArray) obj;

        for(int i =0; i<jsonArray.size(); i++){
            JsonElement toki = jsonArray.get(i);

            JsonObject jsonObj = toki.getAsJsonObject();
            JsonElement name = jsonObj.get("name");
            names.add(name.getAsString());
            JsonElement weight = jsonObj.get("weight");
            weights.add(weight.getAsInt());
            JsonElement height = jsonObj.get("height");
            heights.add(height.getAsInt());
            JsonElement color = jsonObj.get("color");
            colors.add(color.getAsString());
        }
    }

    public int getAmount(){
        return names.size();
    }

    public String getName(int index){
        return names.get(index);
    }

    public int getWeight(int index){
        return weights.get(index);
    }

    public int getHeight(int index){
        return heights.get(index);
    }

    public String getColor(int index){
        return colors.get(index);
    }

}
