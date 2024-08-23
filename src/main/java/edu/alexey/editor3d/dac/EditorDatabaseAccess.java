package edu.alexey.editor3d.dac;

import java.util.Collection;

import edu.alexey.editor3d.db.Database;
import edu.alexey.editor3d.entities.Entity;
import edu.alexey.editor3d.entities.Model3D;
import edu.alexey.editor3d.entities.Texture;

/**
 * Реализация Data Access Component
 */
public class EditorDatabaseAccess implements DatabaseAccess {

	private final Database database;

	public EditorDatabaseAccess(Database database) {
		this.database = database;
	}

	@Override
	public void addEntity(Entity entity) {
		database.getAll().add(entity);
	}

	@Override
	public void removeEntity(Entity entity) {
		database.getAll().remove(entity);
	}

	@Override
	public Collection<Texture> getAllTextures() {
		return database.getAll().stream().filter(m -> m instanceof Texture).map(m -> (Texture) m).toList();
	}

	@Override
	public Collection<Model3D> getAllModels() {
		return database.getAll().stream().filter(m -> m instanceof Model3D).map(m -> (Model3D) m).toList();
	}

}
