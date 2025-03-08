package io.github.gandhivivek96.utils;

import com.google.gson.Gson;
import io.github.gandhivivek96.constants.Env;
import io.github.gandhivivek96.pojo.Config;
import io.github.gandhivivek96.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility {

    public static Environment readJson(Env env)  {
        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir")+"/config/config.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Config config = gson.fromJson(fileReader, Config.class);
        Environment environment = config.getEnvironments().get(env.toString());
        return environment;
    }

}
