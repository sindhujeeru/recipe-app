package guru.springframework.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Recipe;
import guru.springframework.repository.RecipeRepository;
import guru.springframework.services.RecipeService;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {
	
	private RecipeService recipeService;
	private RecipeRepository recipeRepository;
	
	public IndexController() {
		
	}

	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}



	@RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model theModel){
		
		/*Optional<Category> categoryOptional = categoryRepository.findByDescription("Fast Food");
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByUom("Pinch");
		
		System.out.println("Category id: "+categoryOptional.get().getId());
		System.out.println("Category id: "+uomOptional.get().getId());*/
		theModel.addAttribute("recipe", recipeService.getRecipes());
		
		
        return "index";
    }
}
