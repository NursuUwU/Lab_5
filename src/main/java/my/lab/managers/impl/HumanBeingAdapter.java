package my.lab.managers.impl;

import com.google.gson.*;
import my.lab.data.*;

import java.lang.reflect.Type;

public class HumanBeingAdapter implements JsonDeserializer<HumanBeing>, JsonSerializer<HumanBeing> {

    @Override
    public HumanBeing deserialize (JsonElement json, Type type,
                                   JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        try {
            Long id = null;
            if (jsonObject.has("id") && !jsonObject.get("id").isJsonNull()) {
                try {
                    id = jsonObject.get("id").getAsLong();
                } catch (IllegalArgumentException e) {
                    System.out.println("Ой, в файлике было некорректное значение ID O~x");
                    id = 1L;
                }
            }

            String creationDate = jsonObject.has("creationDate") && !jsonObject.get("creationDate").isJsonNull()
                    ? jsonObject.get("creationDate").getAsString()
                    : null;

            String name = jsonObject.has("name") && !jsonObject.get("name").isJsonNull()
                    ? jsonObject.get("name").getAsString()
                    : null;

            Boolean realHero = jsonObject.has("realHero") && !jsonObject.get("realHero").isJsonNull()
                    ? jsonObject.get("realHero").getAsBoolean()
                    : null;

            Boolean hasToothpick = jsonObject.has("hasToothpick") && !jsonObject.get("hasToothpick").isJsonNull()
                    ? jsonObject.get("hasToothpick").getAsBoolean()
                    : null;

            Long impactSpeed = null;
            if (jsonObject.has("impactSpeed") && !jsonObject.get("impactSpeed").isJsonNull()) {
                try {
                    impactSpeed = jsonObject.get("impactSpeed").getAsLong();
                } catch (IllegalArgumentException e) {
                    System.out.println("Ой, в файлике было некорректное значение скорости удара O~x");
                    impactSpeed = 0L;
                }
            }

            Coordinates coordinates = null;
            if (jsonObject.has("coordinates") && !jsonObject.get("coordinates").isJsonNull()) {
                JsonObject coordsJson = jsonObject.getAsJsonObject("coordinates");

                Double x = null;
                if( coordsJson.has("x") && !coordsJson.get("x").isJsonNull()) {
                    try {
                        x = coordsJson.get("x").getAsDouble();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ой, в файлике было некорректное значение координаты x O~x");
                        x = 0D;
                    }
                }


                Long y = null;
                if (coordsJson.has("y") && !coordsJson.get("y").isJsonNull()) {
                    try {
                        y = coordsJson.get("y").getAsLong();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ой, в файлике было некорректное значение координаты y O~x");
                        y = 0L;
                    }
                }

                coordinates = new Coordinates(x, y);

            }


            String weaponType = jsonObject.has("weaponType") && !jsonObject.get("weaponType").isJsonNull()
                    ? jsonObject.get("weaponType").getAsString()
                    : null;

            String mood = jsonObject.has("mood") && !jsonObject.get("mood").isJsonNull()
                    ? jsonObject.get("mood").getAsString()
                    : null;

            Car car = null;
            if (jsonObject.has("car") && !jsonObject.get("car").isJsonNull()) {
                JsonObject carJson = jsonObject.getAsJsonObject("car");

                String carName = carJson.has("name") && !carJson.get("name").isJsonNull()
                        ? carJson.get("name").getAsString()
                        : null;

                Boolean cool = carJson.has("cool") && !carJson.get("cool").isJsonNull()
                        ? carJson.get("cool").getAsBoolean()
                        : null;

                car = new Car(carName, cool);
            }

            return new HumanBeing(id, creationDate, name, realHero, hasToothpick, impactSpeed, coordinates, weaponType, mood, car);
        } catch (Exception e) {
            throw new JsonParseException("Ой, при загрузке данных из файлика произошла ошибочка TwT");
        }
    }

    @Override
    public JsonElement serialize (HumanBeing src, Type type, JsonSerializationContext context) {
        JsonObject jsonObj = new JsonObject();
        jsonObj.addProperty("id", src.getId());
        jsonObj.addProperty("name", src.getName());
        jsonObj.add("coordinates", context.serialize(src.getCoordinates()));
        jsonObj.addProperty("creationDate", src.getCreationDate().toString());
        jsonObj.addProperty("realHero", src.getRealHero());
        jsonObj.addProperty("hasToothpick", src.isHasToothpick());
        jsonObj.addProperty("impactSpeed", src.getImpactSpeed());
        jsonObj.addProperty("weaponType", src.getWeaponType().toString());
        jsonObj.addProperty("mood", src.getMood().toString());
        jsonObj.add("car", context.serialize(src.getCar()));

        return jsonObj;
    }
}
