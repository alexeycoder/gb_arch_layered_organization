package edu.alexey.editor3d.db;

import java.util.Collection;

import edu.alexey.editor3d.entities.Entity;

/**
 * Интерфейс БД
 */
public interface Database {

	void load();

	void save();

	Collection<Entity> getAll();

}
