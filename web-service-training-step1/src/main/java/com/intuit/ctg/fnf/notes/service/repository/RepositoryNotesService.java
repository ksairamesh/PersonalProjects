package com.intuit.ctg.fnf.notes.service.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.ctg.fnf.notes.entity.Note;
import com.intuit.ctg.fnf.notes.repository.NotesRepository;
import com.intuit.ctg.fnf.notes.service.NotesService;

/**
 * @author mbach1
 *
 */
@Repository
public class RepositoryNotesService implements NotesService
{
	@Resource
	private NotesRepository notesRepository;

	@Transactional(readOnly = true)
	public Note getNote(Long id)
	{
		return notesRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Note> getNotes()
	{
		return notesRepository.findAll();
	}

	@Transactional
	public Note updateNote(Long id, Note note)
	{
		Note currNote = notesRepository.findOne(id);
		currNote.setValue(note.getValue());
		return notesRepository.save(currNote);
	}

	@Transactional
	public void deleteNote(Long id)
	{
		notesRepository.deleteById(id);
	}

	public Note addNote(Note note)
	{
		note.setId(null);
		return notesRepository.save(note);
	}

}
