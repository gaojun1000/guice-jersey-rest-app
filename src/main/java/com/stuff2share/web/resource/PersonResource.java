package com.stuff2share.web.resource;

import com.stuff2share.web.pojos.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jun on 2/2/16.
 */
@Path("persons")
public class PersonResource {
    public PersonResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Sam", 11));
        personList.add(new Person("Joe", 12));
        return personList;    }
}
