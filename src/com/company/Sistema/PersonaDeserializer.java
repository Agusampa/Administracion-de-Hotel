package com.company.Sistema;

import com.company.Persona.Persona;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class PersonaDeserializer implements JsonDeserializer<Persona> {
    private String personaTypeElementName;
    private Gson gson;
    private Map<String, Class<? extends Persona>> personaTypeRegistry;

    public PersonaDeserializer(String personaTypeElementName){
        this.personaTypeElementName = personaTypeElementName;
        this.gson = new Gson();
        this.personaTypeRegistry = new HashMap<>();
    }

    public void registerBarnType(String personaTypeName, Class<? extends Persona> personaType   ) {
        personaTypeRegistry.put(personaTypeName, personaType);
    }
    @Override
    public Persona deserialize(JsonElement json, Type typeofT, JsonDeserializationContext context){
        JsonObject personaObject = json.getAsJsonObject();
        JsonElement personaTypeElement = personaObject.get(personaTypeElementName);

        Class<? extends Persona> personaType = personaTypeRegistry.get(personaTypeElement.getAsString());
        return gson.fromJson(personaObject,personaType);
    }
}
