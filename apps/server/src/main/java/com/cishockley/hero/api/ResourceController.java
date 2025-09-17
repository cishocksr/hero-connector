package com.cishockley.hero.api;
import com.cishockley.hero.repo.ResourceRepository;
import com.cishockley.hero.model.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/resources")
public class ResourceController {
    private final ResourceRepository repo;
    public ResourceController(ResourceRepository repo){ this.repo = repo; }
    @GetMapping public List<Resource> list(){ return repo.findAll(); }
}
