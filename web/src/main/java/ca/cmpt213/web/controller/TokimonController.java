package ca.cmpt213.web.controller;


import ca.cmpt213.web.model.Tokimon;
import com.google.gson.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TokimonController {
    private int counter;
    private List<Tokimon> tokimon = new ArrayList<>();

    //Returns List of Tokimons
    @GetMapping("/api/tokimon/all")
    public List<Tokimon> getTokimons(HttpServletResponse response){
        response.setStatus(200);
        return tokimon;
    }

    //Returns specific id tokimon
    @GetMapping("/api/tokimon/{id}")
    public Tokimon getTokimon(@PathVariable int id, HttpServletResponse response){
        if(tokimon.size() < id || 1 > id){
            response.setStatus(404);
            System.out.println("tokimon id is out of bounds!");
            return null;
        }else {
            response.setStatus(200);
            return tokimon.get(id - 1);
        }
    }

    //Adds new Tokimon to tokimon list
    @PostMapping("/api/tokimon/add")
    public void addTokimon(@RequestBody Tokimon newTokimon, HttpServletResponse response){
        counter = tokimon.size() + 1;
        newTokimon.setId(counter);

        tokimon.add(newTokimon);
        response.setStatus(201);
        updateJsonFile();

    }

    //Allows the alteration of Tokimon height
    @PostMapping("/api/tokimon/change/{id}")
    public void alterTokimon(@PathVariable int id, @RequestParam(value="height", defaultValue="50") int col, HttpServletResponse response){
        if(tokimon.size() < id || 1 > id){
            response.setStatus(404);
            System.out.println("tokimon id is out of bounds!");
        }else{
            tokimon.get(id-1).setHeight(col);
            response.setStatus(201);
            updateJsonFile();
        }
    }

    //Removes id tokimon
    @DeleteMapping("api/tokimon/{id}")
    public void deleteTokimon(@PathVariable int id, HttpServletResponse response){
        if(tokimon.size() < id || 1 > id){
            response.setStatus(404);
            System.out.println("tokimon id is out of bounds!");
        }else {
            tokimon.remove(id - 1);
            response.setStatus(204);
            updateJsonFile();
        }
    }


    //Code Executed when spring beans are initialized
    @PostConstruct
    public void InitIT(){
        File tokimonStorage = new File("data/tokimon.json");

        JsonParser parser = new JsonParser();

        try {
            //Reads into tokimon.json file and stores data as Tokimon objects
            Object obj =parser.parse(new FileReader(tokimonStorage));
            JsonArray jsonArray = (JsonArray) obj;

            for(int i =0; i<jsonArray.size(); i++){
                JsonElement toki = jsonArray.get(i);
                String tokiJson = toki.toString();

                Gson gson = new Gson();
                Tokimon newToki = gson.fromJson(tokiJson, Tokimon.class);
                tokimon.add(newToki);

            }

        } catch(ClassCastException e){

        } catch(IOException e){
            e.printStackTrace();
        }

    }

    //Updates Tokimon.json file with latest changes
    public void updateJsonFile(){
        Gson gson = new Gson();
        String json = gson.toJson(tokimon);

        try{
            FileWriter filewriter = new FileWriter("data/tokimon.json", false);
            filewriter.write(json);
            filewriter.flush();
            filewriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
