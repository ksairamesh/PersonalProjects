package com.intuit.ctg.fnf.notes.controller;

import static com.intuit.ctg.fnf.notes.controller.RequestMappingPaths.NOTES_IDX_PARAM;
import static com.intuit.ctg.fnf.notes.controller.RequestMappingPaths.NOTES_PATH;
import static com.intuit.ctg.fnf.notes.controller.RequestMappingPaths.V1;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.ctg.fnf.notes.entity.Note;
import com.intuit.ctg.fnf.notes.service.NotesService;

@RestController
@RequestMapping(value = V1 + NOTES_PATH, produces = { APPLICATION_JSON_VALUE })
public class NotesController
{
	@Resource
	private NotesService notesService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Note> getNotes()
	{
		return notesService.getNotes();
	}

	@RequestMapping(value = NOTES_IDX_PARAM, method = RequestMethod.GET)
	public Note getNote(@PathVariable long id)
	{
		return notesService.getNote(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { APPLICATION_JSON_VALUE })
	public Note addNote(@RequestBody @Valid Note note)
	{
		return notesService.addNote(note);
	}

	@RequestMapping(value = NOTES_IDX_PARAM, method = RequestMethod.PUT, consumes = { APPLICATION_JSON_VALUE })
	public Note updateNote(@PathVariable long id, @RequestBody @Valid Note note)
	{
		return notesService.updateNote(id, note);
	}

	@RequestMapping(value = NOTES_IDX_PARAM, method = RequestMethod.DELETE)
	public void deleteNote(@PathVariable long id)
	{
		notesService.deleteNote(id);
	}
}