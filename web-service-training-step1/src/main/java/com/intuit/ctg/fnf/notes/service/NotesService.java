package com.intuit.ctg.fnf.notes.service;

import java.util.List;

import com.intuit.ctg.fnf.notes.entity.Note;

public interface NotesService
{
	public Note getNote(Long id);
	public List<Note> getNotes();
	public Note addNote(Note note);
	public Note updateNote(Long id, Note note);
	public void deleteNote(Long id);
}