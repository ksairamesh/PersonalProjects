package com.ksairamesh.devel.outfits.service;

import java.util.List;

import com.ksairamesh.devel.outfits.entity.Outfit;

public interface OutfitsService {

		public Outfit getOutfitById(Long id);
		public List<Outfit> getOutfits();
		public Outfit addOutfit(Outfit outfit);
		public void deleteOutfitById(Long id);

	
}