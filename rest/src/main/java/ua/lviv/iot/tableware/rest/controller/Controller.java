

package ua.lviv.iot.tableware.rest.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.tableware.rest.model.DisponsableTableWare;

@RequestMapping("/glasses")
@RestController
public class Controller {
    private static Map<Integer, DisponsableTableWare> glasses = new HashMap<>();
    private static AtomicInteger counter = new AtomicInteger();

    @GetMapping
    public final List<DisponsableTableWare> getGlass() {
        return new LinkedList<DisponsableTableWare>(glasses.values());
    }

    @GetMapping(path = "/{id}")
    public final DisponsableTableWare getGlass(final @PathVariable("id") Integer id) {
        System.out.println(id);
        return glasses.get(id);
    }

    @PutMapping(path = "{id}")
    public DisponsableTableWare putGlass(final @PathVariable("id") Integer id,
            final @RequestBody DisponsableTableWare glass) {
        glass.setId(id);
        return  glasses.put(id, glass);
    }

    @DeleteMapping(path = "{id}")
    public final ResponseEntity<Object> deleteGlass(final @PathVariable("id") Integer id) {
        HttpStatus status = glasses.remove(id) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }

      @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public DisponsableTableWare createGlass(final @RequestBody DisponsableTableWare glasselement) {
        glasselement.setId(counter.incrementAndGet());
        glasses.put(glasselement.getId(), glasselement);
        return glasselement;
      }
}
