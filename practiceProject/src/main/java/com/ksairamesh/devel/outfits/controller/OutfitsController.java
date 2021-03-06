package com.ksairamesh.devel.outfits.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ksairamesh.devel.outfits.entity.Outfit;
import com.ksairamesh.devel.outfits.service.OutfitsService;



@RestController
@RequestMapping(value = "/v1/outfits/", produces = { APPLICATION_JSON_VALUE })
public class OutfitsController {

	
	public static final String OUTFITS_INDEX = "/{index}";
	
		@SuppressWarnings("restriction")
		@Resource
		private OutfitsService outfitsService;
		
		@RequestMapping(method = RequestMethod.GET)
		public List<Outfit> getNotes()
		{
			return outfitsService.getOutfits();
		}

		@RequestMapping(value = OUTFITS_INDEX, method = RequestMethod.GET)
		public Outfit getOutfitById(@PathVariable long id)
		{
			return outfitsService.getOutfitById(id);
		}

		@RequestMapping(method = RequestMethod.POST, consumes = { APPLICATION_JSON_VALUE })
		public Outfit addOutfit(@RequestBody @Valid Outfit outfit)
		{
			return outfitsService.addOutfit(outfit);
		}


		@RequestMapping(value = OUTFITS_INDEX, method = RequestMethod.DELETE)
		public void deleteOutfitById(@PathVariable long id)
		{
			outfitsService.deleteOutfitById(id);
		}
	
}
