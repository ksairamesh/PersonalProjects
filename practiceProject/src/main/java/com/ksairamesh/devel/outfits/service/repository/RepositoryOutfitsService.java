package com.ksairamesh.devel.outfits.service.repository;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import com.ksairamesh.devel.outfits.entity.Outfit;
import com.ksairamesh.devel.outfits.repository.OutfitsRepository;

@Repository
public class RepositoryOutfitsService {

	@Resource
	private OutfitsRepository outfitsRepository;

	@Transactional(readOnly = true)
	public Outfit getOutfitById(Long id)
	{
		return outfitsRepository.findOne(id);
	}

	@Transactional
	public Outfit addOutfit(Outfit outfit)
	{
		return outfitsRepository.save(outfit);
	}

	@Transactional
	public void deleteOutfitById(Long id)
	{
		outfitsRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<Outfit> getOutfits()
	{
		return outfitsRepository.findAll();
	}

}
